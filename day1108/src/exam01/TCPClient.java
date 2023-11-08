package exam01;

import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("211.238.142.46",9002);
			
			String msg = args[0];
			
			OutputStream os = socket.getOutputStream();
			byte []data = msg.getBytes();
			os.write(data);
			
			os.close();
			socket.close();
			
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
}
