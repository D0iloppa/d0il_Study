package method_override1;

public class Tire {
	
	int maxRotation;
	int accumulation_Rotate = 0;
	String location;
	
	public Tire(int maxRotation, String location) {
		this.maxRotation = maxRotation;
		this.location = location;
	}
	
	
	boolean roll() {
		accumulation_Rotate++;
		if(accumulation_Rotate < maxRotation) {
			System.out.println(location + " Tire ¼ö¸í : " + (maxRotation-accumulation_Rotate));
			return true;
		}else {
			System.out.println("****" + location + " Tire ÆãÅ© ****");
			return false;
		}
	}
	
	

}
