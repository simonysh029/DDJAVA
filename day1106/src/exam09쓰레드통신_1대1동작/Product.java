package exam09쓰레드통신_1대1동작;

import java.util.Random;

//제품을 위한 클래스 만들기
//"새로운 정수"를 제품이라고 본다.
public class Product {

	//새 제품을 위한 정수형 변수를 선언한다.
	//생산자는 이 정수를 계속하여 새롭게 만들어 주고
	//소비자는 이 정수를 계속하여 가져다 쓰도록 합니다.
	int number;
	
	//새 제품이 생산되었는지 판별하기 위한 변수
	//생산자는 새 제품을 생산한 다음 isNew를 true를 저장하고
	//소비자는 제품을 소비한 다음 isNew에 false를 설정한다.
	boolean isNew;
	
	//생산자가 새 제품을 생산하기 위한 메소드 생산자는 새 제품을 만들고 있는 동안
	//소비자는 접근을 못해야 하므로 임계영역 설정을 위하여 synchronized 키워드를 붙인다.
	public synchronized void makeNumber() {
		try {
			while(isNew == true) {
				wait();
			}
			Random r = new Random();
			number = r.nextInt(100)+1;						//새 제품을 만든다.
			System.out.println("생산자가 생산함 ==> "+number);	//생산된 제품을 출력
			
			isNew = true;					//새 제품을 만들었다고 표시합니다.
			notify();						//대기중인 다른 쓰레드(소비자)를 깨운다.
			
		} catch (Exception e) {
			
		}
	}
	int n = number;

	public synchronized int useNumber() {	//소비자가 사용하는 메소드
		int n=0;
		try {					
			while(isNew == false) {			//새로운 제품이 생산될때까지 기다려요
				wait();
			}
			n = number;						//제품을 소비합니다.
			System.out.println("소비자가 소비함:"+n);
			isNew = false;					//소비했다는 표시를 합니다.
			notify();						//대기중인 다른 쓰레드(생산자)를 깨워줍니다.
		} catch (Exception e) {
			
		}
		return n;
	}
}
