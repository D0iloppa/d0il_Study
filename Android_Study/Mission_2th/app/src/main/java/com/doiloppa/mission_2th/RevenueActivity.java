package com.doiloppa.mission_2th;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RevenueActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revenue);

        Intent intent = getIntent();

        Button btnMenu = findViewById(R.id.btnRevenue_menu);
        Button btnLogin = findViewById(R.id.btnRevenue_login);

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("msg","Revenue result message is OK!");
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED,intent); // 로그인으로 가야함
                finish();
            }
        });


    }
}