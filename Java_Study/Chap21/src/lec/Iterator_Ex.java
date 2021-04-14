package lec;

import java.util.Iterator;
import java.util.LinkedList;

public class Iterator_Ex {
	
	public static void main(String[] args) {
		
		LinkedList<String> list = new LinkedList<String>();
		
		list.add("First");
		list.add("Second");
		list.add("Third");
		list.add("Fourth");
		
		Iterator<String> itr= list.iterator();
		
		System.out.println();
		
		while(itr.hasNext()) {
			String curStr = itr.next();
			System.out.println(curStr);
			if(curStr.compareTo("Third")==0)
				itr.remove(); // Third 발견시 삭제
		}
		
		System.out.println();
		itr = list.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());
		
		
		System.out.println();
		
		
		// Iterator에서 삭제를 하면 list에서도 삭제됨
		for(int i=0;i<list.size();i++) 
			System.out.println(list.get(i));			
		
		
		
	}
	
	
	
	
	

}
