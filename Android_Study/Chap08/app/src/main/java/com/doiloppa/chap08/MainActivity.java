package com.doiloppa.chap08;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score=0;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("Lifecycle","onCreate 호출됨");

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),NewActivity.class)); //일회용을 쓴다. 다른 클래스 이기때문에 this X
            }
        });

        editText = findViewById(R.id.editTextTextPersonName);

        if(savedInstanceState!=null)
            editText.setText(savedInstanceState.getString("Data"));
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) { // 가로세로모드 변경
        super.onConfigurationChanged(newConfig);
        Log.i("Lifecycle","onConfigurationChanged 호출됨");
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Lifecycle","onRestart 호출됨");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Lifecycle","onStart 호출됨");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Lifecycle","onStop 호출됨");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Lifecycle","onDestroy 호출됨");
        SharedPreferences sharedPreferences = getSharedPreferences("TEST",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Lifecycle","onPause 호출됨");
        saveData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Lifecycle","onResume 호출됨");
        if(score!=0) restoreData();

    }

    public void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences("TEST",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("Score",10000);
        editor.putString("message","저는 데이터입니다.");
        editor.commit();
    }

    private void restoreData(){
        SharedPreferences sharedPreferences = getSharedPreferences("TEST",MODE_PRIVATE);
        score = sharedPreferences.getInt("Score",0);
        Toast.makeText(getApplicationContext(), ""+score, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onSaveInstanceState(@Nullable Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("LifeCycle","onSaveInstanceState 호출됨");
        outState.putString("Data",editText.getText().toString());
    }
}