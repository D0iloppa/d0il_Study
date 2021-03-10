package innerclass;

public class OutterClass {
	
	int a = 3;
//	int b = in_a;
	
	class InnerClass{
		void test() { System.out.println("헬로우 월드");}
		int in_a = a;
		int int_b;
		
	}
	
	public static class C{
		static void test() {System.out.println("정적 내부 클래스 호출");}
	}

}
