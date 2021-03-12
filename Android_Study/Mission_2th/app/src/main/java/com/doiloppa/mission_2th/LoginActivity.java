package com.doiloppa.mission_2th;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText edtId, edtPw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btnLogin = findViewById(R.id.btnLogin);

        edtId = findViewById(R.id.edtId); // 아이디 입력창
        edtPw = findViewById(R.id.edtPw); // 암호 입력창창

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtId.getText().toString().isEmpty()||edtPw.getText().toString().isEmpty()) // 아이디,암호 입력 안했을 경우
                    Toast.makeText(getApplicationContext(), "사용자 이름과 비밀번호를 입력하세요", Toast.LENGTH_SHORT).show();
                else{
                    Intent intent = new Intent(getApplicationContext(),MenuActivity.class);
                    intent.putExtra("id",edtId.getText().toString());
                    intent.putExtra("pw",edtPw.getText().toString());
                    startActivity(intent);
                }
            }
        });

    }
}