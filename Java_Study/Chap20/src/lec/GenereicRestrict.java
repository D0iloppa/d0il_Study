package lec;

interface First{}
interface Second{}
class Third{}
class Fourth implements First{}
class Fifth implements Second{}
class Sixth extends Third{}
class Seventh extends Third implements First,Second{}
class Eight implements First,Second{}

class MyBox <T extends Third & First & Second> {}

class NumberBox <T extends Number> {
	T number;

	public NumberBox(T number) {
		this.number = number;
	}
	boolean compare(T otherNumber) {
		return number.equals(otherNumber);		
	}
	
}


public class GenereicRestrict {
	
	public static void main(String[] args) {
		// MyBox<Fourth> mBox_01 = new MyBox<>(); // Fourth는 First만 구현하고 있기 때문에 오류
		MyBox<Seventh> mBox_02 = new MyBox<>(); // Third를 상속받고, First와 Second를 구현하고 있기 때문에 가능
		
		NumberBox<Integer> nBox = new NumberBox<>(100);
		System.out.println("check = "+nBox.compare(120));
		
		
	}

}
