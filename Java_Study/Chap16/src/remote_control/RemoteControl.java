package remote_control;

public interface RemoteControl {
	
	int MAX_VOL = 10;
	int MIN_VOL = 0;
	
	void turnOn();
	void turnOff();
	void setVolume(int volume);
	
	default void setMute(boolean mute) {
		if(mute) System.out.println("무음 처리합니다.");
		else System.out.println("무음 해제합니다.");
	}
	
	static void ChangeBattery() {
		System.out.println("건전지를 교환합니다.");
	}

}
