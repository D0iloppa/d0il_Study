package lec;

interface One{}
interface Two{}

class Three{}
class Four extends Three implements One,Two{}

class Five<T> {
	T clazz;

	public Five(T clazz) { this.clazz = clazz; }
	void display() { System.out.println(clazz);}
}

class Six{
	public static <T> void display(T src, Five<? super T> data) {
		data.display();
	}
}




public class Generic_Extends {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Four obj = new Four();
		Six.display(obj, new Five<One>(new One() {}));
		Six.display(obj, new Five<Two>(new Two() {}));
		Six.display(obj, new Five<Three>(new Three()));
		Six.display(obj, new Five<Four>(new Four()));
		Six.display(obj, new Five<Object>(new Object()));
		

	}

}
