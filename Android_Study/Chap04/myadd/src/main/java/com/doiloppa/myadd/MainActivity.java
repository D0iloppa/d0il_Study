package com.doiloppa.myadd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText num1 = findViewById(R.id.edtNum1);
        EditText num2 = findViewById(R.id.edtNum2);

        Button btn = findViewById(R.id.btnAdd);

        TextView txtResult = findViewById(R.id.txtReslut);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                int val1 = Integer.parseInt(num1.getText().toString());
                int val2 = Integer.parseInt(num2.getText().toString());

                int result = val1 + val2;
                */
                
                int rst = (Integer.parseInt(num1.getText().toString())) + (Integer.parseInt(num2.getText().toString()));

                // txtResult.setText(result+""); 이렇게하면 안의 매개변수가 String으로 바뀐다.
                txtResult.setText(String.valueOf(rst));

            }
        });



    }
}