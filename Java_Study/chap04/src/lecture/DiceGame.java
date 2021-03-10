package lecture;

public class DiceGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1=0,num2=0;
		
		while(num1+num2 != 5) {
			num1 = (int) (Math.random()*6)+1;
			num2 = (int) (Math.random()*6)+1;
			System.out.printf("(%d,%d)\n",num1,num2);
		}
		

	}

}
