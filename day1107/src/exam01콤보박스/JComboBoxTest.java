package exam01콤보박스;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

class MyFrame extends JFrame {
	JComboBox<String> jcb;
	JLabel jlb;
	public MyFrame() {
		jlb = new JLabel();
		jcb = new JComboBox<String>();
		jcb.addItem("사과");
		jcb.addItem("수박");
		jcb.addItem("딸기");
		jcb.addItem("오렌지");
		jcb.addItem("감");
		
		jcb.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				String item = (String)jcb.getSelectedItem();
				jlb.setText(item+"을(를) 선택하였습니다.");
			}
		});
		
		setLayout(new BorderLayout());
		add(jcb,BorderLayout.NORTH);
		add(jlb,BorderLayout.CENTER);
		
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
