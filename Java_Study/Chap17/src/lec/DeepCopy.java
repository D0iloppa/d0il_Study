package lec;

public class DeepCopy {

	public static void main(String[] args) {
		Rectangle org = new Rectangle(1,1,9,9);
		Rectangle cpy;
		Rectangle cpy_shallow = org;
		
		try {
			cpy = (Rectangle)org.clone();
			
			org.changePos(2, 2, 7, 7);
			
			System.out.println("<원본>");
			org.showPosition();
			System.out.println("<깊은 복사본>");
			cpy.showPosition();
			System.out.println("<얕은 복사본>");
			cpy_shallow.showPosition();
		} catch(CloneNotSupportedException e){
			e.printStackTrace();			
		}
		// 깊은 복사는 값들을 복사해서 완전히 새로운 개체로 생성됨
		// 얕은 복사는 껍데기만 복제하고 그 내용은 같은 인스턴스

	}

}
