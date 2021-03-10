package remote_control;

public class Audio implements RemoteControl {

	int volume;

	@Override
	public void turnOn() { System.out.println("오디오를 켭니다.");}

	@Override
	public void turnOff() { System.out.println("오디오를 끕니다.");}
	
	@Override
	public void setVolume(int volume) {
		if(volume>RemoteControl.MAX_VOL) this.volume = RemoteControl.MAX_VOL;
		else if(volume<RemoteControl.MIN_VOL) this.volume = RemoteControl.MIN_VOL;
		else this.volume = volume;
		
		System.out.println("현재 오디오의 볼륨 : "+ this.volume);
	}

}
