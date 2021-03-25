package com.doiloppa.systembroadcastreciever_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DialogActivity extends AppCompatActivity {

    ImageView imgBtn_X; // X모양 이미지 버튼
    TextView textView; // 전화번호 출력하는 텍스트뷰

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        textView = findViewById(R.id.lab1_phone_number);
        imgBtn_X = findViewById(R.id.lab1_remove_icon);

        // X모양 이미지를 누르면 해당 액티비티를 종료시킴
        imgBtn_X.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // 인텐트로부터 전화번호를 가져오고 setText해준다.
        Intent intent = getIntent();
        String number = intent.getStringExtra("number");
        textView.setText(number);

    }
}