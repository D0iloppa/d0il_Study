package remote_control;

public class Remotecon_Ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RemoteControl rc = new TV();
		rc.turnOn();
		rc.setVolume(5);
		rc.setMute(true);
		rc.turnOff();
		
		System.out.println();
		rc = new Audio();
		rc.turnOn();
		
		RemoteControl.ChangeBattery();
		rc.setVolume(11);
		rc.turnOff();

	}

}
