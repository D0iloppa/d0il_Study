package com.doiloppa.sdcard_ex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MainActivity extends AppCompatActivity {

    String path;
    EditText edtContents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 위험권한 주기
        ActivityCompat.requestPermissions(this,new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE
        },0);

        Button btnRead,btnMkDir,btnRmDir;
        btnRead = findViewById(R.id.btnRead);
        btnMkDir = findViewById(R.id.btnMkdir);
        btnRmDir = findViewById(R.id.btnRmdir);
        edtContents = findViewById(R.id.edtSD);
        path = Environment.getExternalStorageDirectory().getAbsolutePath();

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String filePath = path + File.separator + "sdcard_test.txt";
                    
                    // 파일을 불러옴
                    FileInputStream inputStream = new FileInputStream(filePath);
                    byte[] contents = new byte[inputStream.available()];
                    inputStream.read(contents);
                    edtContents.setText(new String(contents));
                    inputStream.close(); // 스트림을 닫아준다.
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        btnMkDir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File mydir = new File(path+File.separator+"myDir");
                mydir.mkdir();
            }
        });

        btnRmDir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File mydir = new File(path+File.separator+"myDir");
                mydir.delete();
            }
        });


    }
}