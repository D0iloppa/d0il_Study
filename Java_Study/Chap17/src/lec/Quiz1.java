package lec;

import java.util.Random;
import java.util.Scanner;

public class Quiz1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		

		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int z = sc.nextInt();
		if(a>z) { // a가 z보다 클 경우 둘 순서 변경
			int tmp = a;
			a = z;
			z = tmp;			
		}
		
		Random random = new Random();
		
		// 기본 방법
		for(int i=0;i<10;i++) {
			int x = random.nextInt(z-a+1)+a;  // 0부터 생성하니 +a 를 해주면 a부터 숫자가 나옴	
			System.out.print(x + " ");
		}
		

		System.out.println();
		
		
		// 기본 방법
		for(int i=0;i<10;i++) {
			int x = random.nextInt(z)+a;  // 0부터 생성하니 +a 를 해주면 a부터 숫자가 나옴
			if(x>z)x=z; // 그 결과인 x가 z를 넘었을 경우 z라고 해줌	
			System.out.print(x + " ");
		}
		

		
		
		
		System.out.println("\n각각의 경계값을 따지는 방법");
		// 경계값 처리
		for(int i=0;i<10;i++) {
			int x = random.nextInt(z);
			if(x<a) {
				x+=a;
				if(x>z) x=z; // x가 z를 넘었을 경우
			}			
			System.out.print(x + " ");
		}
		
		System.out.println("\n또다른 방법 (랜덤값이 a보다 작으면 a보다 큰 값이 나올 때 까지 랜덤)");
		
		for(int i=0;i<10;i++) {
			int x = random.nextInt(z);
			if(x<a) {
				while(x<a)
					x=random.nextInt(z);			
			}			
			System.out.print(x + " ");
		}
		
		
		
		
		

	}

}
