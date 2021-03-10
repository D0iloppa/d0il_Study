package default_method;

public class DefaultMethod_Ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyInterface m1 = new ClassA(); // 클래스A가 구체화 되면서 디폴트 메소드를 상속받음
		m1.method1();
		m1.method2(); // 디폴트 메소드
		
		MyInterface m2 = new ClassB();
		m2.method1();
		m2.method2(); // 오버라이딩
		
		MyInterface.method3();

	}

}
