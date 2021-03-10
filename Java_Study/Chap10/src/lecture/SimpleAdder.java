package lecture;

public class SimpleAdder {
	
	private int num;
	public SimpleAdder() {num=0;}
	public SimpleAdder add(int num) {
		this.num+=num;
		
		return this;
	}
	
	public void showResult() {
		System.out.println("add result : "+num);
	}

}
