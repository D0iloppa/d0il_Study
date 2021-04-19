package com.doiloppa.selfchk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    Intent intent;

    EditText edtSong,edtSinger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        intent = getIntent();




        edtSong = findViewById(R.id.edt_Song);
        edtSinger = findViewById(R.id.edt_Singer);

        Button btn_Save = findViewById(R.id.btn_Save);
        btn_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String song = edtSong.getText().toString();
                String singer = edtSinger.getText().toString();
                intent.putExtra("song",song);
                intent.putExtra("singer",singer);
                setResult(MainActivity.REQUEST_ADD,intent);
                finish();

            }
        });



        // 그냥 닫기버튼
        Button btn_Close = findViewById(R.id.btn_Close_inAdd);
        btn_Close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });



    }
}