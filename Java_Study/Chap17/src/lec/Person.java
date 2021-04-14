package lec;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Person implements Comparable {
	
	private String name;
	private int age;
	static Scanner sc = new Scanner(System.in);

	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public int compareTo(Object o) {
		Person p = (Person)o;
//		if(this.age==p.age)
//			return this.name.length() - p.name.length();
//		return this.name.charAt(0) - p.name.charAt(0);
//		return this.age - p.age;
		
		return this.name.compareTo(p.name);
	}
	
	public String toString() {
		return "이름:" + name + ", 나이:" + age;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r = new Random();
		String[] names = {"Alpah","Bravo","Charlie",
				"Delta","Echo","Foxtrot","Golf","Hotel",
				"India","Juliett","Kilo","Lima","Mike","November",
				"Oscar","Papa","Quebec","Romeo","Sierra","Tango","Uniform",
				"Victory","Whiskey","X-ray","Yankee","Zulu"};
		
		
		
		Person[] ar = new Person[100];
		
		ar[0] = new Person("Doil",12);
		
		for(int i=1;i<ar.length;i++) {
			int name_index = r.nextInt(names.length);
			int r_age = r.nextInt(99)+1;
			ar[i] = new Person(names[name_index],r_age);
		}
			 
		
		
		Arrays.sort(ar);
		int i = 0;
		for(Person p : ar) 
			System.out.printf("[%02d]:" + p+"\n",(i++));
		
		System.out.print("찾을 이름 입력 : ");
		String search = sc.nextLine();
		int idx = Arrays.binarySearch(ar,new Person(search,0));
		System.out.println("해당 이름의 위치 : " + idx);
		

	}

}
