package test;

import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int day; // 총 몇일?
		int num_Man,num_Cap,num_Room; // 총원,한 방의 최대인원, 방의 수
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("몇 일간의 방 예약 일정?>");
		day = sc.nextInt();
		
		for(int i=1 ; i<=day ; i++) {
			System.out.println(i+"일 ");
			System.out.print("총 인원 수 :>");
			num_Man = sc.nextInt();
			System.out.print("한 방의 최대 인원 :>");
			num_Cap = sc.nextInt();
			
			if(num_Man % num_Cap == 0) num_Room = num_Man / num_Cap; // 총원을 한 방의 최대인원 으로 나누어 떨어지면 방의 수
			else num_Room = (num_Man / num_Cap) + 1; // 나누어 떨어지지 않으면 방의 갯수는 하나 더 필요
			
			
			System.out.println("("+i + "일차 필요한 방의 수 : " + num_Room + ")");
			System.out.println();

			
		}
		
		
	}

}
