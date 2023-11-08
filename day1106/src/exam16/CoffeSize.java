package exam16;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

class MyFrame extends JFrame {
	JRadioButton jrb01; 
	JRadioButton jrb02; 
	JRadioButton jrb03; 
	JRadioButton jrb04; 
	JRadioButton jrb05; 
	JRadioButton jrb06; 

	JLabel jlb_price;
	
	public MyFrame() {

		jrb01 = new JRadioButton("small,3000");
		jrb02 = new JRadioButton("medium,4000");
		jrb03 = new JRadioButton("large,5000");
		
		JPanel p_north = new JPanel();
		JPanel p_center = new JPanel();
		
		p_north.setLayout(new FlowLayout(FlowLayout.LEFT));

		p_north.setLayout(new GridLayout(4,2));
		p_north.add(new JLabel("커피 크기"));
		p_north.add(new JLabel("가격(원)"));
		
		p_north.add(jrb01);
		p_north.add(jrb02);
		p_north.add(jrb03);

		JButton btn = new JButton("선택");
		p_center.add(btn);
		p_center.add(new JLabel("선택한 커피 크기와 가격이 출력됩니다."));

		btn.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = "아무것도 선택안함";
				if(jrb01.isSelected()) {
					str = "사이즈 : Small, 가격 : 3000원";
				}else if(jrb02.isSelected()) {
					str = "사이즈 : Medium, 가격 : 4000원";
				}else if(jrb03.isSelected()) {
					str = "사이즈 : Ledium, 가격 : 5000원";
				}
				jlb_price.setText(str);
			}
		});
		
		setLayout(new BorderLayout());
		add(p_north, BorderLayout.NORTH);
		add(p_center, BorderLayout.CENTER);
		
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

public class CoffeSize {
	public static void main(String[] args) {
		new MyFrame();
	}
}
