package com.doiloppa.self_check3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int[] voteCount = new int[9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < voteCount.length; i++) voteCount[i] = 0; // 0으로 초기화

        ImageView[] image = new ImageView[9];
        int[] imageId = {R.id.image1, R.id.image2, R.id.image3, R.id.image4, R.id.image5,
                R.id.image6, R.id.image7, R.id.image8, R.id.image9};
        String[] imgName = {"독서하는 소녀", "꽃 장식 모자 소녀", "부채를 든 소녀", "이레느깡 단 베르앙",
                "잠자는 소녀", "테라스의 두 자매", "피아노 레슨", "피아노 앞의 소녀들", "해변에서"};
        for (int i = 0; i < image.length; i++) {
            int index = i;
            image[i] = findViewById(imageId[i]);

            image[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    voteCount[index]++;
                    Toast.makeText(getApplicationContext(), imgName[index] + " : 총" + voteCount[index] + "표", Toast.LENGTH_SHORT).show();
                }
            });

        }

        Button btn_Vote = findViewById(R.id.button);
        btn_Vote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                // 명시적 인텐트
//                Intent intent_Explicit = new Intent(getApplicationContext(), ResultActivity.class);
//                intent_Explicit.putExtra("voteCount", voteCount);
//                intent_Explicit.putExtra("imgName", imgName);


                // 암시적 인텐트
                Intent intent_Implicit = new Intent();
                intent_Implicit.setAction("android.intent.action.SORT_VOTE");
                intent_Implicit.addCategory("com.doiloppa.category.MYCATEGORY");
                intent_Implicit.putExtra("voteCount", voteCount);
                intent_Implicit.putExtra("imgName", imgName);
                
                // 암시적 인텐트 시작
                startActivity(intent_Implicit);
            }
        });


    }
}