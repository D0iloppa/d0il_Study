package quiz;

import java.util.Scanner;

public class Coin_Exchange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int money,c500,c100,c50,c10,rest;
		
		System.out.print("## 교환할 돈은 ? ");
		money = scanner.nextInt(); // 총 금액 정수값 입력받음
		
		c500 = money / 500; // 500원의 갯수 = 몫
		rest = money % 500; // 나머지
		System.out.printf("\n오백원짜리	==> %d 개\n",c500);
		
		c100 = rest / 100; // 500원의 갯수 = 몫
		rest = rest % 100; // 나머지
		System.out.printf("백원짜리	==> %d 개\n",c100);
		
		c50 = rest / 50; // 50원의 갯수 = 몫
		rest = rest % 50; // 나머지
		System.out.printf("오십원짜리	==> %d 개\n",c50);
		

		c10 = rest / 10; // 10원의 갯수 = 몫
		rest = rest % 10; // 나머지
		System.out.printf("십원짜리	==> %d 개\n",c10);
		System.out.printf("바꾸지 못한 잔돈 ==> %d 원\n", rest);
		

	}

}
