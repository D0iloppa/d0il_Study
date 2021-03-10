package Singleton;

public class Village_Well { // 공용 우물
	
	private static Village_Well well = new Village_Well();
	private int balance = 10000; // 우물의 남아있는 물의 양 | 기본은 10000L
	
	private Village_Well() {} // 생성자를 잠궈놓는다.
	public static Village_Well getInstance() { return well; }
	
	public int getBalance() { // 우물의 잔량을 표시
		return balance;
	}
	public int drawWater(int water) { // 우물에서 물을 긷는다.
		return balance -= water;
	}
	public void pourWater(int water) { // 우물에 물을 붓는다.
		this.balance += water;
	}
	

}
