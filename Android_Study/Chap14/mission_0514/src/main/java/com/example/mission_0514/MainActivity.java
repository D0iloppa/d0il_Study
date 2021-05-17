package com.example.mission_0514;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public String[] titles = {"라일락","롤린","On the Ground","LOVE DAY","그냥 안아달란 말야"};
    public String[] names = {"아이유","브레이브 걸스","로제","양요섭,정은지","다비치"};
    ListView listView;
    SongAdapter adapter;

    String path;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // 위험권한 주기
        ActivityCompat.requestPermissions(this,new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE
        },0);

        path = Environment.getExternalStorageDirectory().getAbsolutePath();
        
        


        listView = findViewById(R.id.listView);
        Button btnAppend = findViewById(R.id.btnAppend);
        Button btnQuit = findViewById(R.id.btnQuit);

        adapter = new SongAdapter(this);

        for (int i=0; i<titles.length; i++){
            SongItem item = new SongItem(titles[i], names[i],R.drawable.song);
            adapter.addItem(item);
        }

        listView.setAdapter(adapter);

        btnAppend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SongInfoActivity.class);
                startActivityForResult(intent,1000);
            }
        });

        btnQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SongItem item = (SongItem)adapter.getItem(position);
                Toast.makeText(getApplicationContext(),"선택한 아이템 : "+item.getTitle()+", "+item.getSinger(), Toast.LENGTH_SHORT).show();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                adapter.removeItem(position);
                adapter.notifyDataSetChanged();

                return true;
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(data!=null){
            String title = data.getStringExtra("title");
            String singer = data.getStringExtra("singer");
            int imageResource = data.getIntExtra("imageResource",R.drawable.song);

            SongItem item = new SongItem(title, singer,imageResource);
            adapter.addItem(item);
            adapter.notifyDataSetChanged();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    // 파일 입출력

    public void onWrite(View view) {
        String filePath = path + File.separator + "list.txt";

        try{
            FileOutputStream f_Os = new FileOutputStream(filePath);

            ObjectOutputStream o_Os = new ObjectOutputStream(f_Os);

            for(int i=0;i<adapter.items.size();i++){
                SongItem item = adapter.items.get(i);
                o_Os.writeObject(item);
            }


            f_Os.close();
            o_Os.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void onRead(View view) {

        adapter.items.clear();
        adapter.notifyDataSetChanged();

        // 기존 리스트뷰를 지우고 불러온 파일의 데이터로 리스트뷰를 채워준다.

        try {
            String filePath = path + File.separator + "list.txt";

            // 파일을 불러옴
            FileInputStream f_Is = new FileInputStream(filePath);
            ObjectInputStream o_Is = new ObjectInputStream(f_Is);


            SongItem item;

            while((item = (SongItem)o_Is.readObject())!=null) adapter.addItem(item);

            adapter.notifyDataSetChanged();

            f_Is.close();
            o_Is.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
