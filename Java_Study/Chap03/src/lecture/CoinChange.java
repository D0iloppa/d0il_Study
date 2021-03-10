package lecture;

import java.util.Scanner;

public class CoinChange {

	public static void main(String[] args) {
		// 
		int totalMoney;
		try (Scanner scanner = new Scanner(System.in)) {
			String inputData = scanner.nextLine();
			
			totalMoney = Integer.parseInt(inputData);
		}
		
		int n500,n100,n50,n10,rest;
		n500 = totalMoney / 500;
		rest = totalMoney % 500;
		System.out.println("오백원짜리 ==> " + n500 + " 개");
		n100 = rest / 100;
		rest = rest % 100;
		System.out.println("백원짜리 ==> " + n100 + " 개");
		n50 = rest / 50;
		rest = rest % 50;
		System.out.println("오십원짜리 ==> " + n50 + " 개");
		n10 = rest / 10;
		rest = rest % 10;
		System.out.println("십원짜리 ==> " + n10 + " 개");
		System.out.println("바꾸지 못한 잔돈 ==> " + rest + " 원");
	

	}

}
