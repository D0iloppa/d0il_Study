package innerclass;

public class Test {
	
	public static void main (String [] args){
		Aa a1 = new Aa();
		a1.show();  // 원본 클래스의 메소드
		
		Aa a2 = new Aa(){ // 익명 중첩 클래스 정의
			public void show(){ System.out.println("새로 써준 익명 클래스"); }
		};
		 
		a2.show(); // 익명 클래스 테스
	}

}