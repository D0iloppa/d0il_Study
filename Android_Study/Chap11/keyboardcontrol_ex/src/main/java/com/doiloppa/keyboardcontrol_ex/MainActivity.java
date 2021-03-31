package com.doiloppa.keyboardcontrol_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.datepicker.MaterialDatePicker;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    InputMethodManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        Button button = findViewById(R.id.button);

        // 인풋메소드를 관리하는 매니저 객체생성
        manager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        editText.requestFocus();
        manager.showSoftInput(editText, InputMethodManager.SHOW_FORCED);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.requestFocus(); // 토글 버튼을 누르면 에딧텍스트로 포커스를 보낸다.
//                manager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                // 키보드를 토글로 제어하게 해준다. 그리고 우선순위를 높게준다.
                manager.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);


            }
        });




    }
}