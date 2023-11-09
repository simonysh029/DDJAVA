package com.sist.file3;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

class StudentObjectFrame extends JFrame{
	String []arr = {"이름","국어","영어","수학"};
	JTextField jtf[] = new JTextField[arr.length];
	ArrayList<Student> list;
	int idx = 0;
	
	public StudentObjectFrame() {
		list = new ArrayList<Student>();

		JPanel p_center= new JPanel();
		JPanel p_south = new JPanel();
		p_center.setLayout(new GridLayout(4,2));
		
		for(int i=0; i<arr.length; i++) {
			p_center.add(new JLabel(arr[i]));
			jtf[i] = new JTextField(10);
			p_center.add(jtf[i]);
		}
		
		JButton btn_new = new JButton("새로운 학생");
		JButton btn_save = new JButton("저장");
		p_south.add(btn_new);
		p_south.add(btn_save);
		add(p_center, BorderLayout.CENTER);
		add(p_south, BorderLayout.SOUTH);
		
		
		
		btn_new.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for(JTextField tf:jtf) {
					tf.setText("");
				}
			}
		});
		btn_save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = jtf[0].getText();
				int kor = Integer.parseInt(jtf[1].getText());
				int eng = Integer.parseInt(jtf[2].getText());
				int math = Integer.parseInt(jtf[3].getText());
				int tot = kor + eng + math;
				int avg = tot/3;
				list.add(new Student(name, kor, eng, math, tot, avg));				
			}
		});
		
		addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				
				//c:/data/student02.dat
				try {
					ObjectOutputStream oos = 
							new ObjectOutputStream(new FileOutputStream("c:/data/student02.dat"));
					
					oos.writeObject(list);
					oos.close();
					System.out.println("파일을 기록하였습니다.");
				}catch (Exception ex) {
					System.out.println("예외발생:"+ex.getMessage());
				}
				
				
				
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Closed");
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		setSize(400, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

public class StudentTestObjectOutputGUI {
	public static void main(String[] args) {
		new StudentObjectFrame();
		
	}	
}






