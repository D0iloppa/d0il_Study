package dragonball;

public interface Songoku {
	
	public String getName();
	public void setName(String name);
	public void kamehameha(); // 에네르기파
	public void teleport(); // 텔레포트
	public default void kaiOhken() { // 계왕권
		System.out.println("계왕권~");
	}
	
}
