package com.example.mission_0514;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
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
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public String[] titles = {"라일락","롤린","On the Ground","LOVE DAY","그냥 안아달란 말야"};
    public String[] names = {"아이유","브레이브 걸스","로제","양요섭,정은지","다비치"};
    ListView listView;
    SongAdapter adapter;

    Handler handler = new Handler();

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
        
        // 파일 쓰기
       /* String filePath = path + File.separator + "list.txt";

        try{
            FileOutputStream f_Os = new FileOutputStream(filePath);

            ObjectOutputStream o_Os = new ObjectOutputStream(f_Os);

            o_Os.writeObject(adapter.items.size()); // 처음, 카운트값을 넣어줌

            for(int i=0;i<adapter.items.size();i++){
                SongItem item = adapter.items.get(i);
                o_Os.writeObject(item);
            }

            Toast.makeText(getApplicationContext(), "파일 쓰기가 완료되었습니다.", Toast.LENGTH_SHORT).show();    
            f_Os.close();
            o_Os.close();

        } catch (Exception e) {
            e.printStackTrace();
        }*/
        
        // 네트워크 소켓 활용 파일 쓰기
        WriteThread thread = new WriteThread();
        thread.start();


    }

    public void onRead(View view) {
        // 파일 읽기
        /*adapter.items.clear();
        adapter.notifyDataSetChanged();

        // 기존 리스트뷰를 지우고 불러온 파일의 데이터로 리스트뷰를 채워준다.

        try {
            String filePath = path + File.separator + "list.txt";

            // 파일을 불러옴
            FileInputStream f_Is = new FileInputStream(filePath);
            ObjectInputStream o_Is = new ObjectInputStream(f_Is);


            SongItem item;

            int count = (Integer) o_Is.readObject(); // 카운트 값을 넣어줬으므로,

            while((item = (SongItem)o_Is.readObject())!=null) adapter.addItem(item);

            adapter.notifyDataSetChanged();
            
            Toast.makeText(getApplicationContext(), "파일 읽기가 완료되었습니다.", Toast.LENGTH_SHORT).show();

            f_Is.close();
            o_Is.close();


        } catch (Exception e) {
            e.printStackTrace();
        }*/

        // 네트워크 소켓 활용 파일 읽기
        ReadThread thread = new ReadThread();
        thread.start();

    }



    class WriteThread extends Thread{

        public void run(){
            try {
                Socket socket = new Socket("119.206.43.85",11000);
                ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                outputStream.writeObject("WRITE");
                ArrayList<SongItem> items = adapter.items;
                int count = items.size();
                outputStream.writeObject(count);
                for(int i=0;i<count;i++){
                    SongItem item = items.get(i);
                    outputStream.writeObject(item);
                }
                outputStream.flush();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), "서버로 list 데이터 쓰기 완료", Toast.LENGTH_SHORT).show();
                    }
                });
                outputStream.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    class ReadThread extends Thread{
        public void run(){
            try {
                Socket socket = new Socket("119.206.43.85",11000);
                ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                outputStream.writeObject("READ");
                outputStream.flush();

                ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

                int count = (int) inputStream.readObject();

                // UI요소는 핸들러를 통해 접근가능
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        adapter.items.clear();
                    }
                });

                for(int i=0;i<count;i++){
                    SongItem item = (SongItem) inputStream.readObject();
                    // 어뎁터는 핸들러를 통해 접근 가능
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            adapter.addItem(item);
                        }
                    });
                }

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyDataSetChanged();
                        Toast.makeText(getApplicationContext(), "서버로부터 list 데이터 읽어옴", Toast.LENGTH_SHORT).show();
                    }
                });

                inputStream.close();
                outputStream.close();
                socket.close();


            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
