package com.doiloppa.mission;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    EditText editText;
    Intent intent;
    MyReceiver receiver;



    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        Log.i("test","onCreate");
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.edt);
        textView = findViewById(R.id.text);

        if( (intent = getIntent()) != null ){
            String txt = intent.getStringExtra("txt_From_Receiver");
//                Log.i("test","리시버가 보낸 메시지를 액티비티가 받음");
                textView.setText("입력한 글자 : " + txt);
        }

        receiverTest = new ReceiverTest(); // 브로드캐스트 리시버 인스턴스화
        IntentFilter filter = new IntentFilter(); // 필터 생성
        filter.addAction(MyReceiver.MY_ACTION);
        registerReceiver(receiverTest,filter); // 리시버 등록


        Button btn = findViewById(R.id.btn);


        // 서비스에 메시지를 보냄
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sendTxt = editText.getText().toString();
                intent = new Intent(getApplicationContext(),TextService.class);
                intent.putExtra("sendTxt",sendTxt);
                startService(intent);
            }
        });


    }

    class MyReceiver extends BroadcastReceiver{

        

        @Override
        public void onReceive(Context context, Intent intent) {
            String txt = intent.getStringExtra("txt_From_Service");
            textView.setText(txt);

        }
    }
}