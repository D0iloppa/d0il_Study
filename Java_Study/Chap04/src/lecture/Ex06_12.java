package lecture;

import java.util.Scanner;

public class Ex06_12 {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		//int i;
		int dan;
		
		System.out.print("¸î ´Ü ? ");
		dan = sc.nextInt();
		
		for(int i=1 ; i<= 9 ; i++)
			System.out.printf("%d x %d = %d\n", dan,i,dan*i);
		
	}

}
