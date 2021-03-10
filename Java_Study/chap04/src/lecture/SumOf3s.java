package lecture;

public class SumOf3s {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0;
		
		for(int i=1;i<=100;i++)
		 if(i%3 == 0) sum+=i;
		
		System.out.printf("1에서 100까지 3의 배수 합계: %d",sum);

	}

}
