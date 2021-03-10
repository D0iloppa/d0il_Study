package test;

import java.util.Scanner;

public class Exercise {

	public static void main(String[] args) {
		boolean run = true;
		int balance = 0; // 잔고
		
		Scanner scanner = new Scanner(System.in);
		
		while(run)
		{
			
			System.out.println("------------------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("------------------------------------");
			System.out.print("선택> ");
			
			int money; // 메뉴번호와 예출금 변동을 위한 변수
			
		    switch( scanner.nextInt() ) {
		    case 1: // 예금
		    	System.out.print("예금액>");
				money = scanner.nextInt();
				if(money>=0) balance += money; // 양수범위의 값만 입력받음
				else System.out.println("잘못된 입력값");
				System.out.println();
		    	break;
		    	
		    case 2:
		    	System.out.print("출금액>");
		    	money = scanner.nextInt();
				if(money>=0 && money<=balance) balance -= money; // 양수범위의 값만 입력받고 잔고를 초과하지 않는 출금액만 허용
				else if(money>balance) System.out.println("출금하려는 금액이 잔고를 초과합니다. 출금할 수 없습니다."); // 잔고보다 많은 금액 출금 불가
				else System.out.println("잘못된 입력값");
				System.out.println();
		    	break;
		    	
		    case 3:
		    	System.out.printf("잔고>%d\n\n",balance);
		    	break;
		    	
		    case 4:
		    	run = false; // 프로그램 종료
		    	System.out.println();
		    	break;
		    	
		    default:
		    	System.out.println("메뉴를 잘못 입력 하였습니다.\n");
		    }
		  
		}
		
		System.out.println("프로그램 종료");
	}

}
