package exam03;

import java.awt.FlowLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class MyFrame extends JFrame {
	ImageIcon icon1;
	ImageIcon icon2;
	ImageIcon icon3;
	JButton btn;
	
	public MyFrame() {	
		icon1 = new ImageIcon("apple.gif");
		icon2 = new ImageIcon("banana.gif");
		icon3 = new ImageIcon("grape.gif");
		btn = new JButton(icon1);
		btn.setRolloverIcon(icon2);
		btn.setPressedIcon(icon3);
		
		setLayout(new FlowLayout());
		add(btn);		
		
		setSize(900,900);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}


public class ImageButtonTest {
	public static void main(String[] args) {
		new MyFrame();
	}
}
