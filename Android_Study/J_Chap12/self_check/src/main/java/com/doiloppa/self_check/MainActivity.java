package com.doiloppa.self_check;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    School school;
    EditText edt_Name,edt_Age;
    TextView txt_Number_Stu,txt_Student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        school = new School("하버드 초등학교"); // 학교 객체 생성

        edt_Name = findViewById(R.id.editText);
        edt_Age = findViewById(R.id.editText2);

        txt_Number_Stu = findViewById(R.id.textView);
        txt_Student = findViewById(R.id.textView2);


    }

    public void onAdd(View view) { // 추가버튼 눌렀을 때 이벤트
        String name = edt_Name.getText().toString();
        int age = Integer.parseInt(edt_Age.getText().toString());
        Student std = new Student(name,age); //학생 객체 생성
        school.add_Student(std); // 학교에 학생 추가
        
        // 토스트 메시지로 추가됨을 알려준다.
        Toast.makeText(this, "학생 객체가 리스트에 추가됨 : " + name + ", 학생의 나이 : " + age, Toast.LENGTH_SHORT).show();
        txt_Number_Stu.setText("추가된 학생의 총 수 : " + school.get_Size() + "명");
    }

    public void onWatchList(View view) { //학생 리스트 보기 눌렀을 때 이벤트
        String full_Word = "학교 이름 : "; // 최종적으로 띄워줄 문자열, 초기 글자만 지정해줌
        full_Word = full_Word.concat(school.getName() + "\n"); // 학교이름을 가져와서 붙여준다. 마지막에 줄바꿈
        
        // 학생의 정보들을 가져오는 메소드를 만들었다.
        // index로 접근하여 한명씩 정보 가져오고 출력
        // 한 줄에 표시될 스트링의 규격을 다음과 같이 지정한다. (학생 #번호 : 이름, 나이)
        for(int i=0; i<school.get_Size();i++)
            full_Word += ("학생 #" + i + " : " +school.get_studentInfo(i) + "\n");

        txt_Student.setText(full_Word); // 최종 저장된 문자열을 출력해준다.

    }
}