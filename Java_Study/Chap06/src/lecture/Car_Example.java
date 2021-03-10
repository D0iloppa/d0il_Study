package lecture;

import java.util.Scanner;

public class Car_Example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		Car myCar = new Car("현대자동차","그랜져","검정",300,80);
		Car yourCar = new Car("현대자동차","싼타페","흰색",250,100);
		
		System.out.println("제작회사 : " + myCar.company);
		System.out.println("모델명 : " + myCar.model);
		System.out.println("색상 : " + myCar.color);
		System.out.println("최대속도 : " + myCar.max_Speed + " KM");
		myCar.print_Speed();
		
		System.out.println();
		
		System.out.println("제작회사 : " + yourCar.company);
		System.out.println("모델명 : " + yourCar.model);
		System.out.println("색상 : " + yourCar.color);
		System.out.println("최대속도 : " + yourCar.max_Speed + " KM");
		yourCar.print_Speed();
					
	

	}

}
