package lecture;

import java.util.Scanner;

public class StringTest {
	
	
	
	public static void main(String[] args) {
	
		String src = "나는 한국인";
		
		Scanner sc = new Scanner(src);
		
		String a = sc.next();
		String b = sc.next();
		
		System.out.println(a);
		System.out.println(b);
		
		String[] strArray2 = {"나는","한국인","입니다"};
		
		System.out.println(strArray2[2]);
		
		
	}

}
