package exam07Snchronized;

public class TVARSTest {
	public static void main(String[] args) {
		
		//모금액을 위한 Account 객체를 생성함
		Account account = new Account();

		//성금자의 이름과 모금액을 위한 account객체를 매개변수로 하여 5명의 성금자 객체를 생성한다.
		Doner d1 = new Doner("성금자1", account);
		Doner d2 = new Doner("성금자2", account);
		Doner d3 = new Doner("성금자3", account);
		Doner d4 = new Doner("성금자4", account);
		Doner d5 = new Doner("성금자5", account);
		
		//5명의 성금자가 경쟁적으로 입금을 하기 위하여 쓰레드를 가동시킨다.
		d1.start();
		d2.start();
		d3.start();
		d4.start();
		d5.start();
		
		//join() -> Waits for this thread to die. -> 5개가 모두 끝날때까지 기다리는 것
		try {
			d1.join();
			d2.join();
			d3.join();
			d4.join();
			d5.join();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println("전체모금액:"+account.getBalance());
		/*
	 	성금자5의 8번째 입금
		성금자1의 8번째 입금
		성금자4의 9번째 입금
		성금자2의 9번째 입금
		성금자5의 9번째 입금
		성금자1의 9번째 입금
		성금자3의 9번째 입금
		성금자4의 10번째 입금
		성금자2의 10번째 입금
		성금자5의 10번째 입금
		성금자3의 10번째 입금
		성금자1의 10번째 입금
		전체모금액:46000
		
		=> 금액이 이상하다
		5명이 1000원씩 10번 입금하면 50000원이어 하는데 오류남
		=> 공유자원에 두개 이상의 쓰레드가 한번에 접근해서
		이런 현상이 있을 수 있다.
		
		한번에 하나의 쓰레드에만 접근을 허용하기 위해서는 "임계영역"을 설정한다.
		자바에서는 임계영역 설정을 위하여 메소드 이름 앞에 "synchronized"를 입력한다.		
		 */
	}
}
