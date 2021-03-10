package test;

import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int kor=0,eng=0,math=0; // 국,영,수 성적
		Double avg; // 평균
		int menu,sub_Menu; // 입력받을 메뉴
		boolean run = true;
		
		Scanner sc = new Scanner(System.in);
		
		while(run) {
			
			System.out.println("1.성적입력 2.성적출력 3.종료");
			System.out.print("메뉴를 입력하세요>");
			menu = sc.nextInt();
			if(menu==1) { // 1번 성적입력
				
				System.out.println("1.국어 2.영어 3.수학");
				System.out.print("입력할 성적을 고르세요>");
				sub_Menu = sc.nextInt();
				
				if(sub_Menu==1){
					System.out.print("국어 성적 입력>");
					kor = sc.nextInt();					
				}
				else if(sub_Menu==2) {
					System.out.print("영어 성적 입력>");
					eng = sc.nextInt();	
				}
				else if(sub_Menu==3) {
					System.out.print("수학 성적 입력>");
					math = sc.nextInt();							
				}
				else System.out.println("메뉴를 잘못 입력하였습니다.");
				
			}
			else if(menu==2) { // 2번 성적출력
				avg = (kor + eng + math) / 3.0;
				System.out.printf("국어 : %d\n", kor);
				System.out.printf("영어 : %d\n", eng);
				System.out.printf("수학 : %d\n", math);
				System.out.printf("평균 : %f\n", avg);
				
			}
			else if(menu==3) { // 3번
				run = false;
				
			}
			else System.out.println("메뉴를 잘못 입력하였습니다.");
			
			System.out.println();
			
		}
		

	}

}
