package Lecture;

public class CellPhone {
	
	String model, color;

	public CellPhone(String model, String color) {
		this.model = model;
		this.color = color;
	}
	
	void powerOn() {
		System.out.println("전원을 켭니다.");		
	}
	
	void powerOff() {
		System.out.println("전원을 끕니다.");		
	}
	
	void bell() {
		System.out.println("벨이 울립니다.");
	}
	
	void sendVoice(String message) {
		System.out.println("자신 : " + message);
	}
	
	void receiveVoice(String message) {
		System.out.println("상대 : " + message);
	}
	
	void hangUp() {
		System.out.println("전화를 끊습니다.");
	}
	

}
