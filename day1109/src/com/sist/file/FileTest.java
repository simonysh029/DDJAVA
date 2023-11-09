package com.sist.file;

import java.io.File;

public class FileTest {
	public static void main(String[] args) {
		File file = new File("c:/data/hello.txt");
		System.out.println("3초 뒤에 파일이 삭제됩니다.");
		try {
			Thread.sleep(3000);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		boolean flag = file.delete();
		System.out.println("파일을 삭제하였습니다.");
		System.out.println("flag:"+flag);
	}
	
}







