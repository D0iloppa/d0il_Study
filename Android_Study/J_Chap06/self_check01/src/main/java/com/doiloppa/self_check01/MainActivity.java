package com.doiloppa.self_check01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageButton imgLeft,imgRight;
    RadioGroup rdg;
    EditText edtName,edtAge;
    Button btnSet,btnClose;

    Singer singer1,singer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        singer1 = new Singer("가수1",0);
        singer2 = new Singer("가수2",0);

        imgLeft = findViewById(R.id.imgLeft); // 왼쪽 가수그림
        imgLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, ("가수의 이름 :" + singer1.name + ", 가수의 나이 : "+singer1.age), Toast.LENGTH_SHORT).show();
            }
        });



        imgRight = findViewById(R.id.imgRight); // 오른쪽 가수그림
        imgRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, ("가수의 이름 :" + singer2.name + ", 가수의 나이 : "+singer2.age), Toast.LENGTH_SHORT).show();
            }
        });

        rdg = findViewById(R.id.rdoGroup);

        edtName = findViewById(R.id.edtName);
        edtAge = findViewById(R.id.edtAge);

        btnSet = findViewById(R.id.btnSet);
        btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(rdg.getCheckedRadioButtonId()){ // 체크된 라디오버튼의 아이디를 가져온다.
                    case R.id.rdoSing1: // 1번 선택
                        singer1.name = edtName.getText().toString();
                        singer1.age = Integer.parseInt(edtAge.getText().toString());
                        Toast.makeText(MainActivity.this, "입력한 값이 첫번째 Singer 객체에 설정되었습니다.", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rdoSing2: // 2번 선택
                        singer2.name = edtName.getText().toString();
                        singer2.age = Integer.parseInt(edtAge.getText().toString());
                        Toast.makeText(MainActivity.this, "입력한 값이 두번째 Singer 객체에 설정되었습니다.", Toast.LENGTH_SHORT).show();
                        break;
                    default: // 라디오 그룹 선택되지 않음
                        Toast.makeText(MainActivity.this, "가수가 선택되지 않았습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });


        btnClose = findViewById(R.id.btnClose); // 닫기버튼 누를 때
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // 프로그램 종료
            }
        });

    }
}