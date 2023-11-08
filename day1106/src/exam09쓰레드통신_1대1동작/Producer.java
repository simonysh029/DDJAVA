package exam09쓰레드통신_1대1동작;

//생산자 클래스를 만들어서 소비자와 상관없이 계속하여 새로운 제품을 생산케 하기 위하여
//Thread클래스를 상속받아 멀티쓰레드가 가능하도록 합니다.
public class Producer extends Thread {
	private Product product;			//제품을 멤버변수로 선언합니다.
	
	public Producer(Product product) {	//생성시에 제품을 매개변수로 전달받아 초기화 한다.
		this.product = product;			//이 제품이 소비자와 공유하는 자원이다.
	}

	public void run() {					//생산자 쓰레드가 해야 할 일을 run을 오버라이딩하여 써 준다.
		for(int i=1; i<=10; i++) {		//10개의 새로운 제품을 생산하도록 한다.
			try {
				product.makeNumber();
			} catch (Exception e) {
				
			}
		}
	}
}













