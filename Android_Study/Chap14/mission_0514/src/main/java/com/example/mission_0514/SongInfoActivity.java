package com.example.mission_0514;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class SongInfoActivity extends AppCompatActivity {

    EditText edt_Song;
    EditText edt_Singer;
    ImageView imageView;

    int[] imgs = {R.drawable.song,R.drawable.song2,R.drawable.song3};
    int idx = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_info);

        edt_Song = findViewById(R.id.edtSong);
        edt_Singer = findViewById(R.id.edtSinger);
        imageView = findViewById(R.id.imageView2);


        Button btn_Save = findViewById(R.id.btnSave);
        Button btn_Close = findViewById(R.id.btnClose);

        // 애니메이션을 객체화 해서 뷰에 연결해준다.
        // 뷰의 리스너에 달아주면 이벤트 처리로 애니메이션 시작 가능
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.fade_out);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.startAnimation(animation);
            }
        });


        // 애니메이션의 리스너
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                idx = (idx+1)%3;
                imageView.setImageResource(imgs[idx]);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


        btn_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = edt_Song.getText().toString();
                String singer = edt_Singer.getText().toString();
                Intent intent = getIntent();
                intent.putExtra("title", title);
                intent.putExtra("singer", singer);
                intent.putExtra("imageResource",imgs[idx]);

                setResult(RESULT_OK, intent);
                finish();
            }
        });
        btn_Close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
    }
}
