package com.sist.file3;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

// c:/data/student02.dat 파일을 읽어 들여 학생의 정보를 출력하도록 코드를 수정하세요.
class StudentObjectInputFrame extends JFrame{
	String []arr = {"이름","국어","영어","수학","총점","평균"};
	JTextField jtf[] = new JTextField[arr.length];
	ArrayList<Student> list;
	int idx = 0;
	
	//현재 인덱스(idx) 번째의 학생의 정보를 리스트로 꺼집어 내어와서 각각의 텍스트필드에 출력하는 메소드
	public void printStudent() {
		Student row = list.get(idx);
		jtf[0].setText(row.getName());
		jtf[1].setText(row.getKor()+"");
		jtf[2].setText(row.getEng()+"");
		jtf[3].setText(row.getMath()+"");
		jtf[4].setText(row.getTot()+"");
		jtf[5].setText(row.getAvg()+"");
	}
	
	public StudentObjectInputFrame() {
		list = new ArrayList<Student>();
		try {			
			ObjectInputStream ois = 
			new ObjectInputStream(new FileInputStream("c:/data/student02.dat"));
			list = (ArrayList<Student>)ois.readObject();
			ois.close();
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
				if(idx == list.size()-1) {
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
				if(idx == 0) {
					JOptionPane.showMessageDialog(null, "맨 처음 학생입니다.");
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

public class StudentTestObjectInputGUI {
	public static void main(String[] args) {
		new StudentObjectInputFrame();
	}	
}
