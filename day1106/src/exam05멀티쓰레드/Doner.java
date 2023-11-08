package exam05멀티쓰레드;

//성금자를 위한 클래스
//다른 성금자와 관계없이 계속하여 입금을 하기 위하여 쓰레드를 상속받는다.
public class Doner extends Thread {
	
	//생성자를 위한 멤버변수
	String name;
	
	//다른 성금자와 모금액을 공유하기 위하여 모금액 클래스인 Account를 멤버변수로 선언한다.
	Account account;
	
	//생성시에 모금액 객체를 매개변수로 전달받아 초기화함
	public Doner(String name, Account account) {
		this.name = name;
		this.account = account;
	}
	
	//성금자가 해야할 일을 run을 오버라이딩하여 써 준다.
	public void run() {
		
		//1000원씩 10번을 입금하도록 해보기 -> sychronized 해놓지 않고 출력시의 확인을 위해
		for(int i=1; i<=10; i++) {
			account.deposit(1000);
			System.out.println(name+"의 "+i+"번째 입금");
			
			try {
				Thread.sleep(100);
			}catch (Exception e) {
				
			}
		}
	}
}
