package package1;



public class Class_B {
	
	public Class_B() {
		Class_A a = new Class_A();
		
		a.field1=1; // public
		a.field2=1; // default
//		a.field3=1; // private
		a.field4=1; // protected
		
//		int num = a.getField3(); 
		
//		a.method1();
//		a.method2();
//		a.method3();
		
		println("");
		
		
	}
	
	static void println(String s) {
		System.out.println(s);
	}

}
