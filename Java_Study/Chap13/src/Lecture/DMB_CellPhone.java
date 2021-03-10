package Lecture;

public class DMB_CellPhone extends CellPhone {
	
	int chanel;
	
	public DMB_CellPhone(String model, String color, int chanel) {
		super(model, color);
		this.chanel = chanel;
	}
	
	void turnOnDMB() {
		System.out.println("채널 "+chanel+"번 DMB 방송 수신을 시작합니다.");
	}
	
	void changeChanel(int chanel) {
		this.chanel = chanel;
		System.out.println("채널 "+chanel+"번으로 변경합니다.");
	}
	
	void turnOffDMB() {
		System.out.println("DMB 방송 수신을 멈춥니다.");
	}

}
