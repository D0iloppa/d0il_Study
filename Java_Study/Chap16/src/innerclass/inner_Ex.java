package innerclass;

public class inner_Ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OutterClass a = new OutterClass();
		OutterClass.InnerClass b = a.new InnerClass();

		
		
		
		OutterClass.InnerClass c = new OutterClass().new InnerClass();
		
		
//		OutterClass.InnerClass b = a.new InnerClass();
//		b.test();
		
		

	}

}
