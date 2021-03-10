package Singleton;

public class Singleton_Ex {
	
	public static void main(String[] args) {
		Village_Well ourWell = Village_Well.getInstance(); //공용 우물
		
		System.out.println("처음 우물의 잔량 : " + ourWell.getBalance()+ "L\n");
		
		ourWell.drawWater(100);
		System.out.println("우물의 잔량 : " + ourWell.getBalance()+ "L");
		ourWell.pourWater(10);
		System.out.println("우물의 잔량 : " + ourWell.getBalance()+ "L");
				
	}

}
