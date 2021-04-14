package lecture;

import java.util.Scanner;

public class SimpleCal {
	public static void main(String[] args)
	{
		int num1,num2;
		char op;
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("첫번째 수를 입력하세요 : ");
		num1 = sc.nextInt();
		System.out.print("계산할 연산자를 입력하세요 : ");
//		op = sc.nextLine();
		op = sc.next().charAt(0);
		System.out.print("두번째 수를 입력하세요 : ");
		num2 = sc.nextInt();
		
		String result;
		switch(op)
		{
		case '+':
			result = String.valueOf(num1 + num2);
			break;
		case '-':
			result = String.valueOf(num1 - num2);
			break;
		case '*':
			result = String.valueOf(num1 * num2);
			break;
		case '/':
			result = String.valueOf((float)num1 / num2);
			break;
		case '%':			
			result = String.valueOf(num1 % num2);
			break;
		default:
			System.out.println("연산자를 잘못 입력했습니다.");
			return;
		}
	
		/*
		if(op == '+') result = String.valueOf(num1 + num2);
		else if(op == '-') result = String.valueOf(num1 - num2);
		else if(op == '*') result = String.valueOf(num1 * num2);
		else if(op == '/') result = String.valueOf((double)num1 / num2);
		else if(op == '%') result = String.valueOf(num1 % num2);
		else {
			System.out.println("연산자를 잘못 입력했습니다.");
			return;
		}
		*/
		
		System.out.printf("%d%s%d=%s",num1,op,num2,result);
//		System.out.println(num1 + op + num2 + "=" + result);
	}
	

}
