package set;

import java.util.HashMap;

public class HashSet_Ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * HashSet<Student> set = new HashSet<>(); set.add(new Student(1,"아이유"));
		 * set.add(new Student(2,"아이유"));
		 * 
		 * Iterator<Student> itr = set.iterator();
		 */
		
		/*
		 * 
		 * 
		 * System.out.println("총 Entry의 수 : " + set.size());
		 * 
		 * while(itr.hasNext()) System.out.println(itr.next().toString());
		 */
		
		HashMap<Student,Integer> map = new HashMap<>();
		map.put(new Student(1,"아이유"), 20);
		map.put(new Student(1,"아이유"), 20);
		
		System.out.println("총 Entry의 수 : " + map.size());
		
		
		
		
		
		
		

	}

}
