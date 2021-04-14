package WildCard;

public class Course<T> {
	
	String name;
	T[] student;
	
	public Course(String name, int size) {
		super();
		this.name = name;
		// 기본적으로 student의 타입을 모르기때문에 Object로 배열을 생성하고 T[]로 형변환 해준다.
		this.student = (T[]) new Object[size]; 		
	}

	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public T[] getStudent() {
		return student;
	}

	public void setStudent(T[] student) {
		this.student = student;
	}
	
	void add(T t) { // 배열의 한 값의 자료형은 T
		for (int i=0;i<student.length;i++) {
			// 배열의 시작점을 모르기 때문에 null인 곳을 찾아가주는 코드
			if(student[i]==null) {
				student[i] = t;
			}
		}
	}
	
	
	
	

}
