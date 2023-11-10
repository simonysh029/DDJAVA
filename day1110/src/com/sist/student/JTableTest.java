package com.sist.student;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

class MemberFrame extends JFrame {
	JTable table;
	String []colNames = {"이름","나이","주소"};
	String [][]rowData = {
			{"홍길동","20","서울"},
			{"이순신","30","대전"},
			{"김유신","25","광주"},
	};
	
	public MemberFrame() {
		table = new JTable(rowData, colNames);
		JScrollPane jsp = new JScrollPane(table);
		add(jsp);
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

public class JTableTest {
	public static void main(String[] args) {
		new MemberFrame();
	}
}