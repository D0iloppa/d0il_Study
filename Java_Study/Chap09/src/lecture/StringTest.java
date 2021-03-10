package lecture;

public class StringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String target = "Hello World";
		
		System.out.println(target.concat(" and ¾È³ç ¼¼»ó"));
		System.out.println(target.substring(3));
		System.out.println(target.substring(3, 8));
		System.out.println(target.replace('o', '0'));
		System.out.println(target.replace("Hello", "¾È³ç"));
		System.out.println(target.toLowerCase());
		System.out.println(target.toUpperCase());
		System.out.println(target+"\n");

	}

}
