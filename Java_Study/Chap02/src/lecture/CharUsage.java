package lecture;

public class CharUsage {
	public static void main(String[] args)
	{

		byte a = 10;
		byte b = 20;
		byte c = (byte) (a + b);
		
		System.out.println(c);
		
		char cV1 = 'a';
		char cV2 = 1;
		char cV3 = (char) (cV1 + cV2);
		
		System.out.println(cV3);
		
		int intV1 = 10;
		int intV2 = intV1 / 4;
		System.out.println(intV2);
		
		int intV3 = 10;
		int intV4 = (int) (10 / 4.0);
		System.out.println(intV4);
		
		double doubleV = intV3 / 4.2;
		System.out.println(doubleV);
		
	}

}

