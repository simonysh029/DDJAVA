package com.sist.student;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

//Vector는 ArrayList의 형제

class MemberFrame2 extends JFrame {
	JTable table;
	Vector<String> colNames;
	Vector<Vector<String>> rowData;
	
	public MemberFrame2() {
		colNames = new Vector<String>();
		colNames.add("이름");
		colNames.add("나이");
		colNames.add("주소");
		
		rowData = new Vector<Vector<String>>();
			
		Vector<String> v1 = new Vector<String>();
		v1.add("홍길동");
		v1.add("20");
		v1.add("서울");
		rowData.add(v1);

		Vector<String> v2 = new Vector<String>();
		v2.add("이순신");
		v2.add("30");
		v2.add("대전");
		rowData.add(v2);
		
		Vector<String> v3 = new Vector<String>();
		v2.add("김유신");
		v2.add("25");
		v2.add("광주");
		rowData.add(v3);

		table = new JTable(rowData, colNames);
		JScrollPane jsp = new JScrollPane(table);
		add(jsp);
		
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

public class JTableTestVector {
	public static void main(String[] args) {
		new MemberFrame2();
	}
}
