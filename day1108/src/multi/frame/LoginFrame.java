package multi.frame;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class LoginFrame extends JFrame {
	JTextField jtf_name;
	
	public LoginFrame() {
		setLayout(new FlowLayout());
		jtf_name = new JTextField(10);
		JButton btn = new JButton("확인");
		add(jtf_name);
		add(btn);
		setSize(200,150);
		setVisible(true);
		
		btn.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = jtf_name.getText();
				new MainFrame(name);
				setVisible(false);
			}
		});
	}
}
