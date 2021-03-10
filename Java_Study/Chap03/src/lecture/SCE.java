package lecture;

public class SCE {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		int num1 = 0, num2 = 0;
		boolean result ; 
		
		result =  (num1+=10) < 0 && (num2+=10) > 0;
		System.out.printf("result=%s\n",String.valueOf(result));
		System.out.println("num1 : " + num1 + " , num2 : " + num2);
		
		result = (num1+=10) > 0 || (num2+=10) > 0;
		System.out.println("num1 : " + num1 + " , num2 : " + num2);

	}

}
