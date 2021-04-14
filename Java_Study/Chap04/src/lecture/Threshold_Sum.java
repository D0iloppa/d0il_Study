package lecture;

import java.util.Scanner;

public class Threshold_Sum {
	// 시작값,끝값,증가값 입력 합계

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int start_val,end_val,weight;
		int sum = 0;
		
		System.out.print("시작값 입력 : ");
		start_val = sc.nextInt();
		System.out.print("끝값 입력 : ");
		end_val = sc.nextInt();
		System.out.print("증가값 입력 : ");
		weight = sc.nextInt();
		
		/*
		for(int i=start_val;i<=end_val;i+=weight)
			sum += i;
		*/
		
		int an = start_val;
		for(int n=1;an<end_val;n++)
		{
			an = start_val + (n-1)*weight;
			if(an<=end_val) sum += an;
		}
		
		System.out.printf("%d에서 %d까지 %d씩 증가한 값의 합: %d",start_val,end_val,weight,sum);
		
		// 등차가3인 등차수열의 합 (시작값,끝값)
		
		
	}

}
