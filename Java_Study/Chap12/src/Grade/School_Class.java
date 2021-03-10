package Grade;

import java.util.Scanner;

public class School_Class {
	
	public Student[] student; // 학생들 배열
	
	private int stu_Num, max_Score;
	private double avg_Score;

	public boolean flag = true;
	Scanner sc;
	
	public School_Class() {
		sc = new Scanner(System.in);
	}
	
	
	

	
	
	public Student[] getStudent() {
		return student;
	}






	public void setStudent(Student[] student) {
		this.student = student;
	}






	public void show_Menu() {
		System.out.println("----------------------------------------------");
		System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
		System.out.println("----------------------------------------------");
		this.menu_Input();
	}
	
	public void menu_Input() {
		System.out.print("선택> ");
		int menu;
		switch(menu = sc.nextInt()) {
			case 1 : stu_Num(); break;
			case 2 : score_Input(); break;
			case 3 : score_List(); break;
			case 4 : analytic(); break;
			case 5 : exit_Program(); break;
		}
		
	}
	
	private void exit_Program() { // 프로그램 종료
		// TODO Auto-generated method stub
		this.flag = false;		
		
	}
	
	private void analytic() {
		// TODO Auto-generated method stub
		int sum = 0; // 처음 합계는 0
		int max = student[0].getScore(); // 1번 학생이 일단 최고점수라고 가정
		
		for(int i=0;i<student.length;i++) {
			if(max<=student[i].getScore()) max=student[i].getScore(); // 동점도 최고점수로 친다.
			sum+=student[i].getScore(); // 총점을 구한다.
		}
		this.max_Score = max;
		this.avg_Score = (double)sum/student.length; // 학생수를 담아두는 변수가 있으니 그냥 학생 수로 나눠도 됨
		
		System.out.println("최고 점수: " + max_Score);
		System.out.printf("평균 점수: %.2f\n",avg_Score);
		
	}


	private void score_List() { // 점수리스트
		// TODO Auto-generated method stub
		
		for(int i=0;i<student.length;i++) {
			System.out.print("학생["+i+"]> ");
			System.out.println(student[i].getScore()); //i번째 학생의 점수
		}
	
		
		
	}

	private void score_Input() {
		// TODO Auto-generated method stub
		for(int i=0;i<student.length;i++) { // 학생 수 만큼 점수를 입력 받음
			System.out.print("학생["+i+"]> ");
			int score = sc.nextInt();
			Student stu = new Student(score);
			this.student[i]=stu; // i번째 학생의 점수를 입력
		}		
		
	}


	private void stu_Num() { // 학생 수 입력
		// TODO Auto-generated method stub
		System.out.print("학생수> ");
		this.stu_Num = sc.nextInt(); // 학생 수 입력
		this.student = new Student[stu_Num]; // 학생 객체 생성
		
		
	}


	public static void main(String[] args) {
		
		School_Class our_Class = new School_Class(); // 우리 학급 클래스 생성
		
		while(our_Class.flag) {
			our_Class.show_Menu();
		}
		
	}

}
