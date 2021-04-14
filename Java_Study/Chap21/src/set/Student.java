package set;

public class Student {
	
	int sno;
	String name;
	
	public Student(int sno, String name) {
		this.sno = sno;
		this.name = name;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return (sno+name.hashCode())/2;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		
		if(obj instanceof Student) {
			Student student = (Student) obj; // 형변환 가능하면 형변환
			return (sno==student.sno)&&(name.equals(student.name));
		}
		
		return false;
	}

	@Override
	public String toString() {
		return "[학번=" + sno + ", 이름=" + name + "]";
	}
	
	
	
	
	

}
