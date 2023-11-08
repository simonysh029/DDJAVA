package multi.frame;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainFrame extends JFrame {
	JLabel jlb;
	
	public MainFrame(String name) {
		setTitle("메인화면");
		jlb = new JLabel(name);
		setLayout(new FlowLayout());
		add(jlb);
		
		setSize(400,300);
		setVisible(true);
	}
}
