package remote_control;

public class TV implements RemoteControl {
	
	int volume;

	@Override
	public void turnOn() { System.out.println("TV¸¦ ÄÕ´Ï´Ù.");}

	@Override
	public void turnOff() { System.out.println("TV¸¦ ²ü´Ï´Ù.");}
	
	@Override
	public void setVolume(int volume) {
		if(volume>RemoteControl.MAX_VOL) this.volume = RemoteControl.MAX_VOL;
		else if(volume<RemoteControl.MIN_VOL) this.volume = RemoteControl.MIN_VOL;
		else this.volume = volume;
		
		System.out.println("ÇöÀç TVÀÇ º¼·ý : "+ this.volume);
	}

}
