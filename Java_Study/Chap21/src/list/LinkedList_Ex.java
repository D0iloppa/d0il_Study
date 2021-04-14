package list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedList_Ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new LinkedList<String>();
		
		long startTime,endTime; // 탐색시간을 측정하기 위함
		
		startTime = System.nanoTime();
		for(int i=0; i<10000; i++) list1.add(0,String.valueOf(i));
		endTime = System.nanoTime();
		System.out.println("ArrayList 걸린 시간 : " + (endTime - startTime) + " ns");
		
		startTime = System.nanoTime();
		for(int i=0; i<10000; i++) list2.add(0,String.valueOf(i));
		endTime = System.nanoTime();
		System.out.println("LinkedList 걸린 시간 : " + (endTime - startTime) + " ns");
	}

}
