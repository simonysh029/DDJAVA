package com.sist.student;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

//사용자 한테 이름,국어,영어,수학을 입력받아 
//총점,평균을 계산하여 데이터베이스 테이블 student에 레코드를 
//추가하는 프로그램을 GUI로 만들어 봅니다.
class StudentFrame extends JFrame{
	String []str = {"이름","국어","영어","수학"};
	JTextField []jtf;	
	public StudentFrame() {
		jtf = new JTextField[str.length];
		JPanel p_center = new JPanel();
		p_center.setLayout(new GridLayout(4,2));
		JPanel p_south = new JPanel();
		for(int i=0; i<str.length; i++) {
			p_center.add(new JLabel(str[i]));
			jtf[i] = new JTextField(10);
			p_center.add(jtf[i]);
		}
		JButton btn_new = new JButton("새로운 학생");
		JButton btn_insert = new JButton("등록");
		p_south.add(btn_new);
		p_south.add(btn_insert);
		btn_new.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for(JTextField tf:jtf) {
					tf.setText("");
				}
			}
		});
		btn_insert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				insertStudent();
			}
		});
		add(p_center,BorderLayout.CENTER);
		add(p_south,BorderLayout.SOUTH);
		setSize(400, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void insertStudent() {
		String name = jtf[0].getText();
		int kor = Integer.parseInt(jtf[1].getText());
		int eng = Integer.parseInt(jtf[2].getText());
		int math = Integer.parseInt(jtf[3].getText());
		int tot = kor + eng + math;
		int avg = tot / 3;
		String sql = "insert into student values('"+name+"',"+kor+","+eng+","+math+","+tot+","+avg+")";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn =
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##madang", "madang");
			Statement stmt = conn.createStatement();
			int re  = stmt.executeUpdate(sql);
			if(re == 1) {
				JOptionPane.showMessageDialog(null, "학생의 정보를 등록하였습니다.");
			}else {
				JOptionPane.showMessageDialog(null, "등록에 실패하였습니다.");
			}
			stmt.close();
			conn.close();
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
}

public class InsertStudentGUI {
	public static void main(String[] args) {
		new StudentFrame();
	}
}
