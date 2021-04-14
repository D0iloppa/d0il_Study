package lecture;

public class PrintStar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("직각삼각형");
		for(int i=1;i<=5;i++)
		{
			for(int j=1;j<=i;j++)
				System.out.printf("*");
		     System.out.println();
		}
		
		System.out.println("\n이등변삼각형");
		int h = 5 ; // 높이
		for(int i=1;i<=h;i++)
		{
			for(int j=1;j<=(2*h)-1;j++) // 밑변 길이는 2h-1
			{
				if(j<=(h-i) || j>=(i+h)) System.out.print(" ");
				else System.out.print("*");
				
			}
			System.out.println();
		}
		
		
		System.out.println("\n");
		
//		System.out.println("[ b,  p]");
		int max = 17; // 단, 좌우대칭을 위해 최대값은 홀수
		
		int mid = (max /2) + 1; // 중위값 (최대값 / 2)
		int b_factor = mid , p_factor = 0; // 공백과 별을 몇번 찍을지 결정하는 인자
		
		for(int i=1;i<=max;i++)
		{	
			if(i<=mid) {
				b_factor = (mid) - i;
				p_factor = (2*i)-1;
			}
			else {
				b_factor = i - mid;
				p_factor= (2*max +1) - (2*i);
			}
			printRoutine(b_factor,' ');
			printRoutine(p_factor,'*');
			
			/*
			System.out.printf("[%2d, %2d]  : ", b_factor,p_factor);
			
			for(int j=1;j<=b_factor;j++)
				System.out.printf(" ");
			
			for(int k=1;k<=p_factor;k++)
				System.out.printf("*");
			*/
			
			
		     System.out.println();
		}
		
		

	}

	public static void printRoutine(int n,char x)
	{
		for(int i=0;i<n;i++)
			System.out.print(x);
		
		return ;
	}
}