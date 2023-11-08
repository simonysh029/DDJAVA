package exam10JCheckBox;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

class MyFrame extends JFrame {
	JCheckBox jcb01;
	JCheckBox jcb02;
	
	JLabel checked;

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
				if(jcb01.isSelected() == true && jcb02.isSelected() == true) {
					checked.setText("사과, 포도 선택됨");
				}else if(jcb01.isSelected() == true && jcb02.isSelected() == false) {
					checked.setText("사과 선택됨");
				}else if(jcb01.isSelected() == false && jcb02.isSelected() == true) {
					checked.setText("포도 선택됨");
				}else {
					checked.setText("선택 없음");
				}
			}
		});
		jcb02.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(jcb01.isSelected() == true && jcb02.isSelected() == true) {
					checked.setText("사과, 포도 선택됨");
				}else if(jcb01.isSelected() == true && jcb02.isSelected() == false) {
					checked.setText("사과 선택됨");
				}else if(jcb01.isSelected() == false && jcb02.isSelected() == true) {
					checked.setText("포도 선택됨");
				}else {
					checked.setText("선택 없음");
				}
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
