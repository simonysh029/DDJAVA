package exam05Sol;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

//메아리만 할 것이다.
public class TCPServerEcho {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(9005);
			System.out.println("**서버가 가동되었습니다.**");
			byte []data = new byte[100];
			
			while(true) {	//연결대기를 위한 반복문
				Socket socket = server.accept();
				System.out.println("**클라이언트가 연결하였습니다.**");
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();
				
				while(true) {	//지속적으로 데이터를 받기 위한 반복문
					is.read(data);		
					os.write(data);	//읽어들인 그대로 내보내는 것 메아리(단일 연결일 경우) //클라이언트로부터 수신된 데이터를 그대로 메아리!
					
					String msg = (new String(data)).trim();
					System.out.println("수신된 데이터 : "+msg);
					
					if(msg.equals("q!")) {
						break;
					}
					Arrays.fill(data, (byte)0);
				}
				is.close();
				socket.close();
				System.out.println("**클라이언트와 연결이 끊어졌습니다.**");
			}
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
}
