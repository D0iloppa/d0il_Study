package com.doiloppa.selfchk;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    ListView listView;
    MyAdapter mAdapter;
    final static int REQUEST_ADD = 1234;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        listView = findViewById(R.id.list_view);

        mAdapter = new MyAdapter();

        mAdapter.addItem(new SongItem("Lilac","아이유",R.drawable.lilac));
        mAdapter.addItem(new SongItem("Rollin'","브레이브걸스",R.drawable.rollin));


        listView.setAdapter(mAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                
                SongItem data = (SongItem) parent.getItemAtPosition(position);
                String song = data.getSongName();
                String singer = data.getSinger();

                Toast.makeText(getApplicationContext(), "선택된 아이템:"+song+","+singer, Toast.LENGTH_SHORT).show();
                
                
            }
        });

        // 추가 버튼을 누르면 추가할 수 있는 액티비티로 이동해준다.
        Button btn_Add = findViewById(R.id.btn_Add);
        btn_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),AddActivity.class);
                startActivityForResult(intent,REQUEST_ADD);
            }
        });

        // 그냥 닫기 버튼
        Button btn_Close = findViewById(R.id.btn_Close);
        btn_Close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == REQUEST_ADD) {
            String song, singer;
            song = data.getStringExtra("song");
            singer = data.getStringExtra("singer");
            mAdapter.addItem(new SongItem(song,singer,R.drawable.ic_launcher_background));
            mAdapter.notifyDataSetChanged();

        }

    }
}