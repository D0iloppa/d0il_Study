package rpg_game_Ex;

public abstract class Character {
	 String id;
	 
	 int health_Point, magic_Point;

	   Character(String id,int hp, int mp) { 
		   this.id = id;
		   this.health_Point = hp;
		   this.magic_Point = mp;
	   }

	   abstract void attack(); // 공격
	   abstract void defence(); // 방어
	   void use_Item() { System.out.println("아이템을 사용합니다."); }// 아이템 이용
	   void chat() { System.out.println("말합니다."); } // 채팅

}
