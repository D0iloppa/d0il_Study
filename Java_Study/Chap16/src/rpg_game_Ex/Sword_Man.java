package rpg_game_Ex;

public class Sword_Man extends Character {

	Sword_Man(String id, int hp, int mp) {
		super(id, hp, mp);
		// TODO Auto-generated constructor stub
	}

	@Override
	void attack() {		
		System.out.println("검사의 공격");
	}

	@Override
	void defence() {
		// TODO Auto-generated method stub

	}
	
	void skill() { System.out.println("스킬을 씁니다."); }
	

}
