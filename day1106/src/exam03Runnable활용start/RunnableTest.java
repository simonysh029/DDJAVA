package exam03Runnable활용start;

class Person implements Runnable{
	String name;
	public Person(String name) {
		this.name = name;
	}
	
	public void run() {
		for(int i=1; i<=10; i++) {
			System.out.println(name+"가(이) 밥을 먹어요!");
			try {
				Thread.sleep(100);
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}


public class RunnableTest {
	public static void main(String[] args) {
		Person p1 = new Person("이문관");
		Person p2 = new Person("김지훈");
//		p1.start();
//		p2.start();
//		Runnable을 구현한 객체가 바로 start를 호출 할 수 없어요!
//		Thread객체로 포장해서 start를 호출 할 수 있어요.
//		Thread(Runnable target) 이 생성자를 이용합니다.
		
//		Thread t1 = new Thread(p1);
//		Thread t2 = new Thread(p2);
//		t1.start();
//		t2.start();
		
		(new Thread(p1)).start();
		(new Thread(p2)).start();
		
		
	}

}