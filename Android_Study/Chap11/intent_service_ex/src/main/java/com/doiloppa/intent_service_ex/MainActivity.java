package com.doiloppa.intent_service_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        Button button = findViewById(R.id.button);

        // 인텐트서비스는 일회성으로 활용할 때 좋다. 자동으로 서비스를 종료해주기 때문에
        // 서비스를 종료하지 않더라도 메모리에 계속 남아있는 문제를 해결할 수 있다.

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!editText.toString().isEmpty()){
                    Long sleepSeconds = Long.parseLong(editText.getText().toString());
                    Intent intent = new Intent(MainActivity.this,MyIntentService.class);
                    intent.putExtra("seconds",sleepSeconds);
                    startService(intent);
                } else{
                    Toast.makeText(getApplicationContext(), "시간을 입력해주세요", Toast.LENGTH_SHORT).show();
                }
            }
        });




    }
}