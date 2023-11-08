package exam07Snchronized;

//모금액을 위한 클래스
public class Account {
	
	//잔액을 위한 변수
	private int balance;
	
	//입금을 위한 메소드
	//임계영역 설정을 위하여 메소드 이름 앞에 synchrnozied 붙임
	public synchronized void deposit(int amount) {
		balance += amount;
	}
	//현재 잔액을 반환하는 메소드
	public int getBalance() {
		return balance;
	}
}


