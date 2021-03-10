package lecture;

public class TenaryOperator {
	public static void main(String[] args)
	{
		if(args == null || args.length !=2)
		{
			System.out.println("help : java TenaryOperator number1 number2");
			return;
		}
		
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		int c = (a>b) ? (a-b) : (b-a);
		
		System.out.println((a>b ? "A > B" : "B >= A"));
		System.out.println("difference : " + c);
	}

}
