package exam06;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

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
	
	public void run() {
		byte []data = new byte[100];
		try {
		while(true) {			
			is.read(data);					
			//클라이언트로 부터 수신된 데이터를 그대로 메아리!
			os.write(data);					
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



public class TCPServerEchoMultiCast {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(9006);
			System.out.println("** 서버가 가동되었습니다 **");
			
			while(true) {
				Socket socket= server.accept();
				System.out.println("** 클라이언트가 연결하였습니다. **");
			}
			
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}

}
