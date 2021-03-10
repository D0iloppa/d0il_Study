package com.doiloppa.simple_cal;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static final int PLUS = 1000, MINUS = 2000, MUL = 3000, DIV = 4000;
    int request_Code = 1000; // 기본 연산코드는 더하기

    EditText num1, num2;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.edtNum1);
        num2 = findViewById(R.id.edtNum2);

        radioGroup = findViewById(R.id.radioG);


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rdoPlus:
                        request_Code = PLUS;
                        break;
                    case R.id.rdoMinus:
                        request_Code = MINUS;
                        break;
                    case R.id.rdoMul:
                        request_Code = MUL;
                        break;
                    case R.id.rdoDiv:
                        request_Code = DIV;
                        break;
                }

            }
        });


        Button btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("num1", Integer.parseInt(num1.getText().toString()));
                intent.putExtra("num2", Integer.parseInt(num2.getText().toString()));
                intent.putExtra("operation", request_Code);
                startActivityForResult(intent, request_Code);
            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            int result = data.getIntExtra("result", 0);
            Toast.makeText(getApplicationContext(), "" + result, Toast.LENGTH_SHORT).show();
        }
        if (resultCode == RESULT_CANCELED) // 0으로 나눈 경우
            Toast.makeText(getApplicationContext(), "0으로 나눌 수 없습니다.", Toast.LENGTH_SHORT).show();


    }


}