package abstract_ex;

public abstract class Animal {
	
	public String kind;
	
	public void breathe() { System.out.println("숨을 쉽니다."); }
	abstract public void sound();

}
