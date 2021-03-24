package com.doiloppa.broadcastreciver_sms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.gesture.GestureOverlayView;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SmsActivity extends AppCompatActivity {

    EditText edt_Sender, edt_Contents, edt_Date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        edt_Sender = findViewById(R.id.editText);
        edt_Contents = findViewById(R.id.editText2);
        edt_Date = findViewById(R.id.editText3);
        Button button = findViewById(R.id.button);

        Intent intent = getIntent();
        processIntent(intent);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        processIntent(intent);
    }

    private void processIntent(Intent intent) {

        if (intent != null) {
            String sender = intent.getStringExtra("sender");
            String content = intent.getStringExtra("contents");
            String receiveDate = intent.getStringExtra("receiveDate");

            edt_Sender.setText(sender);
            edt_Contents.setText(content);
            edt_Date.setText(receiveDate);
        }

    }


}