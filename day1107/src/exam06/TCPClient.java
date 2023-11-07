package exam06;

import java.io.InputStream;
import java.net.Socket;

//난수로 얻은 정수 10개 통신하여 받기
public class TCPClient {
	public static void main(String[] args) {
		try {
			
			//절차 3. Socket객체를 생성하여 서버에 통신을 요청한다.
			Socket socket = new Socket("192.168.0.61", 9000);
			
			//절차 5. Socket을 통하여 스트림을 생성한다.
			InputStream is = socket.getInputStream();
			
			//절차 6. 데이터를 주고 받는다.
				//서버가 보내오는 10개의 정수를 받아서 화면에 출력
			for(int i=1; i<=10; i++) {
				int n = is.read();
				System.out.println("서버로부터 수신된 데이터 : "+n);
			}
			
			//절차 7. Stream을 닫아준다.
			is.close();
			
			//절차 8. Socket을 닫아준다.
			socket.close();
			
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
}
