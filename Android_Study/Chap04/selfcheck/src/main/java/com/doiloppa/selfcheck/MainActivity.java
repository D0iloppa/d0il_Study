package com.doiloppa.selfcheck;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtName,edtAge,edtAddress;
    Button btnSave,btnClose;
    TextView txtName,txtAge,txtAddress;

    String name,address;
    int age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = findViewById(R.id.edtName);
        edtAge = findViewById(R.id.edtAge);
        edtAddress = findViewById(R.id.edtAddress);

        btnSave = findViewById(R.id.btnSave);
        btnClose = findViewById(R.id.btnClose);

        txtName = findViewById(R.id.txtName);
        txtAge = findViewById(R.id.txtAge);
        txtAddress = findViewById(R.id.txtAddress);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = edtName.getText().toString();
                age = Integer.parseInt(edtAge.getText().toString());
                address = edtAddress.getText().toString();

                txtName.setText("입력된 이름 :" + name);
                txtAge.setText("입력된 나이 :" +age);
                txtAddress.setText("입력된 주소 :" + address);

                Toast.makeText(getApplicationContext(),("입력된 값: "+name+", "+age+", "+address),Toast.LENGTH_LONG).show();
            }
        });

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}