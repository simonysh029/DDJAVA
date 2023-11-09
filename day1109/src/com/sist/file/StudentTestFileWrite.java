package com.sist.file;

import java.io.FileWriter;
import java.util.Scanner;

public class StudentTestFileWrite {
	public static void main(String[] args) {
		String name;
		int kor, eng, math, tot, avg;
		Scanner sc = new Scanner(System.in);
		System.out.println("이름을 입력==>");
		name = sc.next();
		System.out.println("국어점수==>");
		kor = sc.nextInt();
		System.out.println("영어점수==>");
		eng = sc.nextInt();
		System.out.println("수학점수==>");
		math = sc.nextInt();
		tot = kor + eng + math;
		avg = tot/3;

		String data = name+","+kor+","+eng+","+math+
				","+tot+","+avg+"\n";
		try {
			FileWriter fr = new FileWriter("c:/data/student.txt", true);
			fr.write(data);
			fr.close();
			System.out.println("파일에 출력하였습니다.");
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
				
	}
}






