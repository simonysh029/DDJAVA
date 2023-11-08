package exam07;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.Flow;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class ChatFrame extends JFrame{
	JTextArea jta;
	JTextField jtf;
	Socket socket;
	InputStream is;
	OutputStream os;	
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
		setSize(420, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			//socket = new Socket("192.168.0.61", 9007);
			socket = new Socket("211.238.142.46", 9007);
			os = socket.getOutputStream();
			is = socket.getInputStream();
			class ClientThread extends Thread{
				byte []arr = new byte[100];
				public void run() {
					while(true) {
						try {
							is.read(arr);
							jta.append((new String(arr)).trim() +"\n");
							Arrays.fill(arr, (byte)0);
						}catch (Exception e) {
							System.out.println("예외발생:"+e.getMessage());
						}//end catch
					}//end while
				}//end run				
			}//end ClientThread
			ClientThread ct = new ClientThread();
			ct.start();			
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
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
				}catch (Exception ex) {
					System.out.println("예외발생:"+ex.getMessage());
				}				
			}
		});
	}
}

public class TCPClientChat {
	public static void main(String[] args) {
		new ChatFrame();
	}
}
