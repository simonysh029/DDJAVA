package com.sist.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class InsertStudent {
	public static void main(String[] args) {
		String name;
		int kor;
		int eng;
		int math;
		Scanner sc = new Scanner(System.in);
		System.out.println("이름을 입력==>");
		name = sc.next();
		
		System.out.println("국어점수==>");
		kor = sc.nextInt();
		
		System.out.println("영어점수==>");
		eng = sc.nextInt();
		
		System.out.println("수학점수==>");
		math = sc.nextInt();
		
		
		int tot = kor + eng + math;
		int avg = tot /3;
		
		String sql = 
		"insert into student values('"+name+"',"+kor+","+eng+","+math+","+tot+","+avg+")";
		
		try {
			//1. JDBC 드라이버를 메모리로 로드한다.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. DB 서버에 연결한다.
			Connection conn = 
			DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##madang", "madang");
			
			//3. 커넥션 객체를 통해서 데이터베이스 명령을 
			// 		실행하기 위한 Statement객체를 생성한다.
			Statement stmt = conn.createStatement();
			
			//4. Statmement객체를 통해서 데이터베이스 명령을 실행한다.
			int re = stmt.executeUpdate(sql);
			
			if(re == 1) {
				System.out.println("레코드를 추가하였습니다.");
			}else {
				System.out.println("실패하였습니다.");
			}
			
			
			//5. 사용했던 자원을 닫아 준다.
			stmt.close();
			conn.close();
			
			
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		
		
	}
}









