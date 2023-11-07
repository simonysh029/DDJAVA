package exam05;

import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;

//한빛출판사의 새책정보의 html문서의 내용을 모두 긁어와서 출력하기.
public class URLTest {
	public static void main(String[] args) {
		try {
			
			//한빛출판사 사이트의 새 책 정보의 인터넷 주소(URL)를 갖고 URL 객체를 생성한다.
			URL url = new URL("https://hanbit.co.kr/store/books/new_book_list.html");
			
			//그 문서의 내용을 내 컴퓨터로 읽어들이기 위하여 스트림을 생성한다.
			InputStream is = url.openStream();
			
			//네트워크를 통해 한번에 읽어들일 데이터를 담기 위한 byte의 배열을 만든다.
			byte []data = new byte[100];
			
			//스트림의 끝이 아닐때까지 읽어들여라
			while(is.read(data) != -1) {
				
				//네트워크를 통해 읽어들인 데이터가 담긴 바이트 배열을 갖고 String객체를 만든다.
				String str = new String(data);
				
				//문자열을 화면에 출력한다.
				System.out.println(str);
				
				//다음 데이터를 읽어들이기 위하여 배열을 0으로 초기화 한다.
				Arrays.fill(data, (byte)0);
			}
			
			//다 읽어들인 후 반복문을 탈출하면 사용했던 스트림을 닫아준다.
			is.close();
			
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
}
