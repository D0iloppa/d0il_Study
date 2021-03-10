package com.doiloppa.grid_calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtNum1,edtNum2;
    TextView txtResult;

    Button[] numBtns = new Button[10]; // 숫자버튼 10개 배열로
    int[] numBtn_id = {R.id.btnNum0 , R.id.btnNum1 , R.id.btnNum2, R.id.btnNum3 ,
            R.id.btnNum4 , R.id.btnNum5 , R.id.btnNum6 , R.id.btnNum7 , R.id.btnNum8 , R.id.btnNum9 }; // 버튼의 주소값

    Button btnAdd,btnSub,btnMult,btnDiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNum1 = findViewById(R.id.edtNum1);
        edtNum2 = findViewById(R.id.edtNum2);
        txtResult = findViewById(R.id.txtResult);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMult = findViewById(R.id.btnMult);
        btnDiv = findViewById(R.id.btnDiv);


        for(int i=0;i<numBtns.length;i++){
            numBtns[i] = findViewById(numBtn_id[i]); // 숫자 버튼들 할당
        }



        for(int i=0;i<numBtns.length;i++){
            final int index = i;

            numBtns[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(edtNum1.isFocused()){
                        edtNum1.setText(edtNum1.getText().toString() + numBtns[index].getText().toString());
                    }
                    else if(edtNum2.isFocused()){
                        edtNum2.setText(edtNum2.getText().toString() + numBtns[index].getText().toString());
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "에디트 텍스트를 먼저 선택해주세요", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText("계산결과 : " + (Integer.parseInt(edtNum1.getText().toString()) + Integer.parseInt(edtNum2.getText().toString())));
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText("계산결과 : " + (Integer.parseInt(edtNum1.getText().toString()) - Integer.parseInt(edtNum2.getText().toString())));
            }
        });

        btnMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText("계산결과 : " + (Integer.parseInt(edtNum1.getText().toString()) * Integer.parseInt(edtNum2.getText().toString())));
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText("계산결과 : " + (Integer.parseInt(edtNum1.getText().toString()) / Integer.parseInt(edtNum2.getText().toString())));
            }
        });




    }
}