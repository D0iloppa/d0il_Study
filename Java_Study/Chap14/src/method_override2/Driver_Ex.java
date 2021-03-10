package method_override2;

public class Driver_Ex {
	
	public static void main(String[] args) {
		
		Driver driver = new Driver();
		
		
		Bus bus = new Bus();
		Taxi taxi = new Taxi();
		
		driver.drive(taxi);
		driver.drive(bus);
		
		System.out.println();
		
		Vehicle vehicle = new Bus();
		driver.drive(vehicle);
		
		vehicle = new Taxi();
		driver.drive(vehicle);
		
	}

}
