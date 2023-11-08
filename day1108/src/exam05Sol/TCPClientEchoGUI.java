package exam05Sol;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneLayout;

//---------서버를 가동된 상태에서 실행----------
class ChatFrame extends JFrame {
	JTextArea jta;
	JTextField jtf;
	
//--------입출력 요소들 멤버변수화-------------
	Socket socket;
	InputStream is;
	OutputStream os;
//----------------------------모양 잡기----------------------------------	
	public ChatFrame() {
		setTitle("에코 시스템");
		jta = new JTextArea(10,80);
		jtf = new JTextField(30);
		JScrollPane jsp = new JScrollPane(jta);
		
		JButton btnSend = new JButton("전송");
		JPanel p = new JPanel();
		p.setLayout(new FlowLayout(FlowLayout.LEFT));
		p.add(jtf);
		p.add(btnSend);
		
		add(jsp, BorderLayout.CENTER);
		add(p, BorderLayout.SOUTH);
		
		setSize(420,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//-----------------------데이터 입출력-----------------------------------		
		try {
			socket = new Socket("192.168.0.61",9005);
			os = socket.getOutputStream();
			is = socket.getInputStream();
//------------------------멀티쓰레드 생성--------------------------------			
			class ClientThread extends Thread {
				byte []arr = new byte[100];
				public void run() {
					while(true) {
						try {
							is.read(arr);
							jta.append((new String(arr)).trim()+"\n");			//trim을 통해 넘치는 코드들 정돈 //append통해 textarea에 추가
							Arrays.fill(arr, (byte)0);							//배열 초기화로 다시 돌아갈때도 돌아갈 수 있게끔 함
						} catch (Exception e) {
							System.out.println("예외발생:"+e.getMessage());
						}//end catch
					}//end while
				}//end run
			}//end ClientThread
//---------------------멀티쓰레드 생성, 실행-------------------------------			
			ClientThread ct = new ClientThread();
			ct.start();
//--------------------------------------------------------------------			
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
//---------------------버튼액션에 전송 및 끝내는 기능 추가--------------------		
		btnSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String msg = jtf.getText();
				byte []data = msg.getBytes();
				try {
					os.write(data);
					if(msg.equals("q!")) {
						System.exit(0);
					}
					jtf.setText("");
				} catch (Exception ex) {
					System.out.println("예외발생:"+ex.getMessage());
				}	
			}
		});
//--------------------------------------------------------------------		
	}
}

public class TCPClientEchoGUI {
	public static void main(String[] args) {
		new ChatFrame();
	}
}
