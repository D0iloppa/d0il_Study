package innerclass;

public class A { // Outter 클래스
	
	A(){ System.out.println("A객체가 생성됨"); }
	
	int num = 0;
	static int sum = 0;
	
	public class B { // 인스턴스 내부 클래스
		B() { System.out.println("B객체가 생성됨"); }
		
		int field1;
		// static int field2; // 이너클래스에서는 아직 객체가 생성되지 않아서 안의 멤버필드가 static일 수 없다.  
		void method1() { }
		// static void method2() {} // 이너클래스에서는 아직 객체가 생성되지 않아서 안의 멤버메소드가 static일 수 없다.
		
		int tot = num; // 외부 클래스의 멤버 접근 가능
		// num = 3; // 외부 클래스의 멤버의 값 수정은 불가능(오류남)
		
	}
	
	static class C { // 정적 내부 클래스
		C() { System.out.println("C객체가 생성됨"); }
		int field1;
		static int field2; 
		void method1() { }
		static void method2() {} 
	    
		// int tot = num; // 외부 클래스가 인스턴스화 되지 않았기 때문에 오류(내부 클래스만 인스턴스화 되었기 때문)
		
	}
	
	void method() { // 지역 클래스
		
		int tot = 0;
		
		class D{
			D(){ System.out.println("D객체가 생성됨"); }
			
			int field1;
			// static int field2; 내부 클래스까지 static 확인하지 않아서 오류
			int method_D() {
				return field1;				
			}
			
		}
		
		tot++;
		D d = new D();
		d.field1 = 3;
		System.out.println(d.method_D());
		
	}
	
	

}
