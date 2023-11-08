package exam09쓰레드통신_1대1동작;

//main메소드의 내용을 채워서 결과를 확인해 봅니다.
public class MainTest {
	public static void main(String[] args) {
		
		Product p = new Product();		//제품 객체를 생성
		Producer pd = new Producer(p);	//생산자 객체를 생성
		Consumer cs = new Consumer(p);	//소비자 객체를 생성
		
		pd.start();						//생산자 쓰레드 가동
		cs.start();						//소비자 쓰레드 가동
	}
}
