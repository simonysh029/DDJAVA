package exam02;

import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("192.168.0.61",9004);
			
			System.out.println("**서버와 연결이 되었습니다.**");
			
			OutputStream os = socket.getOutputStream();
			Scanner sc = new Scanner(System.in);
			String msg;
			while(true) {
				System.out.println("서버로 보낼 데이터 입력 : ");
				msg = sc.next();
				os.write(msg.getBytes());
				
				if(msg.equals("q!")) {
					break;
				}
			}
			
			os.close();
			socket.close();
			System.out.println("**서버와의 연결이 끊어졌습니다.**");
			
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
}
