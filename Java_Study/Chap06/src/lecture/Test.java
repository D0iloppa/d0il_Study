package lecture;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Marble child1,child2;
		
		child1 = new Marble(15);
		child2 = new Marble(9);
		
		child1.game(child1,child2,2);
		child1.game(child2,child2,7);
		
		System.out.println(child1.numOf_Marble+","+child2.numOf_Marble);

	}
	
	public static void game(Marble child1, Marble child2, int num)
	{
		child1.numOf_Marble += num;
		child2.numOf_Marble -= num;
	}

}
