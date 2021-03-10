package my_company;

import hankook.*;
import hyundai.Engine;
import kumho.*;

public class Car {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		hyundai.Engine engin1 = new hyundai.Engine();
		Engine engin2 = new Engine();
		SnowTire tire1 = new SnowTire();
		kumho.Tire tire2;
		hankook.Tire tire3;
		
		tire1.setNum(13);
		int a = tire1.getNum();
		
		System.out.println(tire1.getNum());
		

	}

}
