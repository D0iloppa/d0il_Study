package method_override1;

public class Car_Ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Car car = new Car();
		
		for(int i=1;i<=23; i++) {
			int punk_Location = car.run();
			switch(punk_Location) {
				case 1 :
					System.out.println("앞 왼쪽 HanKook Tire로 교체");
					car.frontLeftTire = new Hankook_Tire(15,"앞 왼쪽");
					break;
				case 2 :
					System.out.println("앞 오른쪽 Kumho Tire로 교체");
					car.frontRightTire = new Kumho_Tire(13,"앞 오른쪽");
					break;
				case 3 :
					System.out.println("뒤 왼쪽 HanKook Tire로 교체");
					car.backLeftTire = new Hankook_Tire(15,"뒤 왼쪽");
					break;
				case 4 :
					System.out.println("뒤 오른쪽 HanKook Tire로 교체");
					car.backRightTire = new Kumho_Tire(13,"뒤 오른쪽");
					break;
				default :						
			}
			
			System.out.println("----------------------");
		}

	}

}
