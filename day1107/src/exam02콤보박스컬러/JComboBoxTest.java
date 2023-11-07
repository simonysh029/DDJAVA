package exam02콤보박스컬러;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class MyFrame extends JFrame {
	JComboBox<String> jcb;

	JPanel p;
	public MyFrame() {
		jcb = new JComboBox<String>();
		p = new JPanel();

		jcb.addItem("red");
		jcb.addItem("green");
		jcb.addItem("yellow");
		jcb.addItem("blue");

		jcb.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				String color = (String)jcb.getSelectedItem();
				switch(color) {
				case "red": p.setBackground(Color.red);break;
				case "green": p.setBackground(Color.green);break;
				case "yellow": p.setBackground(Color.yellow);break;
				case "blue": p.setBackground(Color.blue);break;		//break;를 써주지않으면 마지막 코딩만 실행됨
				}
			}
		});
		
		setLayout(new BorderLayout());
		add(jcb, BorderLayout.NORTH);
		add(p, BorderLayout.CENTER);
		
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

public class JComboBoxTest {
	public static void main(String[] args) {
		new MyFrame();
	}
}
