package com.doiloppa.chap07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PlayActivity extends AppCompatActivity {

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        Button button = findViewById(R.id.button);


        intent = getIntent(); // 보내오는 intent를 받는다.
        String name = intent.getStringExtra("from_Activity"); // 키의 이름을 입력하여 그 키의 값을 가져온다.

        Toast.makeText(getApplicationContext(), "보낸 액티비티명 : " + name, Toast.LENGTH_SHORT).show();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(); // 보내기 위한 Intent는 인스턴스화 해주어야한다.

                String myGame = "디아블로";

                intent.putExtra("from_Activity","PlayActivity");
                intent.putExtra("myGame",myGame);

                setResult(RESULT_OK, intent); // 답장
                finish();




            }
        });
    }
}