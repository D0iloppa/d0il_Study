package EndwordGame;

import java.util.Scanner;

public class Game {
	
	private int players_Num; // 게임 참가인원
	private Scanner sc;
	private String last_Word = "엄마";
	
	public int getPlayers_Num() {
		return players_Num;
	}



	public void setPlayers_Num(int players_Num) {
		this.players_Num = players_Num;
	}


	
	public Game() {
		sc = new Scanner(System.in);		
	}
	
	public void setPlayers_Name(Player[] player) {
		for(int i=0;i<player.length;i++) {
			System.out.print((i+1) + "번 참가자의 이름을 입력하세요>>");
			player[i] = new Player(sc.next()); // 객체 생성해서 배열에 연결해줘야한다.
		}
		

	}


	
	public String getLast_Word() {
		return last_Word;
	}


	public void setLast_Word(String last_Word) {
		this.last_Word = last_Word;
	}



	public void start() {
		
		System.out.print("게임에 참가하는 인원은 몇명입니까>>");
		setPlayers_Num(sc.nextInt()); //인원수 지정
		
		Player[] gamer = new Player[getPlayers_Num()]; // 입력받은 인원수 만큼 플레이어 생성
		// 주소값을 담을 수 있는 배열만 만드는 것이다. 실제 인스턴스화는 따로 시켜줘야 한다.
		
		int turn = 0; // 현재 턴
		boolean running = true;
		
		setPlayers_Name(gamer);
		
		start_Word();
		
		int first_Blood = -1;
		
		while(running) {
			System.out.print("['"+this.last_Word.charAt(this.last_Word.length()-1) + "']");
			// 끝말알려주기 
			
			String player_Word = gamer[turn].say_Word();
			if(chk_Wrd(player_Word) == false) break;
			
			first_Blood++; //
			
			this.last_Word = player_Word;		
			
			turn++; // 턴 증가
			turn %= gamer.length; // 턴이 참가자의 수보다 높은 값이 안나오도록		
		}
		// 마지막으로 말한 사람의 turn값이 나온다.
		// 게임에서 지게 되면, 나의 turn의 앞 차례(-1) 이 승자.
		turn = (--turn == -1) ?  gamer.length-1 : turn; // -1이면 끝값이 우승, 아니면 현재턴 
		
		System.out.println("땡! '" + this.last_Word.charAt(this.last_Word.length()-1)+ "'로 시작하는 단어를 써야죠");
		
		
		if(first_Blood == -1 )System.out.println("퍼스트 블러드");
		else System.out.println(gamer[turn].getName() + "의 승리");

	}

	private boolean chk_Wrd(String player_Word) {
		// TODO Auto-generated method stub
		return (this.last_Word.charAt(this.last_Word.length()-1) == player_Word.charAt(0));
	}


	private void start_Word() {
		// TODO Auto-generated method stub
		System.out.println("시작단어는 " + this.last_Word);
	}

	public static void main(String[] args) {
		Game myGame = new Game(); // 게임을 만들어낸다.
		myGame.start(); // 게임 시작
	}

}
