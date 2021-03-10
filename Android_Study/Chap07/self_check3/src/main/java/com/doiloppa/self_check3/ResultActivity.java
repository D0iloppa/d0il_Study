package com.doiloppa.self_check3;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.Arrays;
import java.util.Comparator;

public class ResultActivity extends AppCompatActivity {
    ViewFlipper vf;
    Intent intent;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        intent = getIntent();
        vf = findViewById(R.id.vf);

        int[] imageId = {R.id.img1, R.id.img2, R.id.img3, R.id.img4,
                R.id.img5, R.id.img6, R.id.img7, R.id.img8, R.id.img9}; // 이미지뷰 아이디
        int[] drawId = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4,
                R.drawable.pic5, R.drawable.pic6, R.drawable.pic7, R.drawable.pic8, R.drawable.pic9};
        // 사진 아이디

        ImageView[] imageViews = new ImageView[9];

        for (int i = 0; i < imageViews.length; i++)
            imageViews[i] = findViewById(imageId[i]); // 이미지 뷰 객체지정


        int[] voteResult = intent.getIntArrayExtra("voteCount");
        int[][] rankImage = new int[2][9];


        // 앞 칸에는 이미지 주소값(초기값), 투표결과를 기준으로 정렬하면서 같이 따라다닌다.
        for (int i = 0; i < rankImage[0].length; i++) rankImage[0][i] = drawId[i];


        // 뒷칸에는 투표결과
        rankImage[1] = intent.getIntArrayExtra("voteCount");

        int size = rankImage[0].length;
        int max; //최소값을 가진 데이터의 인덱스 저장 변수
        int temp;

        // 선택정렬
        for(int i=0; i<size-1; i++){
            max = i;
            for(int j=i+1; j<size; j++) { // voteCount를 기준으로 1등을 제일 앞으로 보내준다.
                if(rankImage[1][max] < rankImage[1][j]) max = j; // 최대값의 인덱스를 구해줌
            }
            // 한바퀴 돌고 나면 제일 마지막에 남은 max인덱스와 제일 앞의 값과 swap
            temp = rankImage[1][max];
            rankImage[1][max] = rankImage[1][i];
            rankImage[1][i] = temp;
            // 1등부터 순서대로 drawble도 이동시켜준다.
            temp = rankImage[0][max];
            rankImage[0][max] = rankImage[0][i];
            rankImage[0][i] = temp;
        }
        // 정렬 종료


        // 정렬된 순서대로 이미지 뷰를 순서대로 그림 지정
        for (int i = 0; i < rankImage[0].length; i++)
            imageViews[i].setImageResource(rankImage[0][i]);



        Button btnStart = findViewById(R.id.btnStart);
        Button btnStop = findViewById(R.id.btnStop);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vf.startFlipping();
                vf.setFlipInterval(1000);
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vf.stopFlipping();
            }
        });

    }
}