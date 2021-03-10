package com.doiloppa.selfcheck3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;

// Github 연동
public class MainActivity extends AppCompatActivity {


    LinearLayout lay;
    Switch switch_Start;
    RadioGroup rdG;
    RadioButton rdo_Oreo,rdo_Pie,rdo_Q;
    ImageView img;
    Button btn1,btn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        lay = findViewById(R.id.lay);
        switch_Start = findViewById(R.id.switch_Start);

        rdG = findViewById(R.id.radioGr);
        rdo_Oreo = findViewById(R.id.rdo_Oreo);
        rdo_Pie = findViewById(R.id.rdo_Pie);
        rdo_Q = findViewById(R.id.rdo_Q);


        img = findViewById(R.id.imageView);
        btn1 = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);


        switch_Start.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true) lay.setVisibility(View.VISIBLE);
                else lay.setVisibility(View.GONE);
            }
        });

        rdG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                img.setVisibility(View.VISIBLE);
                switch(checkedId){
                    case R.id.rdo_Oreo:
                        img.setImageResource(R.drawable.oreo);
                        break;
                    case R.id.rdo_Pie:
                        img.setImageResource(R.drawable.pie);
                        break;
                    case R.id.rdo_Q:
                        img.setImageResource(R.drawable.q10);
                        break;

                    default:

                }
            }
        });


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();;
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rdG.clearCheck(); // 라디오그룹 초기화
                img.setImageResource(0); // 이미지뷰 초기화
                switch_Start.setChecked(false);
            }
        });


    }
}