package exam04SetPriority;
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
		Person p3 = new Person("김범진");
		
		//최고 우선순위를 설정
//		p1.setPriority(10);
		p1.setPriority(Thread.MAX_PRIORITY);
		
		p1.start();
		p2.start();
		p3.start();

	}
}