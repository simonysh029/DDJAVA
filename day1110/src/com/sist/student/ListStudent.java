package com.sist.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ListStudent {
	public static void main(String[] args) {
		String sql = "select * from student";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String userName = "c##madang";
			String passWord = "madang";
			
			Connection conn =
			DriverManager.getConnection(url, userName, passWord);
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);			
			//국어,영어,수학,총점,평균도 출력
			while( rs.next() ) {
				String name = rs.getString(1);
				String kor = rs.getString(2);
				String eng = rs.getString(3);
				String math = rs.getString(4);
				String tot = rs.getString(5);
				String avg = rs.getString(6);
				
				System.out.println(name);
				System.out.println(kor);
				System.out.println(eng);
				System.out.println(math);
				System.out.println(tot);
				System.out.println(avg);
			}
			//자료를 다 가져왔으니 닫아준다.
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
}
