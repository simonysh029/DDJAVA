package exam14;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

class MyFrame extends JFrame {
	
	JCheckBox EngineOil;	//엔진 오일 교환 45000
	JCheckBox AutoOil;		//자동 변속기 오일 교환 80000
	JCheckBox Filter;		//에어콘 필터 교환 30000
	JCheckBox Tire;			//타이어 교환 100000
	
	JLabel jlb1;		//수리 내역, 비용 표시

	public void price() {
		if(EngineOil.isSelected()==true&&AutoOil.isSelected()==false&&Filter.isSelected()==false&&Tire.isSelected()==false) {
			jlb1.setText("엔진 오일 교환 : 45000");
		}else if(EngineOil.isSelected()==true&&AutoOil.isSelected()==true&&Filter.isSelected()==false&&Tire.isSelected()==false) {
			jlb1.setText("엔진 오일 교환, 자동 변속기 오일 교환 : 125000");
		}else if(EngineOil.isSelected()==true&&AutoOil.isSelected()==false&&Filter.isSelected()==true&&Tire.isSelected()==false) {
			jlb1.setText("엔진 오일 교환, 에어콘 필터 교환 : 75000");
		}else if(EngineOil.isSelected()==true&&AutoOil.isSelected()==false&&Filter.isSelected()==false&&Tire.isSelected()==true) {
			
		}else if(EngineOil.isSelected()==true&&AutoOil.isSelected()==true&&Filter.isSelected()==true&&Tire.isSelected()==false) {
			jlb1.setText("엔진 오일 교환, 자동 변속기 오일 교환, 에어콘 필터 교환 : 155000");
		}else if(EngineOil.isSelected()==true&&AutoOil.isSelected()==true&&Filter.isSelected()==false&&Tire.isSelected()==true) {
			jlb1.setText("엔진 오일 교환, 자동 변속기 오일 교환, 타이어 교환 : 225000");
			
			
		}else if(EngineOil.isSelected()==false&&AutoOil.isSelected()==true&&Filter.isSelected()==false&&Tire.isSelected()==false) {
			jlb1.setText("자동 변속기 오일 교환 : 80000");
		}else if(EngineOil.isSelected()==false&&AutoOil.isSelected()==true&&Filter.isSelected()==true&&Tire.isSelected()==false) {
			jlb1.setText("자동 변속기 오일 교환, 에어콘 필터 교환 : 110000");
		}else if(EngineOil.isSelected()==false&&AutoOil.isSelected()==true&&Filter.isSelected()==false&&Tire.isSelected()==true) {
			jlb1.setText("자동 변속기 오일 교환, 타이어 교환 : 180000");
		}else if(EngineOil.isSelected()==false&&AutoOil.isSelected()==true&&Filter.isSelected()==true&&Tire.isSelected()==true) {
			jlb1.setText("자동 변속기 오일 교환, 에어콘 필터 교환, 타이어 교환 : 210000");
			
			
		}else if(EngineOil.isSelected()==false&&AutoOil.isSelected()==false&&Filter.isSelected()==true&&Tire.isSelected()==false) {
			jlb1.setText("에어콘 필터 교환 : 30000");
		}else if(EngineOil.isSelected()==false&&AutoOil.isSelected()==false&&Filter.isSelected()==true&&Tire.isSelected()==true) {
			jlb1.setText("에어콘 필터 교환, 타이어 교환 : 130000");
			
			
		}else if(EngineOil.isSelected()==false&&AutoOil.isSelected()==false&&Filter.isSelected()==false&&Tire.isSelected()==true) {
			jlb1.setText("타이어 교환 : 100000");
			
		}else {
			jlb1.setText("엔진 오일 교환, 자동 변속기 오일 교환, 에어콘 필터 교환, 타이어 교환 : 265000");
		}
	}
	
	public MyFrame() {
		
		EngineOil = new JCheckBox("엔진 오일 교환 45000");
		AutoOil = new JCheckBox("자동 변속기 오일 교환 80000");
		Filter = new JCheckBox("에어콘 필터 교환 30000");
		Tire = new JCheckBox("타이어 교환 100000");
		
		setLayout(new FlowLayout());
		add(EngineOil);
		add(AutoOil);
		add(Filter);
		add(Tire);

		jlb1 = new JLabel("선택사항 없음");
		
		EngineOil.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				price();
			}
		});
		AutoOil.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				price();
			}
		});
		Filter.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				price();
			}
		});
		Tire.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				price();
			}
		});
		
		add(jlb1);
		setSize(350,200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

public class CarCenter {
	public static void main(String[] args) {
		new MyFrame();
	}
}
