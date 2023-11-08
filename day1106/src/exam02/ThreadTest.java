package exam02;
//Runnable 인터페이스를 이용한 것으로 수정 해 봅니다.
class Person extends Thread{
	String name;
	public Person(String name) {
		this.name = name;
	}
	
	public void run() {
		for(int i=1; i<=10; i++) {
			System.out.println(name+"가(이) 밥을 먹어요~");
			try {
				Thread.sleep(100);
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}


public class ThreadTest {
	public static void main(String[] args) {
		Person p1 = new Person("이문관");
		Person p2 = new Person("김지훈");
		
		//가능하면 공평하게 실행해봐!
		//"쓰레드를 가동"	==> start
		p1.start();
		p2.start();

	}

}