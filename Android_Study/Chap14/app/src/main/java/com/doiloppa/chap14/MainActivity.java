package com.doiloppa.chap14;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    EditText filename,contents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        filename = findViewById(R.id.editTextTextPersonName);
        contents = findViewById(R.id.editTextTextPersonName2);

        Button btn_Write = findViewById(R.id.button);
        btn_Write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = filename.getText().toString();
                String content = contents.getText().toString();

                try {
                    writeToFile(name,content);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Button btn_Read = findViewById(R.id.button2);
        btn_Read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = filename.getText().toString();
                String content = null;
                try {
                    content = readFromFile(name);
                    contents.setText(content);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });



    }

    private String readFromFile(String name) throws Exception{
        FileInputStream fis = openFileInput(name);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
        StringBuffer stringBuffer = new StringBuffer();
        String content = null;
        while((content = reader.readLine())!=null)
            stringBuffer.append(content+"\n");

        reader.close();
        fis.close();

        return stringBuffer.toString();
    }


    public void writeToFile(String name,String content) throws Exception {

        FileOutputStream fos = openFileOutput(name,MODE_PRIVATE);
        OutputStreamWriter writer =new OutputStreamWriter(fos);
        writer.write(content);

        writer.flush();
        writer.close();
        fos.close();



    }


}