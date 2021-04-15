package SelfCheck;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class SelfCheck_02 {

	public static void main(String[] args) {
		
		String bar = "학번\t\t|이름\t\t|전화번호\t\t|이메일\n----------------------------------------------------------";
		
		Random random = new Random();
		Scanner sc = new Scanner(System.in);
		
		
		HashMap<Integer,Student> hMap = new HashMap<>(); // 학번-학생 연결
		
		String[] names = {"아이유","블랙핑크","소녀시대","미노이","브레이브걸스","권도일","방탄소년단"};
		String[] enames = {"iu","black_Pink","GirlsGen","Meenoi","brave_Girls","kdi3939","BTS"};
		String[] emails = {"@naver.com","@hanmail.net","@gmail.com"};
		
		
		
		
		for(int i=0;i<1000;i++) {
			hMap.put(i+1000,new Student(i+1000,names[i%7],
					"010-"+random.nextInt(9)+random.nextInt(9)+random.nextInt(9)+random.nextInt(9)+"-"+random.nextInt(9)+random.nextInt(9)+random.nextInt(9)+random.nextInt(9),
					enames[i%7]+emails[i%3]));
		}
		

		
		System.out.print("찾을 학번 : ");
		int search = sc.nextInt();
		Student target = hMap.get(search);
		System.out.println(bar);
		

		Set<Integer> sNums = hMap.keySet();
		Iterator<Integer> itr = sNums.iterator();
		
		
		while(itr.hasNext()) {
			int sNum = itr.next();
			Student student = hMap.get(sNum);
			System.out.println(student);
		}
		
		System.out.println();
		
		System.out.println("\n");
		
		if(target==null)
			System.out.println("해당 학번의 학생이 존재하지 않습니다.");
		else 
			System.out.println(target);




		for(int i=0;i<1000;i++){
			String str = "";
			System.out.println(str.concat( ( i < 10 ? "00"+i : (i<100 ? "0"+i:""+i) ) ));
		}
		
	
			

	}





}
