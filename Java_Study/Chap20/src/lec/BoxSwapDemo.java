package lec;

class Box<T extends Number>{
	private T ob;
	
	public void set(Number o) { ob = (T) o; } // 받아오는 인자가 Number타입임을 명시
	public T get() {return ob;}
}

public class BoxSwapDemo {
	// 일반 제네릭으로 구현
	public static <T extends Number>void swapBox(Box<T> a, Box<T> b) {
		Box<T> tmp = new Box<T>();
		tmp.set(a.get());
		a.set(b.get());
		b.set(tmp.get());
		
	}
	
	// 와일드카드로 구현
	public static void swapBox2(Box<? extends Number> a, Box<? extends Number> b) {
		Box<Number> tmp = new Box<>();
		tmp.set(a.get());
		a.set(b.get());
		b.set(tmp.get());
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Box<Integer> box1 = new Box<>();
		box1.set(99);
		
		Box<Integer> box2 = new Box<>();
		box2.set(55);
		
		System.out.println(box1.get() + " & " + box2.get());
		swapBox(box1,box2);
		System.out.println(box1.get() + " & " + box2.get() + "\n");
		
		
		
		Box<Float> box3 = new Box<>();
		box3.set(9.9);
		Box<Float> box4 = new Box<>();
		box4.set(5.5);
		
		System.out.println(box3.get() + " & " + box4.get());
		swapBox2(box3,box4);
		System.out.println(box3.get() + " & " + box4.get());
		
		
	
		

	}
	

}
