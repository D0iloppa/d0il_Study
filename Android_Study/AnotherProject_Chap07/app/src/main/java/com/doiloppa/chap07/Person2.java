package com.doiloppa.chap07;

import android.os.Parcel;
import android.os.Parcelable;

public class Person2 implements Parcelable {

    // 직렬화를 할 때, 동기화를 확인하기 위한 버전
    private static final long serialVersionUID = 1L;

    String name;
    int age;


    protected Person2(Parcel in) {
        name = in.readString();
        age = in.readInt();
    }

    public Person2() {

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

    // 아래는 Parcelable에서 구현해야 할 약속된 문법
    // Parcelable을 이용하면 Parcel과 다르게 데이터의 순서를 지키지 않아도 된다.

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) { // 송신 직전에 호출
        dest.writeString(name);
        dest.writeInt(age);
    }

    // Parcel 데이터를 쓰여진 순서대로 읽어서 객체화하는 Creator 인터페이스 함수 구현
    public static final Creator<Person2> CREATOR = new Creator<Person2>() {
        @Override
        public Person2 createFromParcel(Parcel source) { // 객체를 전달받은 프로세스에서 수신직후 호출
            Person2 person2 = new Person2();
            person2.setName(source.readString());
            person2.setAge(source.readInt());

            return person2;
        }

        @Override
        public Person2[] newArray(int size) {
            return new Person2[0];
        }
    };


}
