package LibraryEx;

import org.apache.commons.lang3.StringUtils;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String expression = "1+2-3/4*5=?";
		String[] splitStr = StringUtils.split(expression, "*?/-=+");
		
		for(String e : splitStr) System.out.println(e);
	

	}

}
