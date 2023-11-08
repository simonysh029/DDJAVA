package exam09쓰레드통신_1대1동작;

//소비자 클래스를 만든다.
//생산자와 상관없이 계속하여 제품을 소비하도록 하기 위하는 멀티쓰레드가 되게 한다.
public class Consumer extends Thread {
	private Product product;			//생산자가 제품을 공유하기 위하여 멤버변수로 제품을 선언한다.
	
	public Consumer(Product product) {	//생성지에 제품을 멤버변수로 초기화
		this.product = product;
	}
	
	public void run() {					//run을 오버라이딩하여 소비자가 해야할 일을 써준다.
		for(int i=1; i<=10; i++) {		//10개의 제품을 소비하도록 한다.
			int newNumber = product.useNumber();
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
