package exam06;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

//난수로 얻은 정수 10개 통신하여 보내기
public class TCPServer {
	public static void main(String[] args) {
		try {
			
			//절차 1. ServerSocket 생성
			ServerSocket server = new ServerSocket(9000);
//			System.out.println("서버 가동됨");
			
			//절차 2. 무한대기 상태로 클라이언트 접속을 기다린다.
			while(true) {
				
				//절차 4. accept를 호출하여 클라이언트의 접속을 수락한다.
					//이 메소드는 연결한 클라이언트와 통신을 위한 Socket을 반환한다.
				Socket socket = server.accept();
//				System.out.println("클라이언트 접속함");
				
				//절차 5. Socket을 통하여 스트림을 생성한다. 				
				OutputStream os = socket.getOutputStream();
				
				//절차 6. 데이터를 주고 받는다.
					//반복문으로 10개의 난수를 보내기
				Random r = new Random();
				for(int i=1; i<=10; i++) {
					int n =r.nextInt(100)+1;
					os.write(n);
					Thread.sleep(100);
				}
				
				//절차 7. Stream을 닫아준다.
				os.close();
				
				//절차 8. Socket을 닫아준다.
				socket.close();
			}
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
}
