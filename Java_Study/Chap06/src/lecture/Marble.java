package lecture;

public class Marble { // 구슬 클래스
	int numOf_Marble; // 구슬의 갯수

	public Marble(int numOf_Marble) { // 생성자
		this.numOf_Marble = numOf_Marble;
	}
	
	public void win_Marble(Marble you, int numOf_Marble) { // 상대방으로부터 구슬을 얻는 것
		you.numOf_Marble -= numOf_Marble; // 이겼으니까 상대방의 구슬을 가져옴 (=내가 가져온 만큼 감소)
		this.numOf_Marble += numOf_Marble; // 나의 구슬의 갯수는 증가
	}
	
	public void game(Marble child1, Marble child2, int num)
	{
		child1.numOf_Marble += num; // 게임에서 이겼으니까 구슬 갯수 증가시켜줘야 한다. child1의 구슬 갯수를 증가시켜준다.
		child2.numOf_Marble -= num; // 게임에서 졌으니까 구슬 갯수 감소시켜줘야 한다. child2의 구슬 갯수를 감소
	}


}
