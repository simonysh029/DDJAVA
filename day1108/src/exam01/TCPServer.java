package exam01;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

//java TCPClient 안녕!

public class TCPServer {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(9002);
			byte []data = new byte[100];
			
			while(true) {
				
				Socket socket = server.accept();
				InputStream is = socket.getInputStream();
				is.read(data);
				
				String msg = new String(data);
				System.out.println("수신된 데이터 : "+msg.trim());
				
				is.close();
				socket.close();
			}
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
}
