package com.doiloppa.service_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Intent intent;

    @Override
    protected void onNewIntent(Intent intent) {
        if(intent != null){
            String name = intent.getStringExtra("name");
            Toast.makeText(getApplicationContext(), name, Toast.LENGTH_SHORT).show();
        }

        super.onNewIntent(intent);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        Button btn_Start = findViewById(R.id.button);
        Button btn_Stop = findViewById(R.id.button2);

        btn_Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText.getText().toString();
                intent = new Intent(getApplicationContext(),MyService.class);
                intent.putExtra("name",name);
                startService(intent);

            }
        });

        btn_Stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(),MyService.class);
                stopService(intent);
            }
        });




    }
}