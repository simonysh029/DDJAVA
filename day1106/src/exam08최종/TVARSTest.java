package exam08최종;

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
			
		}
		
		System.out.println("전체모금액:"+account.getBalance());

	}
}
