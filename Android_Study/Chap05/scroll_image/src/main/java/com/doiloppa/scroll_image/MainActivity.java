package com.doiloppa.scroll_image;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView img1,img2;
    Button btnUp,btnDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img1 = findViewById(R.id.imageView);
        img2 = findViewById(R.id.imageView2);

        btnUp = findViewById(R.id.button1);
        btnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img1.setImageResource(R.drawable.bg_tv);
                img2.setImageResource(0);
                img1.invalidate(); // 화면에 img1을 재출력하라.
                img2.invalidate();
            }
        });

        btnDown = findViewById(R.id.button2);
        btnDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img1.setImageResource(0);
                img2.setImageResource(R.drawable.bg_tv);
                img1.invalidate();
                img2.invalidate();
            }
        });



    }
}