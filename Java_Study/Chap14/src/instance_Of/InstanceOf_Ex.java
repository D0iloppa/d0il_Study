package instance_Of;

public class InstanceOf_Ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		Parent parentA = new Child(); // Child로 업캐스팅
		method(parentA);
		
		parentA = new Parent(); // 슈퍼클래스
		method2(parentA); // 다운캐스팅 실패

	}
	
	static void method(Parent p) {
		if(p instanceof Child) {
			Child child = (Child) p;
			System.out.println("Child 변환 성공");
		}else {
			System.out.println("Child 변환 실패");
		}		
	}
	
	public static void method2(Parent p) {
		Child c = (Child)p;
		System.out.println("Child 변환 성공");
		
	}

}
