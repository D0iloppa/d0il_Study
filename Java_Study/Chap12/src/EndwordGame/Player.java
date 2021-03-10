package EndwordGame;

import java.util.Scanner;

public class Player {
	private String name; // 플레이어 이름
	private String my_Word; // 내가 말한 말
	private Scanner sc; // 스캐너
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String say_Word() {// 플레이어가 말 을하는 것
		System.out.print(this.name+">>");
		
		return my_Word = sc.next();		
		
	}
	
//	public boolean pass(String word) {
//	
//		
//	}

	public Player(String name) {
		sc = new Scanner(System.in);
		this.name = name; 		
	}
	
	

}
