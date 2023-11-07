package exam06;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

//java java UDPSender 192.168.0.61 9001 안녕
//java java UDPSender 192.168.0.61 9001 반가워~
public class UDPSender {
	public static void main(String[] args) {
		try {
			//프로그램 실행시에 전달되는 첫번째 데이터를 ip변수에 저장
			String ip = args[0];
			
			//프로그램 실행시에 전달되는 두번째 데이터를 정수로 변환하여 port에 저장
			int port = Integer.parseInt(args[1]);
			
			//프로그램 실행시에 전달되는 세번째 데이터를 문자열변수 msg에 저장
			String msg = args[2];
			
			//절차 1. DatagramSocket을 생성한다.
			DatagramSocket socket = new DatagramSocket();
			
			//절차 2. DatagramPacket을 생성한다.
				//보내고자 하는 메세지를 담고 있는 문자열 msg를 byte의 배열로 만든다.
				//통신은 byte형태로 추가받기때문에 변환함
			byte []data = msg.getBytes();
			
			//데이터를 보내기 위한 목적지 주소 ip주소를 갖고 InetAddress 객체를 생성한다.
			InetAddress addr = InetAddress.getByName(ip);
			
			//목적지 주소 addr과 보내고자 하는 데이터가 담긴 바이트 배열 data를 갖고 데이터그램패킷 객체를 생성한다.
			DatagramPacket packet = new DatagramPacket(data, data.length, addr, port);
			
			//절차 3. send 메소드를 호출하여 데이터를 보낸다.
			socket.send(packet);
			
			//절차 4. 소켓을 닫아준다.
			socket.close();
			
			
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
}
