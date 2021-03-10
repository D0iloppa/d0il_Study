package lecture;

import lecture.Enum_Ex.Week;

public class EnumMethod_Ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Week today = Week.SUNDAY;
		System.out.println(today.name());
		System.out.println(today.ordinal());
		
//		Week day1 = Week.MONDAY;
		Week day2 = Week.WEDNESDAY;
//		int result1 = day1.compareTo(day2);
//		int result2 = day2.compareTo(day1);
		
//		System.out.println(result1 + " , " + result2);
		
		Week weekDay = Week.valueOf("SUNDAY");
		if(weekDay==Week.SUNDAY || weekDay==Week.SATURDAY) {
			System.out.println("¡÷∏ª");
		}
		
		Week[] days = Week.values();
		for(Week day : days) System.out.print(day + " ");
		

	}

}
