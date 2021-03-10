package lecture;

import java.util.Scanner;

public class StringScan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자열 1을 입력:");
		String str1 = sc.nextLine();
		System.out.print("문자열 2을 입력:");
		String str2 = sc.nextLine();
		
		System.out.println("합쳐진 문자열(스트링빌더 append)	==> " + new StringBuilder().append(str1).append(str2).toString());
		System.out.println("합쳐진 문자열(스트링빌더 insert)	==> " + new StringBuilder().insert(0,str1).insert(str1.length(),str2).toString());
		System.out.println("합쳐진 문자열(스트링 concat메소드)	==> " +str1.concat(str2));
		
		System.out.println("문자열 1 길이 ==> " + str1.length());
		System.out.println("문자열 2 길이 ==> " + str2.length());
		if(str1.equals(str2)) System.out.println("두 문자열은 같다.");
		else System.out.println("두 문자열은 다르다.");
		
		

	}

}
