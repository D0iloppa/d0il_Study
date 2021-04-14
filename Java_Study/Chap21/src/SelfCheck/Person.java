package SelfCheck;

import set.Student;

public class Person {
	
	private String name;
	private int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return name + "(" + age + "세)";		
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return (age+name.hashCode())%2;
	}

	@Override
	public boolean equals(Object obj) {
		
	
		if(obj instanceof Person) {
			Person a = (Person) obj; // 형변환 가능하면 형변환
			return (age==a.age)&&(name.equals(a.name));
		}
		
		return false;
	}
	
	
	

}
