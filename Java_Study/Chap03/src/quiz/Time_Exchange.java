package quiz;

import java.util.Scanner;

public class Time_Exchange {
	public static void main(String[] args)
	{
		int hour,min,sec;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("## 계산할 초는 ? ");
		sec = scanner.nextInt();
		
		
		System.out.println();
		hour = sec / 3600;
		sec = sec % 3600;
		System.out.printf("시간은	==> %d 시간\n",hour);
		
		min = sec / 60;
		sec = sec % 60;
		System.out.printf("분은	==> %d 분\n",min);
		System.out.printf("초는	==> %d 초",sec);
		
		
	}

}
