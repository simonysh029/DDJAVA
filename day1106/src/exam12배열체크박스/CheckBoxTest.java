package exam12배열체크박스;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

class MyFrame extends JFrame {
	JCheckBox jcb01;
	JCheckBox jcb02;	
	JCheckBox jcb03;	
	JCheckBox jcb04;	
	JCheckBox jcb05;
	
	JLabel checked;

	String fruits[] = {"사과","포도","딸기","수박","배"};
	JCheckBox isSelected[] = new JCheckBox[5];
	
	public void pro() {
		
		for(int i=0; i<fruits.length; i++) {
			
		}
		
//		if(jcb01.isSelected()==true&&jcb02.isSelected()==false&&jcb03.isSelected()==false&&jcb04.isSelected()==false&&jcb05.isSelected()==false) {
//			checked.setText("사과 선택됨");
//		}

		
//		if(jcb01.isSelected() == true && jcb02.isSelected() == true) {
//			checked.setText("사과, 포도 선택됨");
//		}else if(jcb01.isSelected() == true && jcb02.isSelected() == false) {
//			checked.setText("사과 선택됨");
//		}else if(jcb01.isSelected() == false && jcb02.isSelected() == true) {
//			checked.setText("포도 선택됨");
//		}else {
//			checked.setText("선택 없음");
//		}
	}
	
	public MyFrame() {
		jcb01 = new JCheckBox("사과");
		jcb02 = new JCheckBox("포도");
		setLayout(new FlowLayout());
		add(jcb01);
		add(jcb02);
		checked = new JLabel("아무것도 선택하지 않았습니다.");
		
		jcb01.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pro();
			}
		});
		jcb02.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pro();
			}
		});
		jcb03.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pro();
			}
		});
		jcb04.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pro();
			}
		});
		jcb05.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pro();
			}
		});
		add(checked);
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

public class CheckBoxTest {
	public static void main(String[] args) {
		new MyFrame();
	}
}
