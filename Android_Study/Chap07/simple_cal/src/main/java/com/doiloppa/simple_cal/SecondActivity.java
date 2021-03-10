package com.doiloppa.simple_cal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button button = findViewById(R.id.button2);


        intent = getIntent(); // 보내오는 intent를 받는다.
        int op = intent.getIntExtra("operation", 0);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int num1 = intent.getIntExtra("num1", 0);
                int num2 = intent.getIntExtra("num2", 0);

                int result = 0;

                switch (op) {
                    case MainActivity.PLUS:
                        result = num1 + num2;
                        break;
                    case MainActivity.MINUS:
                        result = num1 - num2;
                        break;
                    case MainActivity.MUL:
                        result = num1 * num2;
                        break;
                    case MainActivity.DIV:
                        if (num2 != 0) result = num1 / num2;
                        else { // 0으로 나누는 경우
                            setResult(RESULT_CANCELED, intent); // 답장
                            finish();
                        }
                        break;
                }


                intent = new Intent();


                intent.putExtra("result", result);


                setResult(RESULT_OK, intent); // 답장
                finish();
            }
        });

    }
}