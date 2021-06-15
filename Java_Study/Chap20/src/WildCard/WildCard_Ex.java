package WildCard;

import java.util.Arrays;

public class WildCard_Ex {

	public static void main(String[] args) {




		Course<Person> personCourse = new Course<Person>("일반인과정",5);
		personCourse.add(new Person("일반인"));
		personCourse.add(new Worker("직장인"));
		personCourse.add(new Student("학생"));
		personCourse.add(new HighStudent("고등학생"));
		
		Course<Worker> personCourse2 = new Course<>("직장인과정",5);
		personCourse2.add(new Worker("직장인"));
		
		
		Course<Student> personCourse3 = new Course<>("학생과정",5);
		personCourse3.add(new Student("학생"));
		personCourse3.add(new HighStudent("고등학생")); // 하위 클래스는 가능, 상위클래스는 불가능
		
		
		Course<HighStudent> personCourse4 = new Course<>("고등학생과정",5);
		personCourse4.add(new HighStudent("고등학생"));
		
		
		registerCourse(personCourse);
		registerCourse(personCourse2);
		registerCourse(personCourse3);
		registerCourse(personCourse4);
		
//		registerCourseStudent(personCourse);
//		registerCourseStudent(personCourse2);
		registerCourseStudent(personCourse3);
		registerCourseStudent(personCourse4);
	}
	
	
	public static void registerCourse(Course<?> course) {
		System.out.println(course.getName() + " 수강생 :" + Arrays.toString(course.getStudent()));
	}
	
	public static void registerCourseStudent(Course<? extends Student> course) {
		System.out.println(course.getName() + " 수강생 :" + Arrays.toString(course.getStudent()));
	}

}
