package exam15_14sol;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class MyFrame extends JFrame {
	String []name = {"엔진 오일 교환", "자동 변속기 오일 교환","에어콘 필터 교환","타이어 교환"};
	int []price = {45000,80000,30000,100000};
	JCheckBox []jcb;		//체크박스 배열 선언
	JLabel jlb_price;		//전체 가격을 출력할 라벨을 멤버변수로 선언
	
	public MyFrame() {								//생성자
		jcb = new JCheckBox[name.length];			//체크박스 배열 생성	//배열 순서를 맞춰서 하나의 반복문으로 대응되게 세팅
		
		JPanel p_center = new JPanel();				//프레임의 가운데에 보여줄 패널을 생성 //여기 자동차수리 항목을 위한 체크박스들을 출력할 것.
		JPanel p_south = new JPanel();				//확인 버튼과 총 수리비ㅣ용 검색을 출력할 패널을 만든다. //프레임 아래쪽에 배치할 것.
		
		p_south.setLayout(new FlowLayout(FlowLayout.LEFT));	//FlowLayout : 기본적으로 중간 정렬이지만 왼쪽으로 설정한 것.

		p_center.setLayout(new GridLayout(5,2));			//프레임의 가운데에 배치할 패널의 레이아웃을 그리드레이아웃으로 설정한다.//맨 윗줄 : 제목//자동차 수리항목 4개,가격//5행2열 설정
		p_center.add(new JLabel("수리"));	
		p_center.add(new JLabel("가격(원)"));
		
		for(int i=0; i<name.length; i++) {			//세팅된 배열 두개를 돌린다.
			
			jcb[i] = new JCheckBox(name[i]);		//자동차 수리항목 4개를 체크박스로 생성한다.
			p_center.add(jcb[i]);					//생성한 체크박스를 패널에 담는다.
			p_center.add(new JLabel(price[i]+""));	//그 체크박스 옆에 가격을 라벨로 출력한다.
		}
		
		JButton btn = new JButton("확인");			//총금액 계산을 위한 버튼을 생성
		jlb_price = new JLabel("가격이 출력됩니다.");		//총금액이 출력될 라벨 생성
		p_south.add(btn);							//프레임의 아래쪽에 배치될 패널에 버튼과 총가격을 출력할 라벨을 담는다.
		p_south.add(jlb_price);
		
		btn.addActionListener(new ActionListener() {	//버튼을 누르면 가격이 출력되게 이벤트를 준다.
			@Override
			public void actionPerformed(ActionEvent e) {
				int total = 0;						//총 수리 금액을 누적하기 위한 변수를 선언하고 0으로 초기화 한다.
				for(int i=0; i<jcb.length; i++) {	//반복문을 이용하여 자동차 수리 항목만큼 반복실행하여 그 항목이 선택되었는지 판별하여 만약 선택되었다면 그 수리 가격을 총금액에 누적한다.
					if(jcb[i].isSelected()) {
						total += price [i];
					}
				}
				jlb_price.setText(total+"");		//반복문을 탈출하여 총 누적 금액을 라벨에 출력한다.
			}
		});
		
		setLayout(new BorderLayout());				//프레임의 레이아웃을 BorderLayout으로 설정한다.
		add(p_center, BorderLayout.CENTER);			//프레임의 가운데에 자동차 수리항목과 가격이 출력된 패널을 배치한다.
		add(p_south, BorderLayout.SOUTH);			//프레임의 아래쪽에 금액을 계산하기 위한 버튼과 총 금액을 출력할 라벨이 출력된 패널을 배치한다.
		
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

public class CarRepairShopTest {
	public static void main(String[] args) {
		new MyFrame();
	}
}
