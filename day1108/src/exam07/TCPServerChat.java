package exam07;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ServerThread extends Thread{
	InputStream is;
	OutputStream os;
	Socket socket;
	public ServerThread(Socket socket) {
		this.socket = socket;
		try {
			is = socket.getInputStream();
			os = socket.getOutputStream();
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
	public void send(byte []arr) throws Exception {		//나와 연결된 클라이언트에게 메세지를 보내는 메소드
		os.write(arr);
	}
	public void sendAll(byte []arr) throws Exception {	//연결되어진 모든 클라이언트들에게 메세지를 보내는 메소드
		for(ServerThread st:TCPServerChat.list) {
			st.send(arr);
		}
	}
	public void run() {
		byte []data = new byte[100];
		try {
		while(true) {			
			is.read(data);
			sendAll(data);	//수신된 데이터를 방송(연결되어진 모든 클라이언트들에게 메세지를 출력)하기 위하여 sendAll을 호출한다.
			String msg = (new String(data)).trim();
			System.out.println("수신된 데이터=>"+msg);
			if(msg.equals("q!")) {
				break;
			}					
			Arrays.fill(data, (byte)0);
		}		
		is.close();
		socket.close();
		System.out.println("** 클라이언트와 연결이 끊어졌습니다. **");
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
}

public class TCPServerChat {
	//클라이언트 접속을 요청하면 그때마다 그 클라이언트를 상대할 ServerThread객체를 생성하여 list에 담을 것이다.
	public static ArrayList<ServerThread> list;
	public static void main(String[] args) {
		try {			
			list = new ArrayList<ServerThread>();
			ServerSocket server = new ServerSocket(9007);
			System.out.println("** 서버가 가동되었습니다 **");
			while(true) {
				Socket socket= server.accept();
				System.out.println("** 클라이언트가 연결하였습니다. **");
				ServerThread st = new ServerThread(socket);
				st.start();
				list.add(st);	//접속을 요청한 클라이언트를 상대할 ServerThread객체를 리스트에 담는다.
			}
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
}
