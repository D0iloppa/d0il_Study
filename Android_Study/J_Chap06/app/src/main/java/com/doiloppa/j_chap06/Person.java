package com.doiloppa.j_chap06;

import android.widget.Toast;

public class Person {

    String name;
    boolean created = false;
    MainActivity activity;

    public Person(String name, MainActivity activity) {
        this.name = name;
        this.activity = activity;
        created = true;
        Toast.makeText(activity.getApplicationContext(),name + "이(가) 생성되었습니다.",Toast.LENGTH_LONG).show();
    }
}
