package com.doiloppa.simplecalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        EditText edtNum1,edtNum2;
        Button btnPls,btnMins,btnMul,btnDiv,btnExtra;
        TextView txtResult;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNum1 = findViewById(R.id.edtNum1);
        edtNum2 = findViewById(R.id.edtNum2);
        txtResult = findViewById(R.id.txtResult);

        btnPls = findViewById(R.id.btn_Plus);
        btnPls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( !(edtNum1.getText().toString().isEmpty()||edtNum2.getText().toString().isEmpty()) ){
                    Double a = Double.parseDouble(edtNum1.getText().toString());
                    Double b = Double.parseDouble(edtNum2.getText().toString());
                    txtResult.setText("계산 결과:"+(a+b));
                }
                else Toast.makeText(getApplicationContext(),"잘못된 값 입력",Toast.LENGTH_LONG).show();

            }
        });

        btnMins = findViewById(R.id.btn_Minus);
        btnMins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( !(edtNum1.getText().toString().isEmpty()||edtNum2.getText().toString().isEmpty()) ){
                    Double a = Double.parseDouble(edtNum1.getText().toString());
                    Double b = Double.parseDouble(edtNum2.getText().toString());
                    txtResult.setText("계산 결과:"+(a-b));
                }
                else Toast.makeText(getApplicationContext(),"잘못된 값 입력",Toast.LENGTH_LONG).show();


            }
        });

        btnMul = findViewById(R.id.btn_Multi);
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( !(edtNum1.getText().toString().isEmpty()||edtNum2.getText().toString().isEmpty()) ){
                    Double a = Double.parseDouble(edtNum1.getText().toString());
                    Double b = Double.parseDouble(edtNum2.getText().toString());
                    txtResult.setText("계산 결과:"+(a*b));
                }
                else Toast.makeText(getApplicationContext(),"잘못된 값 입력",Toast.LENGTH_LONG).show();

            }
        });

        btnDiv = findViewById(R.id.btn_Div);
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(edtNum1.getText().toString().isEmpty()||edtNum2.getText().toString().isEmpty())){
                    Double a = Double.parseDouble(edtNum1.getText().toString());
                    Double b = Double.parseDouble(edtNum2.getText().toString());
                    if(b==0) Toast.makeText(getApplicationContext(),"0으로 나눌 수는 없습니다.",Toast.LENGTH_LONG).show();
                    else txtResult.setText("계산 결과:"+String.format("%.3f",a/b));

                }
                else Toast.makeText(getApplicationContext(),"잘못된 값 입력",Toast.LENGTH_LONG).show();
            }
        });

        btnExtra = findViewById(R.id.btn_Extra);
        btnExtra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( !(edtNum1.getText().toString().isEmpty()||edtNum2.getText().toString().isEmpty()) ){
                    Double a = Double.parseDouble(edtNum1.getText().toString());
                    Double b = Double.parseDouble(edtNum2.getText().toString());
                    if(b==0) Toast.makeText(getApplicationContext(),"0으로 나눌 수는 없습니다.",Toast.LENGTH_LONG).show();
                    else txtResult.setText("계산 결과:"+(a%b));
                }

            }
        });


    }
}