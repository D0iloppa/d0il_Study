package PhoneBookManager_ex;

public class PhoneUnivInfo extends PhoneInfo {
	
	String major;
	int year;

	public PhoneUnivInfo(String name, String num, String major, int year) {
		super(name, num); // 부모클래스와 짝 맞춰줌
		// TODO Auto-generated constructor stub
		this.major = major;
		this.year = year;
	}
	
	
	public void showPhoneInfo() {
		super.showPhoneInfo(); // 기존의 정보 출력
		// 추가부분
		System.out.println("major: " + major);
		System.out.println("year: " + year);		
	}

}
