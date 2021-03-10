package com.doiloppa.pagesliding_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    boolean isOpen = false;
    LinearLayout layout;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.layout);
        btn = findViewById(R.id.btn);

        Animation translate_Left = AnimationUtils.loadAnimation(this,R.anim.translate_left);
        Animation translate_Right = AnimationUtils.loadAnimation(this,R.anim.translate_right);

        PageListener pageListener = new PageListener();
        translate_Left.setAnimationListener(pageListener);
        translate_Right.setAnimationListener(pageListener);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isOpen){
                    layout.startAnimation(translate_Right);
                }else{
                    layout.startAnimation(translate_Left);
                    layout.setVisibility(View.VISIBLE);
                }

            }
        });


    }

    class PageListener implements Animation.AnimationListener{
        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            if(isOpen){
                layout.setVisibility(View.INVISIBLE);
                btn.setText("OPEN");
                isOpen = false;
            }else{
                btn.setText("CLOSE");
                isOpen = true;
            }

        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }




}