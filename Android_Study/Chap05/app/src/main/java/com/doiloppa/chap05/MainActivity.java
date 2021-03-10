package com.doiloppa.chap05;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
/*
xml없이 자바코드로 레이아웃 구성하는 법
 */

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);

        LinearLayout.LayoutParams  params= new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);

        LinearLayout baseLayout = new LinearLayout(this);

        baseLayout.setOrientation(LinearLayout.VERTICAL);
        setContentView(baseLayout , params); // baseLayout 전개


        EditText edt1 = new EditText(this);
        edt1.setText("HELLO World");
        baseLayout.addView(edt1); // 레이아웃에 에딧텍스트 추가

        Button btn1 = new Button(this);
        btn1.setText("This is Button");
        btn1.setBackgroundColor(Color.YELLOW);
        baseLayout.addView(btn1); // 레이아웃에 버튼 추가

        TextView txt = new TextView(this);
        txt.setTextColor(Color.rgb(255,174,201));
        baseLayout.addView(txt); //레이아웃에 뷰 추가

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.setText(edt1.getText().toString());
            }
        });

    }
}