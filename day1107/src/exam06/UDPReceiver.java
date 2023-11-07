package exam06;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;

public class UDPReceiver {
	public static void main(String[] args) {
		try {
			
			//수신된 데이터를 받기 위한 DatagramPacket객체 생성시에 필요한 바이트 배열을 만든다.
			//실제 데이터는 여기 담긴다.
			byte []data = new byte[200];
			
			
			//절차 1. DatagramSocket을 생성한다.
			DatagramSocket socket = new DatagramSocket(9001);
			System.out.println("**데이터 받을 준비가 됨**");
			
			//계속하여 데이터를 수신받기 위하여 반복문을 표현한다.
			while(true) {
				
				//절차 2. 데이터를 받기 위한 DatagramPacket을 생성한다.
				DatagramPacket packet = new DatagramPacket(data, data.length);
				
				
				//절차 3. receive 메소드를 호출하여 데이터를 받는다.
				socket.receive(packet);
				
				//수신된 데이터를 화면에 출력한다.
				String str = new String(data);
				System.out.println("수신된 데이터 : "+str);
				
				//다음 데이터 수신을 위하여 배열을 비운다.
				Arrays.fill(data, (byte)0);
			}
			
			
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}

	}
}
