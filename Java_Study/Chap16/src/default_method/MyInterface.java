package default_method;

public interface MyInterface {

	public void method1();	
	public default void method2() {	System.out.println("MyInterface-method2 실행");	}
	static void method3() {	System.out.println("MyInterface-method3 실행"); }
	public default void method4() {	System.out.println("MyInterface-method4 실행"); }

}
