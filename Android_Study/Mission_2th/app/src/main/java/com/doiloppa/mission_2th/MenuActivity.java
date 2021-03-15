package com.doiloppa.mission_2th;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    static final int CUSTOMER = 1000, REVENUE = 2000, PRODUCT = 3000;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        intent = getIntent();

        String id = intent.getStringExtra("id");
        Toast.makeText(getApplicationContext(), "사용자 이름 : " + id + "님이 로그인하셨습니다.", Toast.LENGTH_SHORT).show();
        Log.i("id",id);


        Button btnCustomer = findViewById(R.id.btnCustomer);
        Button btnRevenue = findViewById(R.id.btnRevenue);
        Button btnProduct = findViewById(R.id.btnProduct);

        btnCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(),CustomerActivity.class);

                startActivityForResult(intent,CUSTOMER);
            }
        });

        btnRevenue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(),RevenueActivity.class);
                startActivityForResult(intent,REVENUE);
            }
        });

        btnProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(),ProductActivity.class);
                startActivityForResult(intent,PRODUCT);
            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String msg; // 받아올 메시지

        if (resultCode == RESULT_OK){ // 메뉴로 돌아옴
            switch(requestCode){
                case CUSTOMER:
                    msg = data.getStringExtra("msg");
                    Toast.makeText(getApplicationContext(), "고객관리 응답 : "+msg, Toast.LENGTH_SHORT).show();
                    break;
                case REVENUE:
                    msg = data.getStringExtra("msg");
                    Toast.makeText(getApplicationContext(), "매출관리 응답 : "+msg, Toast.LENGTH_SHORT).show();
                    break;
                case PRODUCT:
                    msg = data.getStringExtra("msg");
                    Toast.makeText(getApplicationContext(), "상품관리 응답 : "+msg, Toast.LENGTH_SHORT).show();
                    break;
            }
        } else{ // 하위 메뉴에서 로그인으로 버튼을 눌렀을 경우 바로 로그인 메뉴로 가기위함
            finish(); // 로그인 메뉴로 돌아감
        }
    }




}