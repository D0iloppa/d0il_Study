package SelfCheck;

import java.util.HashSet;
import java.util.Iterator;

public class SelfCheck_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashSet<Person> hSet = new HashSet<>();
		
		

		hSet.add(new Person("권도일",10));
		hSet.add(new Person("권도일",10));
		hSet.add(new Person("권도이",12));
		
		Iterator<Person> itr = hSet.iterator();

		
		
		while(itr.hasNext()) {
			Person man = itr.next();
			System.out.println(man);
		}

	}

}
