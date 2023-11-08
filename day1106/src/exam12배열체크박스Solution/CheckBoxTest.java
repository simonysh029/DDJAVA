package exam12배열체크박스Solution;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

class MyFrame extends JFrame {
	
	
	String str[] = {"사과","포도","딸기","수박","배"};		//체크박스에 나타낼 문자열 배열을 만든다.
	JCheckBox jcb[];									//체크박스 배열을 선언
	JLabel jlb;											//결과를 출력할 라벨을 멤버변수로 선언
		
	public MyFrame() {							//생성자를 만든다.
		jcb = new JCheckBox[str.length];		//체크박스 배열을 체크박스로 표시할 문자열 배열의 길이만큼 생성
		setLayout(new FlowLayout());			//프레임의 레이아웃을 FlowLayout으로 설정
		for(int i=0; i<jcb.length; i++) {		//체크박스 배열의 길이만큼 반복 실행
			jcb[i] = new JCheckBox(str[i]);		//체크박스를 생성
			add(jcb[i]);						//프레임에 체크박스를 담는다.
			jcb[i].addActionListener(new ActionListener() {		//체크박스에 이벤트를 연결
				@Override
				public void actionPerformed(ActionEvent e) {	//선택한 체크박스의 항목의 문자열을 누적하기 위한 변수를 선언하고
					String data = "";							//비어있는 문자열로 초기화
					for(JCheckBox cb:jcb) {						//체크박스 배열의 길이만큼 반복실행
						if(cb.isSelected()) {					//체크박스가 선택되었는지 확인하여 체크되었다면
							data += cb.getText()+",";			//그 체크박스의 문자열을 누적
						}
					}
					
					if(data.equals("")) {							//반복문을 탈출하였는데 data가 비어있는 문자열이라면 
						jlb.setText("아무것도 선택안함");				//라벨에 "아무것도 선택안함"이라고 출력
					}else {
						data = data.substring(0,data.length()-1);	//data가 비어있는 문자열이 아니라면 맨 마지막의 ,를 잘라내고 출력
						jlb.setText(data+"(을)를 선택하였습니다.");		
					}
				}
			});
		}
		
		jlb = new JLabel("아무것도 선택안함");					//라벨을 생성
		add(jlb);											//라벨을 프레임에 추가
		
		setSize(300,200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

public class CheckBoxTest {
	public static void main(String[] args) {
		new MyFrame();
	}
}
