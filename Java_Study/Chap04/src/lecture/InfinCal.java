package lecture;

import java.util.Scanner;

public class InfinCal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1,num2;
		
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
		System.out.print("계산할 첫번째 수 입력 : ");
		num1 = sc.nextInt();
		System.out.print("계산할 두번째 수 입력 : ");
		num2 = sc.nextInt();
		System.out.print("계산할 연산자를 입력하세요 : ");
		String op = sc.nextLine();
		op = sc.nextLine();
		
		String result = null;

		/*
		if(op.equals("+")) result = String.valueOf(num1 + num2);
		else if(op.equals("-")) result = String.valueOf(num1 - num2);
		else if(op.equals("*")) result = String.valueOf(num1 * num2);
		else if(op.equals("/")) result = String.valueOf((double)num1 / num2);
		else if(op.equals("%")) result = String.valueOf(num1 % num2);
		else {
			System.out.println("연산자를 잘못 입력했습니다.");
			return;
		}*/
		
		switch(op)
		{
		case "+":
			result = String.valueOf(num1 + num2);
			break;
		case "-":
			result = String.valueOf(num1 - num2);
			break;
		case "*":
			result = String.valueOf(num1 * num2);
			break;
		case "/":
			result = String.valueOf((float)num1 / num2);
			break;
		case "%":			
			result = String.valueOf(num1 % num2);
			break;
		default:
			System.out.println("연산자를 잘못 입력했습니다.");
			break;
		}
		System.out.printf("%d %s %d = %s 입니다.\n",num1,op,num2,result);
	 }

	}

}
