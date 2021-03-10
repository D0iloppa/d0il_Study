package com.doiloppa.self_check;

import java.util.ArrayList;

public class School {
    private String name; // 학교이름
    private ArrayList <Student> students = new ArrayList<Student>(); // 학생들의 인스턴스를 담아두는 배열리스트

    public School(String name) {
        this.name = name;
    }

    public int get_Size(){ // 학생 수 출력해주는 메소드
        return this.students.size();
    }

    public void add_Student(Student student){
        students.add(student);
    }

    public String get_studentInfo(int i){
        String name = students.get(i).getName();
        int age = students.get(i).getAge();

        return (name + ", " + age);
    }

    public String getName() {
        return this.name;
    }
}
