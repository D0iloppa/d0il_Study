package com.doiloppa.seekbar_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar;
    LinearLayout linearLayout;
    TextView textView;
    int brightness = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = findViewById(R.id.seekbar01);
        linearLayout = findViewById(R.id.layout1);
        textView = findViewById(R.id.txtBright);

        Button btn = findViewById(R.id.btn_Bright);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.translate_left); // 애니메이션 리소스를 가져온다.
                seekBar.setProgress(brightness); // 시크바의 진행을 밝기로 설정
                linearLayout.setVisibility(View.VISIBLE);
                linearLayout.startAnimation(animation);
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(progress<10) progress=10;
                else if(progress>100) progress=100;
                WindowManager.LayoutParams params = getWindow().getAttributes(); //화면정보의 속성들을 가져와서 윈도우 매니저에게 넘겨준다.
                params.screenBrightness = (float) progress/100; //화면밝기의 값을 시크바의 값으로 지정해준다.
                getWindow().setAttributes(params); // 설정된 params로 설정해준다 => 밝기를 바꿔준다.
                textView.setText("밝기 수준 : " + progress);
                brightness = progress; // 밝기수준을 넘겨준다.
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.translate_right);
                linearLayout.setVisibility(View.GONE);
                linearLayout.startAnimation(animation);

            }
        });


    }
}