package PhoneBookManager_ex;

public class PhoneInfo {
	
	String name; // 이름 
	String phoneNumber; // 전화번호
	
	public PhoneInfo(String name, String num){ // 생성자
		this.name = name;
		this.phoneNumber = num;
	}
	
	public void showPhoneInfo(){ // 이름과 전화번호 출력
		System.out.println("name: "+ name);
		System.out.println("phone: " + phoneNumber);
	}

}
