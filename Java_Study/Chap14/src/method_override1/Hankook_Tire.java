package method_override1;

public class Hankook_Tire extends Tire {

	public Hankook_Tire(int maxRotation, String location) {
		super(maxRotation, location);		
	}

	@Override
	boolean roll() {
		accumulation_Rotate++;
		if(accumulation_Rotate < maxRotation) {
			System.out.println(location + " Tire ¼ö¸í : " + (maxRotation-accumulation_Rotate));
			return true;
		}else {
			System.out.println("****" + location + " Tire ÆãÅ© **** (ÇÑÄîÅ¸ÀÌ¾î)");
			return false;
		}
	}
	
	

}
