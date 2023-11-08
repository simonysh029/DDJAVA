package exam13JRadioButton;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

class MyFrame extends JFrame {	//라디오 버튼은 그 중에 하나만 선택이 되게 하려면 그룹을 설정해야함
	
	JRadioButton jrb01;
	JRadioButton jrb02;
	JLabel jlb;
	ButtonGroup bg;
	
	public MyFrame() {
		bg = new ButtonGroup();
		jrb01 = new JRadioButton("사과");
		jrb02 = new JRadioButton("포도");
		
		JButton btn = new JButton("확인");
		
		bg.add(jrb01);
		bg.add(jrb02);
		
		jlb = new JLabel("아무것도 선택안함");
		setLayout(new FlowLayout());
		add(jrb01);
		add(jrb02);
		add(jlb);
		add(btn);
		
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = "아무것도 선택안함";
				if(jrb01.isSelected()) {
					str = "사과를 선택";
				}else if(jrb02.isSelected()) {
					str = "포도를 선택";
				}
				jlb.setText(str);
			}
		});
				
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

public class JRadioButtonTest {
	public static void main(String[] args) {
		new MyFrame();
	}
}
