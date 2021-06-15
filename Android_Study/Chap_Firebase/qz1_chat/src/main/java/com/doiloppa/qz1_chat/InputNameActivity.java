package com.doiloppa.qz1_chat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InputNameActivity extends AppCompatActivity {

    EditText edtName;
    Button btn_Start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_name);

        edtName = findViewById(R.id.edtName);
        btn_Start = findViewById(R.id.btnStart);
    }

    public void chat_start(View view) {
        if(edtName.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(), "이름을 입력하세요", Toast.LENGTH_SHORT).show();
            return;
        }

        String name = edtName.getText().toString();
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        intent.putExtra("name",name);
        startActivity(intent);
        finish();


    }
}