package method_override1;

public class Kumho_Tire extends Tire {

	public Kumho_Tire(int maxRotation, String location) {
		super(maxRotation, location);
	}
	
	@Override
	boolean roll() {
		accumulation_Rotate++;
		if(accumulation_Rotate < maxRotation) {
			System.out.println(location + " Tire ¼ö¸í : " + (maxRotation-accumulation_Rotate));
			return true;
		}else {
			System.out.println("****" + location + " Tire ÆãÅ© ****(ÄñÈ£Å¸ÀÌ¾î)");
			return false;
		}
	}

}
