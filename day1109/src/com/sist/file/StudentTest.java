package com.sist.file;

import java.util.Scanner;

public class StudentTest {
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
		System.out.println(name+","+kor+","+eng
							+","+math+","+tot+","+avg);
				
	}
}
