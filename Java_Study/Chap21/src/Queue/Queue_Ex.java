package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class Queue_Ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Queue<Message> message = new LinkedList<>(); // 큐는 인터페이스라서 인스턴스가 되지 않는다. 
		
		message.offer(new Message("SendMail","아이유")); //offer는 큐에 집어넣는 메소드
		message.offer(new Message("SendSMS","블랙핑크"));
		message.offer(new Message("SendKakaoTalk","트와이스"));
		
		while(!message.isEmpty()) {
			Message me = message.poll(); // poll은 큐에서 꺼내는 메소드
			switch(me.command) {
				case "SendMail":
					System.out.println(me.to +"님에게 메일을 보냅니다.");
					break;
				case "SendSMS":
					System.out.println(me.to + "님에게 문자를 보냅니다.");
					break;
				case "SendKakaoTalk":
					System.out.println(me.to + "님에게 카톡을 보냅니다.");
					break;
			
			}
		}
		
		
		
		
		

	}

}
