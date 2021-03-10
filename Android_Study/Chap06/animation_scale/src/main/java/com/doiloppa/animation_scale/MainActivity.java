package com.doiloppa.animation_scale;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Animation animation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);

        animation = AnimationUtils.loadAnimation(this,R.anim.in); // 애니메이션을 로드해놓고 인스턴스화
        imageView.startAnimation(animation); // 객체화된 애니메이션을 넘겨준다.

        animation.setAnimationListener(new Animation.AnimationListener() { // 애니메이션 리스너 (애니메이션이 동작될 때, 상황별(시작,종료,반복)로 이벤트지정)
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) { // 애니메이션이 끝났을 때, 다음 애니메이션을 시작해준다.
                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.translate_y); // 애니메이션을 로드해놓고 인스턴스화
                animation.setFillAfter(true); // 애니메이션 실행 후, 애니메이션 종료위치로 강제고정; 그렇지 않으면 원래 자리로 되돌아온다.
                imageView.startAnimation(animation); // 객체화된 애니메이션을 넘겨준다.

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        }); // 애니메이션 끝

        
    } // onCreate메소드 끝
}