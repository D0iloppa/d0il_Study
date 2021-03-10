package com.doiloppa.progress_bar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    TextView textView;
    Button btn_Up,btn_Down;

    ProgressDialog progressDialog;
    Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //위젯 가져오기
        progressBar = findViewById(R.id.progressBar);
        textView = findViewById(R.id.textView);
        
        
        btn_Up = findViewById(R.id.btn_Up);
        btn_Up.setOnClickListener(new View.OnClickListener() { //up버튼 눌렀을 때 이벤트
            @Override
            public void onClick(View v) {
                if(progressBar.getProgress()>100)progressBar.setProgress(100);
                else progressBar.incrementProgressBy(10);

                textView.setText(progressBar.getProgress()+"%");
            }
        });


        btn_Down = findViewById(R.id.btn_Down);
        btn_Down.setOnClickListener(new View.OnClickListener() { // down버튼 눌렀을 때 이벤트
            @Override
            public void onClick(View v) {
                if(progressBar.getProgress()<0) progressBar.setProgress(0);
                else progressBar.incrementProgressBy(-10); // -10씩 증가한다는 뜻은 10씩 감소한다는 뜻과 동일
                
                textView.setText(progressBar.getProgress()+"%");
            }
        });

        progressDialog = new ProgressDialog(this);

        

    }

    public void onDownload(View view) {
        progressDialog.setMessage("네트워크에서 다운로드 중입니다.");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setProgress(0);
        progressDialog.setMax(100);
        progressDialog.show();

        thread = new Thread(){
            public void run(){
                int time = 0;
                while((time+=5) <100){
                    SystemClock.sleep(200); // 0.2초씩 대기
                    progressDialog.setProgress(time);
                }
                SystemClock.sleep(1000); // 진행이 완료된 후, 1초정도 대기
                progressDialog.dismiss();
            }
        };

        thread.start(); // thread를 콜백시킨다.(시작시킴)
    }

    public void onDate(View view) {
        Calendar c =  Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                if(dayOfMonth<10){ //10일 미만의 날짜에 0을 추가해준다.
                    Toast.makeText(getApplicationContext(), year +"-" + (month+1) + "-0" + dayOfMonth, Toast.LENGTH_SHORT).show();
                } else { //10일 이상이면 그냥 출력
                    Toast.makeText(getApplicationContext(), year +"-" + (month+1) + "-" + dayOfMonth, Toast.LENGTH_SHORT).show();
                }

            }
        },year,month,day);
        datePickerDialog.show();
    }

    public void onTime(View view) {
        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR);
        int min = c.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                if(minute<10){ //10분 미만의 분은 앞에 0을 붙여준다.
                    Toast.makeText(getApplicationContext(), hourOfDay + "시-0" + minute + "분", Toast.LENGTH_SHORT).show();
                } else { //10분 이상이면 그냥 출력
                    Toast.makeText(getApplicationContext(), hourOfDay + "시-" + minute + "분", Toast.LENGTH_SHORT).show();
                }
            }
        },hour,min,false); // 마지막 인자는 24시간모드(true)인지 12시간 모드(false)인지 결정
        timePickerDialog.show();

    }
}