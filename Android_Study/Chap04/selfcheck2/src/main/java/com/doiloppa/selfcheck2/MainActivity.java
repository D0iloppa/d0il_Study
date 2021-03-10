package com.doiloppa.selfcheck2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    EditText edtX,edtY,edtCount;
    Button btnClose;
    FrameLayout layout;
    int count = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtX = findViewById(R.id.edtX);
        edtY = findViewById(R.id.edtY);
        edtCount = findViewById(R.id.edtCount);
        btnClose = findViewById(R.id.btnClose);
        layout = findViewById(R.id.touch_Layout);

        float x,y; // x,y 좌표값

        layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                edtX.setText(String.valueOf(event.getX()));
                edtY.setText(String.valueOf(event.getY()));
                edtCount.setText(String.valueOf(++count));

                return false;
            }
        });

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // 종료
            }
        });


    }
}