package com.doiloppa.chap07;

import java.io.Serializable;

public class Person implements Serializable { //마커 인터페이스

    // 직렬화를 할 때, 동기화를 확인하기 위한 버전
    private static final long serialVersionUID = 1L;

    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
