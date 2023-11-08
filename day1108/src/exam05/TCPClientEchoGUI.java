package exam05;

import java.awt.BorderLayout;
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

class MyFrame extends JFrame {
	JTextArea jta;			//화면 상단 메아리 내용
	JTextField jtf;			//입력된 내용이 서버를 거쳐서 JTextArea에 출력
	
	public MyFrame() {
		jta = new JTextArea(10,80);		
		jtf = new JTextField(20);
		JScrollPane jsp = new JScrollPane(jta);
		
		JButton btn = new JButton("전송");
		JPanel p = new JPanel();
		
		p.add(jtf);
		p.add(btn);
		
		setLayout(new BorderLayout());
		add(jta, BorderLayout.NORTH);
		add(p, BorderLayout.CENTER);
		
		btn.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {				
				String msg = jtf.getText();
				try {
					Socket socket = new Socket("192.168.0.61",9004);
					System.out.println("**서버와 연결이 되었습니다.**");
					OutputStream os = socket.getOutputStream();
					InputStream is = socket.getInputStream();
					
						System.out.println("서버로 보낼 데이터 입력 : ");
						os.write(msg.getBytes());	//받는 동작 따로 보내는 동작 따로 //그래서 별도의 쓰레드로 처리
					
					
					byte []arr = new byte[100];
				
					while(true) {
						try {
							is.read(arr);
							msg = new String(arr);
							msg = msg.trim();
							System.out.println("서버로부터 메아리된 데이터 : "+msg);
							
							if(msg.equals("q!")) {
								break;
							}
							Arrays.fill(arr, (byte)0);
						} catch (Exception e3) {
							System.out.println("예외발생:"+e3.getMessage());
						}
					}
					os.close();
					socket.close();
					System.out.println("**서버와의 연결이 끊어졌습니다.**");
				} catch (Exception e2) {
					System.out.println("예외발생:"+e2.getMessage());
				}
				jtf.setText(msg);
			}
		});
		setSize(500,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

public class TCPClientEchoGUI {
	public static void main(String[] args) {
		new MyFrame();
	}
}
