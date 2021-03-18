package com.doiloppa.chap10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    GestureDetector gestureDetector;
    ScrollView scrollView;
    final int SWIPE_MIN_DISTANCE = 120; // SWIPE를 인식하는 가장 작은 거리
    final int SWIPE_VELOCITY = 2000; // SWIPE인식 최소속도(ms)
    long initTime = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View layout1 = findViewById(R.id.layout1);
        View layout2 = findViewById(R.id.layout2);
        scrollView = findViewById(R.id.scrollView);
        textView = findViewById(R.id.textView);

        layout1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                float x = event.getX();
                float y = event.getY();

                if(action==MotionEvent.ACTION_DOWN)
                    textView.append("손가락 눌림 : " + x + ", " + y + "\n");
                else if(action==MotionEvent.ACTION_MOVE)
                    textView.append("손가락 이동 : " + x + ", " + y + "\n");
                else if(action==MotionEvent.ACTION_UP)
                    textView.append("손가락 뗌 : " + x + ", " + y + "\n");

                scrollView.fullScroll(ScrollView.FOCUS_DOWN);

                return false;
            }
        }); // layout1 끝

        layout2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetector.onTouchEvent(event); // 제스쳐 디텍터
                scrollView.fullScroll(ScrollView.FOCUS_DOWN);
                return false;
            }
        }); // layout2 끝


        // 제스쳐 디텍터 정의
        gestureDetector = new GestureDetector(this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent e) {
                textView.append("onDown 호출됨\n");
                return false;
            }

            @Override
            public void onShowPress(MotionEvent e) {
                textView.append("onShowPress 호출됨\n");
            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                textView.append("onSingleTapUp 호출됨\n");
                return false;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                textView.append("onScroll 호출됨\n");
                return false;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                textView.append("onLongPress 호출됨\n");
            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                textView.append("onFling 호출됨\n");
                // x축으로 SWIPE할 때의 최소거리와 속도보다 큰 경우 플리핑으로 인식하겠다.
                if(e1.getX()-e2.getX()>SWIPE_MIN_DISTANCE && Math.abs(velocityX)>SWIPE_VELOCITY) // 왼쪽
                    Toast.makeText(getApplicationContext(), "LEFT SWIPE", Toast.LENGTH_SHORT).show();
                else if(e2.getX()-e1.getX()>SWIPE_MIN_DISTANCE && Math.abs(velocityX)>SWIPE_VELOCITY) // 오른쪽
                    Toast.makeText(getApplicationContext(), "RIGHT SWIPE", Toast.LENGTH_SHORT).show();
                else if(e1.getY()-e2.getY()>SWIPE_MIN_DISTANCE && Math.abs(velocityX)>SWIPE_VELOCITY) // 위쪽
                    Toast.makeText(getApplicationContext(), "UP SWIPE", Toast.LENGTH_SHORT).show();
                else if(e2.getY()-e1.getY()>SWIPE_MIN_DISTANCE && Math.abs(velocityX)>SWIPE_VELOCITY) // 아래쪽
                    Toast.makeText(getApplicationContext(), "DOWN SWIPE", Toast.LENGTH_SHORT).show();

                return false;
            }
        }); // 제스쳐 디텍터



    } // onCreate 끝



//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_BACK) {
//            if(System.currentTimeMillis()-initTime>3000){
//                Toast.makeText(getApplicationContext(), "종료하려면 한번 더 누르세요", Toast.LENGTH_SHORT).show();
//                initTime=System.currentTimeMillis();
//            }else{
//                finish();
//            }
//        }
//        return true;
//    }


    @Override
    public void onBackPressed() {
        if(System.currentTimeMillis()-initTime>3000){
            Toast.makeText(getApplicationContext(), "종료하려면 한번 더 누르세요", Toast.LENGTH_SHORT).show();
            initTime=System.currentTimeMillis();
        }else{
            finish();
        }
    }
}