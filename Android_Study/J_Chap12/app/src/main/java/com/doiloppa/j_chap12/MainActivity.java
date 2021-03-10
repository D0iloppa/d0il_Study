package com.doiloppa.j_chap12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String[] names = {"철수","영희","민희","수지","도일"}; // 기본 제공 이름
    int count = 0;
    ArrayList<Person> persons = new ArrayList<Person>(); // 배열리스트
    TextView txt_Count;
    LinearLayout layout;
    EditText edt_Name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_Count = findViewById(R.id.txt_Count);
        layout = findViewById(R.id.layout);
        edt_Name = findViewById(R.id.edt_Name);

        Button btn_Create = findViewById(R.id.btn_make_Person);
        Button btn_Add = findViewById(R.id.btn_add_Person);

        // 사람만들기 버튼
        // 기본 저장된 사람 배열에서 순차적으로 한명씩 찾아와서 이름을 정해준다.
        // 배열리스트에 추가한다.
        btn_Create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index = count % names.length; // 인덱스는 기본제공 사람의 수 범위 내에서 계속 순차적으로 증가한다.
                Person person = new Person(names[index]); // 사람 객체 하나를 생성해서 배열리스트에 추가할 것
                persons.add(person); // 배열리스트에 객체 추가
                // 토스트 메세지로 객체가 생성되었음을 알려준다.
                Toast.makeText(MainActivity.this, names[index]+"이(가) 만들어졌습니다.", Toast.LENGTH_SHORT).show();
                String curName = person.getName(); // 방금 생성된 사람의 이름을 스트링으로 저장

                // 하단 스크롤 뷰(리니어 레이아웃)에 사람 이름을 나타내는 텍스트뷰 추가
                TextView textView = new TextView(getApplicationContext()); // 텍스트 뷰 객체생성
                textView.setText(curName); // 아까 받아온 스트링으로 텍스트뷰 글씨 지정
                textView.setTextSize(30); // 글씨 크기는 30dp
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams( // 가로,세로 속성값을 지정해주는 변수
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );
                layout.addView(textView,params); // 텍스트뷰 객체와, 그 객체의 속성을 레이아웃에 추가해준다.
                count++; // 사람의 수를 세기 위해서 증가시켜준다.
                txt_Count.setText(persons.size()+" 명"); // 사람의 수를 표시하는 텍스트뷰
                // 총 생성된 사람의 수가 변동되었으므로 배열리스트의 크기로 사람의 수 지정

            }
        });
        
        // 사람 추가하기 버튼
        // 에딧텍스트에 입력된 이름으로 사람을 추가
        btn_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String curName = edt_Name.getText().toString(); // 입력된 이름을 스트링으로 가져온다.
                Person person = new Person(curName);

                persons.add(person); // 배열리스트에 객체 추가
                // 토스트 메세지로 객체가 생성되었음을 알려준다.
                Toast.makeText(MainActivity.this, persons.get(persons.size()-1)+"이(가) 만들어졌습니다.", Toast.LENGTH_SHORT).show();

                // 하단 스크롤 뷰(리니어 레이아웃)에 사람 이름을 나타내는 텍스트뷰 추가
                TextView textView = new TextView(getApplicationContext()); // 텍스트 뷰 객체생성
                textView.setText(curName); // 아까 받아온 스트링으로 텍스트뷰 글씨 지정
                textView.setTextSize(30); // 글씨 크기는 30dp
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams( // 가로,세로 속성값을 지정해주는 변수
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );
                layout.addView(textView,params); // 텍스트뷰 객체와, 그 객체의 속성을 레이아웃에 추가해준다.
                txt_Count.setText(persons.size()+" 명"); // 사람의 수를 표시하는 텍스트뷰
                // 총 생성된 사람의 수가 변동되었으므로 배열리스트의 크기로 사람의 수 지정
            }
        });




    }
}