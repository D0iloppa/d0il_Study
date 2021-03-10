package method_override1;

public class Car {
	
	Tire frontLeftTire = new Tire(6, "앞 왼쪽");
	Tire frontRightTire = new Tire(2, "앞 오른쪽");
	Tire backLeftTire = new Tire(3, "뒤 왼쪽");
	Tire backRightTire = new Tire(4, "뒤 오른쪽");
	
	int run() {
		System.out.println("[자동차가 달립니다.]");
		if(!frontLeftTire.roll()) {
			stop();
			return 1; // 앞 왼쪽 타이어의 번호를 1이라 명명
		}else if(!frontRightTire.roll()) {
			stop();
			return 2;
		}else if(!backLeftTire.roll()) {
			stop();
			return 3;
		}else if(!backRightTire.roll()) {
			stop();
			return 4;
		}
		return 0;
	}
	
	void stop() {
		System.out.println("[자동차가 멈춥니다.]");
	}
	

}
