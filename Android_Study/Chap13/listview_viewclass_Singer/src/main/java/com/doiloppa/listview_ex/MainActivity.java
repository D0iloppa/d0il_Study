package com.doiloppa.listview_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText editText; // 이름 입력받는 에딧텍스트
    ListView listView;
    SingerAdapter singerAdapter; // 어뎁터

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        singerAdapter = new SingerAdapter();

        // 초기 데이터 입력
        singerAdapter.addItem(new SingerItem("소녀시대","010-1234-5378",30,R.drawable.singer));
        singerAdapter.addItem(new SingerItem("걸스데이","010-4157-1878",28,R.drawable.singer2));
        singerAdapter.addItem(new SingerItem("블랙핑크","010-9817-9878",27,R.drawable.singer3));
        singerAdapter.addItem(new SingerItem("브레이브걸스","010-1321-5727",23,R.drawable.singer4));
        singerAdapter.addItem(new SingerItem("미노이","010-4087-7188",25,R.drawable.singer5));

        listView.setAdapter(singerAdapter);

        editText = findViewById(R.id.editText);
        Random r = new Random();

        Button button = findViewById(R.id.button); // 추가버튼

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int[] resIds = {R.drawable.singer,R.drawable.singer2,R.drawable.singer3,R.drawable.singer4,R.drawable.singer5};
                String name = editText.getText().toString();
                String mobile = "010-"+r.nextInt(9)+r.nextInt(9)+r.nextInt(9)+r.nextInt(9)+
                        "-"+r.nextInt(9)+r.nextInt(9)+r.nextInt(9)+r.nextInt(9);
                int age = r.nextInt(100);


                singerAdapter.addItem(new SingerItem(name,mobile,age,resIds[r.nextInt(5)]));
                singerAdapter.notifyDataSetChanged();
            }
        });





    }
}