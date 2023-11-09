package com.sist.file;

import java.io.File;

public class FileListTest {
	public static void main(String[] args) {
		File dir = new File("C:/javaStudy/day0925");
//		File dir = new File("c:/data/hello.txt");
		
		if(dir.isDirectory()) {
			System.out.println("디렉토리 입니다");
			
			String []list = dir.list();
			for(String fname:list) {	//디렉토리 안에 있는 모든 파일목록을 출력 해 봅니다.
				System.out.println(fname);
			}
		}else {
			System.out.println("디렉토리가 아닙니다.");
		}
	}
}
