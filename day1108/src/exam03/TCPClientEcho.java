package exam03;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

public class TCPClientEcho {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("192.168.0.61",9004);
			System.out.println("**서버와 연결이 되었습니다.**");
			OutputStream os = socket.getOutputStream();
			
			InputStream is = socket.getInputStream();
			
			class ClientThread extends Thread {
				byte []arr = new byte[100];
				public void run() {
					while(true) {
						try {
							is.read(arr);
							String msg = new String(arr);
							msg = msg.trim();
							System.out.println("서버로부터 메아리된 데이터 : "+msg);
							
							if(msg.equals("q!")) {
								break;
							}
							
							Arrays.fill(arr, (byte)0);
						} catch (Exception e) {
							System.out.println("예외발생:"+e.getMessage());
						}
					}
				}
			}
			
			ClientThread ct = new ClientThread();
			ct.start();
			
			Scanner sc = new Scanner(System.in);
			String msg;
			while(true) {
				System.out.println("서버로 보낼 데이터 입력 : ");
				msg = sc.next();
				
				os.write(msg.getBytes());	//받는 동작 따로 보내는 동작 따로 //그래서 별도의 쓰레드로 처리
				
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
