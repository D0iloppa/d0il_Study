package com.doiloppa.asynctask_timer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    int timeCount = 10;
    BackgroundTask backgroundTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.main_textView);
    }

    public void startView(View view) {
        timeCount = timeCount>0?timeCount:10;
        backgroundTask = new BackgroundTask();
        backgroundTask.execute();
    }

    public void pauseView(View view) {
        backgroundTask.cancel(true);
    }


    class BackgroundTask extends AsyncTask<Void,Integer,Integer> {

        @Override
        protected Integer doInBackground(Void... voids) {
            while(!isCancelled()){

                if(timeCount<0) break;
                else publishProgress(timeCount);


                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                timeCount--;

            }
            return timeCount;
        }

        @Override
        protected void onPostExecute(Integer integer) { textView.setText( "Finished" ); }

        @Override
        protected void onProgressUpdate(Integer... values) { textView.setText(values[0]+""); }

    }
}