package com.doiloppa.ratingbar_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    RatingBar ratingBar;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ratingBar = findViewById(R.id.rating);
        txtResult = findViewById(R.id.txtResult);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() { // 레이팅바를 터치했을 때의 이벤트
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                txtResult.setText("결과는 " + rating + "점");
            }
        });

    }
}