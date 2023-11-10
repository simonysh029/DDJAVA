package com.sist.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class ListStudentFrame extends JFrame {
	JTextArea jta;
	public ListStudentFrame() {		
		setTitle("학생목록");
		jta = new JTextArea();
		JScrollPane jsp = new JScrollPane();
		add(jsp);
		
		listStudent();
		
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public void listStudent() {
		String sql = "select * from studnet";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String username="c##madang";
			String password = "madang";
			Connection conn = DriverManager.getConnection(url, username, password);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String name = rs.getString(1);
				int kor = rs.getInt(2);
				int eng = rs.getInt(3);
				int math = rs.getInt(4);
				int tot = rs.getInt(5);
				int avg = rs.getInt(6);
				String row = name+","+kor+","+eng+","+math+","+tot+","+avg+"\n";
				jta.append(row);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
}

public class ListStudentGUI {
	public static void main(String[] args) {
		new ListStudentFrame();
	}
}
