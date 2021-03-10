package lecture;

public class Person{
	
	String gen;
	
	public static final Person MAN = new Person();
	public static final Person WOMAN = new Person();
	
	static {
		MAN.gen = "MAN";
		WOMAN.gen = "WOMAN";		
	}
	
	public String toString() {
		return this.gen;
	}
	
}