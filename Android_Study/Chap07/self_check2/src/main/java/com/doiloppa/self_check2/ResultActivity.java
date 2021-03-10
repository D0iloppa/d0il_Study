package com.doiloppa.self_check2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        int[] imageId = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4,
                R.drawable.pic5, R.drawable.pic6, R.drawable.pic7, R.drawable.pic8, R.drawable.pic9};

        int[] tvId = {R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4,
                R.id.tv5, R.id.tv6, R.id.tv7, R.id.tv8, R.id.tv9};

        int[] rbId = {R.id.rBar1, R.id.rBar2, R.id.rBar3, R.id.rBar4, R.id.rBar5,
                R.id.rBar6, R.id.rBar7, R.id.rBar8, R.id.rBar9};


        TextView tvTop = findViewById(R.id.textView);
        ImageView ivTop = findViewById(R.id.imageView);
        Button button = findViewById(R.id.btnFinish);

        TextView[] tv = new TextView[tvId.length];
        RatingBar[] rb = new RatingBar[rbId.length];

        for (int i = 0; i < tvId.length; i++) {
            tv[i] = findViewById(tvId[i]);
            rb[i] = findViewById(rbId[i]);
        }


        Intent intent = getIntent();
        int[] voteResult = intent.getIntArrayExtra("voteCount");
        String[] imgName = intent.getStringArrayExtra("imgName");

        // 최대 투표 받은 그림의 인덱스 번호 구하기
        int max = 0;
        for (int i = 1; i < voteResult.length; i++) if (voteResult[max] < voteResult[i]) max = i;

        tvTop.setText(imgName[max]);
        ivTop.setImageResource(imageId[max]);

        for (int i = 0; i < voteResult.length; i++) {
            tv[i].setText(imgName[i]);
            rb[i].setRating((float) voteResult[i]);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}