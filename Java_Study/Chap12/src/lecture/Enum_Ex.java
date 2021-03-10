package lecture;

import java.util.Calendar;

public class Enum_Ex {
	
	
	public enum Week { // 파일 이름과 동일한 이름으로 다음과 같이 선언
		 MONDAY,
		 TUESDAY,
		 WEDNESDAY,
		 THURSDAY,
		 FRIDAY,
		 SATURDAY,
		 SUNDAY;
		 
		 private Week() {
			 System.out.println("Week 생성자 Called");
		 }
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Week today = null;
		
		Calendar cal = Calendar.getInstance(); // 참고로 Calendar는 singletone패턴으로 만들어진 클래스다.
		int week = cal.get(Calendar.DAY_OF_WEEK);
		switch(week) {
			case 1:
				today = Week.SUNDAY;
				break;
			case 2:
				today = Week.MONDAY;
				break;
			case 3:
				today = Week.TUESDAY;
				break;
			case 4:
				today = Week.WEDNESDAY;
				break;
			case 5:
				today = Week.THURSDAY;
				break;
			case 6:
				today = Week.FRIDAY;
				break;
			case 7:
				today = Week.SATURDAY;
				break;
		}
		
		System.out.println("오늘 요일 : " + today);
		
		if(today==Week.SUNDAY) System.out.println("일요일에는 내가 짜파게티 요리사");
		else System.out.println("열심히 공부.... 합시다.");
		
		
		Person a = Person.MAN;
		System.out.println(a);
		System.out.println(Person.WOMAN);
		


	}

}
