package exam01;

class Person{
	String name;
	public Person(String name) {
		this.name = name;
	}
	
	public void eat() {
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

public class ThreadTest {
	public static void main(String[] args) {
		Person p1 = new Person("이문관");
		Person p2 = new Person("김지훈");
		p1.eat();
		p2.eat();
	}
}