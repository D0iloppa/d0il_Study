package com.doiloppa.chap07;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //식별을 위해 리퀘스트 코드를 상수형으로 선언해두어도 된다.
    // 숫자로만 적어두면 그 의미를 파악하기 어렵기 때문에 수에 의미를 부여하여 상수화 해준다.
    static final int NEWACTIVITY = 1000, PLAYACTIVITY = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button button = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Intent intent = new Intent(getApplicationContext(),NewActivity.class); // 액티비티 전환을 위환 객체
                intent.putExtra("from_Activity","MainActivity"); // 키-값 을 추가로 보내준다.
                // 앞은 키의 이름, 뒤는 키의 값
                startActivityForResult(intent,NEWACTIVITY); // 리퀘스트코드는 int형으로 넣어준다.*/

/*                Intent intent = new Intent();
                ComponentName name = new ComponentName("com.doiloppa.anotherproject_chap07","com.doiloppa.anotherproject_chap07.MainActivity");
                intent.setComponent(name);
                intent.putExtra("from_Activity","Chap07_MainActivity");
                startActivity(intent);*/

                Intent intent = new Intent();
                ComponentName name = new ComponentName("com.doiloppa.anotherproject_chap07","com.doiloppa.anotherproject_chap07.MainActivity");
                intent.setComponent(name);

                // Serializable로 전송
           /*   Person person1 = new Person("트와이스",20);
                Person person2 = new Person("아이유",23);

                intent.putExtra("Person1",person1); // 객체를 담아준다.
                intent.putExtra("Person2",person2);*/

                //Parcelable로 전송

                Person2 person1 = new Person2("트와이스",20);
                Person2 person2 = new Person2("아이유",23);

                intent.putExtra("Person1",person1); // 객체를 담아준다.
                intent.putExtra("Person2",person2);

                startActivity(intent);



            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),PlayActivity.class); // 액티비티 전환을 위환 객체
                intent.putExtra("from_Activity","MainActivity"); // 키-값 을 추가로 보내준다.
                // 앞은 키의 이름, 뒤는 키의 값
                //   startActivity(intent); // intent에 담겨있는 내용으로 액티비티를 실행한다.
                startActivityForResult(intent,PLAYACTIVITY); // 리퀘스트코드는 int형으로 넣어준다.

            }
        });
        
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==NEWACTIVITY && resultCode == RESULT_OK){ // 요청코드와 결과값이 일치한다면,
            String from_Name = data.getStringExtra("from_Activity");
            int result = data.getIntExtra("sum",0); // sum에 해당하는 값을 받아오되,
                                                        //그 값이 존재하지 않으면 디폴트값을 0으로 한다.
            Toast.makeText(getApplicationContext(), "응답받은 액티비티 이름과 결과값 : " + from_Name + ", " + result, Toast.LENGTH_SHORT).show();
        }

        if(requestCode==PLAYACTIVITY && resultCode == RESULT_OK){ // 요청코드와 결과값이 일치한다면,
            String from_Name = data.getStringExtra("from_Activity");
            String result = data.getStringExtra("myGame"); // sum에 해당하는 값을 받아오되,

            Toast.makeText(getApplicationContext(), "응답받은 액티비티 이름과 결과값 : " + from_Name + ", " + result, Toast.LENGTH_SHORT).show();
        }
    }
}