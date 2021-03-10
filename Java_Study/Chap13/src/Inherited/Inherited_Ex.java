package Inherited;

public class Inherited_Ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a = new B();
		B b = new B();
		
		a.test();		
		b.test();
		System.out.println(a.test + " " + b.test);
		
		A aa = new A();
		B bb = new B();
		
		System.out.println(aa instanceof B);
		
	}
}
