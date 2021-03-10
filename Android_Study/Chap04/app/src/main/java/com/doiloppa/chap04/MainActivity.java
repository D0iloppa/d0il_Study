package com.doiloppa.chap04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 메모리상에 activity_main 내용을 가져다 놓는다.
        // 모든 위젯들은(뷰) 뷰 형식으로 가져온다.

        Button button = findViewById(R.id.btn_Close);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"닫기를 클릭하였습니다.",Toast.LENGTH_LONG).show();
            }
        });

        Button btn_Today = (Button) findViewById(R.id.btn_Today);
        btn_Today.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"2021년 1월 14일",Toast.LENGTH_LONG).show();
            }
        });




    }

    public void onSave(View view) {
      Toast.makeText(this,"저장되었습니다.",Toast.LENGTH_LONG).show();

    }
}