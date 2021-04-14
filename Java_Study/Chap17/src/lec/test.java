package lec;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rect a = new Rect(2,3);
		Rect b = new Rect(3,2);
		Rect c = new Rect(3,4);

		System.out.println(a.equals(b));
		System.out.println(b.equals(c));
		System.out.println(c.equals(a));

	}

}
