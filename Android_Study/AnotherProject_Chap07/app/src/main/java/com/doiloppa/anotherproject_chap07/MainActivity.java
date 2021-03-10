package com.doiloppa.anotherproject_chap07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.doiloppa.chap07.Person;
import com.doiloppa.chap07.Person2;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

/*        Intent intent = getIntent();
        String name = intent.getStringExtra("from_Activity");
        textView.setText("전달받은 액티비티 이름 : " + name);*/

        Intent intent = getIntent(); // intent를 받아온다.
        /*Person p1 = (Person) intent.getSerializableExtra("Person1");
        Person p2 = (Person) intent.getSerializableExtra("Person2");*/

        Person2 p1 = (Person2) intent.getParcelableExtra("Person1");
        Person2 p2 = (Person2) intent.getParcelableExtra("Person2");

        if (p1 == null && p2 == null) {
            Toast.makeText(this, "Person 객체를 전달받지 못했습니다.", Toast.LENGTH_SHORT).show();
            return;
        }

        textView.setText("이름 : " + p1.getName() + ", 나이 : " + p1.getAge());
        textView.append("\n 이름 : " + p2.getName() + ", 나이 : " + p2.getAge());


    }
}