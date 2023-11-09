package com.sist.file2;

//student01.txt파일을 읽어들여 총점,평균 계산하여 각각의 텍스트에 출력하도록 프로그래밍
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

class StudentReadFrame extends JFrame{
	String []arr = {"이름","국어","영어","수학","총점","평균"};
	JTextField jtf[] = new JTextField[arr.length];
	ArrayList<String> list;
	int idx = 0;
	int tot = 0;
	int avg = 0;
	//현재 인덱스(idx) 번째의 학생의 정보를 리스트로 꺼내서 각각의 텍스트필드에 출력하는 메소드
	public void printStudent() {
		String row = list.get(idx);
		String []arr = row.split(",");
		
		for(int i=0; i<arr.length; i++) {
			jtf[i].setText(arr[i]);
//			if(i != 0) {
//				tot += Integer.parseInt(arr[i]);
//			}
		}
		
		tot = Integer.parseInt(arr[1]) + Integer.parseInt(arr[2]) + Integer.parseInt(arr[3]);
		avg = tot/3;
		jtf[4].setText(String.valueOf(tot));
		jtf[5].setText(String.valueOf(avg));
	}
	public StudentReadFrame() {
		list = new ArrayList<String>();
		try {			
			BufferedReader br = 
					new BufferedReader(new FileReader("c:/data/student01.txt"));			
			String line = "";			
			while((line = br.readLine()) != null) {
				list.add(line);
			}			
			br.close();			
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		JPanel p_center= new JPanel();
		JPanel p_south = new JPanel();
		p_center.setLayout(new GridLayout(6,2));
		
		for(int i=0; i<arr.length; i++) {
			p_center.add(new JLabel(arr[i]));
			jtf[i] = new JTextField(10);
			p_center.add(jtf[i]);
		}
		JButton btn_prev = new JButton("이전");
		JButton btn_next = new JButton("다음");
		p_south.add(btn_prev);
		p_south.add(btn_next);
		add(p_center, BorderLayout.CENTER);
		add(p_south, BorderLayout.SOUTH);
		printStudent();
		btn_next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(idx==list.size()-1) {
					JOptionPane.showMessageDialog(null, "마지막 학생입니다.");
					return;
				}
				idx++;
				printStudent();
			}
		});
		btn_prev.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(idx==0) {
					JOptionPane.showMessageDialog(null, "첫번째 학생입니다.");
					return;
				}
				idx--;
				printStudent();
			}
		});
		setSize(400, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

public class StudentTestFileReaderGUI {
	public static void main(String[] args) {
		new StudentReadFrame();
	}	
}