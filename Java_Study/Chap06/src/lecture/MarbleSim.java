package lecture;

public class MarbleSim {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Marble kid1,kid2; // 구슬치기하는 어린이1,어린이2 객체 생성
		kid1 = new Marble(15); // 어린이1은 15개의 구슬을 가지고 있다.
		kid2 = new Marble(9); // 어린이2는 9개의 구슬을 가지고 있다.
		
		//1차 게임
		kid1.win_Marble(kid2, 2); // 어린이1이 이겨서 2개의 구슬을 얻었다. (어린이2는 2개 감소)
		//2차 게임
		kid2.win_Marble(kid1, 7); // 어린이2가 이겨서 7개의 구슬을 얻었다. (어린이1은 7개 감소)
		
		System.out.println("kid1의 구슬갯수 : " + kid1.numOf_Marble);
		System.out.println("kid2의 구슬갯수 : " + kid2.numOf_Marble);

	}

}
