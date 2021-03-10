package Lecture;

public class DMB_Ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DMB_CellPhone myPhone = new DMB_CellPhone("아이폰","블랙",10);
		
		System.out.println("모델 : " + myPhone.model);
		System.out.println("색상 : " + myPhone.color);
		System.out.println("채널 : " + myPhone.chanel);
		
		
		myPhone.powerOff();
		myPhone.sendVoice("여보세요");
		myPhone.receiveVoice("왜요");


	}

}
