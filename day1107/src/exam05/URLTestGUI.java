package exam05;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class MyFrame extends JFrame {
	
	JTextField jtf;
	JTextArea jta;
	
	public MyFrame() {
		
		jtf = new JTextField(20);
		jta = new JTextArea(10,80);
		JScrollPane jsp = new JScrollPane(jta);
		
		JButton btnRead = new JButton("읽어오기");
		JPanel p = new JPanel();
		p.add(jtf);
		p.add(btnRead);
		
		setLayout(new BorderLayout());
		add(p, BorderLayout.NORTH);
		add(jsp, BorderLayout.CENTER);
		
		btnRead.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String addr = jtf.getText();
				try {
					URL url = new URL(addr);
					InputStream is = url.openStream();
					
					byte []data = new byte[100];
					while(is.read(data) != -1) {
						jta.append(new String(data));
						Arrays.fill(data, (byte)0);
					}
					
				}catch (Exception exc) {
					System.out.println("예외발생:"+exc.getMessage());
				}
			}
		});
		
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

public class URLTestGUI {
	public static void main(String[] args) {
		new MyFrame();
	}
}
