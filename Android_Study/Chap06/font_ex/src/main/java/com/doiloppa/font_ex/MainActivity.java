package com.doiloppa.font_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txt = findViewById(R.id.font);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"xmas.ttf"); // asset폴더로부터 파일을 불러온다.
        txt.setTypeface(typeface); // 불러온 폰트파일로 txt의 폰트를 지정해준다.


    }
}