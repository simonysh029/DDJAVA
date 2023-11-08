package exam05멀티쓰레드;

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
		//자바는 쓰레드 작동시 가능하면 스케쥴링해서 순차적으로 가동되게끔 하긴 하지만 아닐수도 있다.
		
		System.out.println("전체모금액:"+account.getBalance());
		/*
		전체모금액:2000
		성금자2의 1번째 입금
		성금자1의 1번째 입금
		성금자3의 1번째 입금
		성금자4의 1번째 입금
		성금자5의 1번째 입금
		성금자5의 2번째 입금
		성금자3의 2번째 입금
		성금자2의 2번째 입금
		성금자4의 2번째 입금
		성금자1의 2번째 입금
		성금자5의 3번째 입금
		성금자1의 3번째 입금
		 */
	}
}
