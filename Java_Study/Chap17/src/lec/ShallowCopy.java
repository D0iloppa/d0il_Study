package lec;

import java.util.Random;

public class ShallowCopy {

	public static void main(String[] args) {
		
		int a = -13;
		int result = myAbs(String.valueOf(a));
		
		System.out.println(result);
		
		
		Rectangle org = new Rectangle(1,1,9,9);
		Rectangle cpy;
		
		try {
			cpy = (Rectangle)org.clone();
			
			org.changePos(2, 2, 7, 7);
			
			org.showPosition();
			cpy.showPosition();
		} catch(CloneNotSupportedException e){
			e.printStackTrace();			
		}
		
		
		
		Random random = new Random();
		
		int r = random.nextInt(46);  // 0~30±îÁö
		
		System.out.println(r);
		
		
	}
	
	public static int myAbs(String s) {
		int result;
		
		if(s.charAt(0)=='-') s = s.substring(1);
			result = Integer.parseInt(s);
		
		return result;
	}

}
