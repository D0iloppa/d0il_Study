package lecture;

import java.util.Scanner;

public class Car {
	
	String company;
	String model;
	String color;
	int max_Speed;
	int speed;
	
	
	
	

	public Car(String company, String model, String color, int max_Speed, int speed) {
		super();
		this.company = company;
		this.model = model;
		this.color = color;
		this.max_Speed = max_Speed;
		this.speed = speed;
	}





	public void print_Speed() {
		System.out.println("현재속도 : " + speed + " KM");
	}
	

}
