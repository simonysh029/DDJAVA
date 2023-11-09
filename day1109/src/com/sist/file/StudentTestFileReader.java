package com.sist.file;

import java.io.BufferedReader;
import java.io.FileReader;

//문자열 파일을 한줄씩 읽어 들이고 싶어요!
//BufferedReader	readLine()
//BufferedReader(Reader in)	
//student.txt 파일의 내용을 모두 읽어 들여서 화면에 출력해 봅니다.

public class StudentTestFileReader {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("C:/data/student.txt"));
			
			String line = "";
			
//			while((line = br.readLine()) != null) {
//				System.out.println(line);
//			}
			
			//위의 while문은 아래 while문과 같은 기능
			while(true) {
				line = br.readLine();
				if(line == null) {
					break;
				}
				System.out.println(line);
			}
			
			br.close();
			
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		
	}	
}






