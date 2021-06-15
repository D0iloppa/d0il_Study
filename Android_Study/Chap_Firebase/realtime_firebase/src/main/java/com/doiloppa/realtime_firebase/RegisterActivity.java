package com.doiloppa.realtime_firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

public class RegisterActivity extends AppCompatActivity {

    EditText edtID;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        reference = FirebaseDatabase.getInstance().getReference("users");

        edtID = findViewById(R.id.editText2);
        
        Button register = findViewById(R.id.button2);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reference.addValueEventListener(checkRegister);
            }
        });

    }

    private ValueEventListener checkRegister = new ValueEventListener(){

        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
            // 데이터스냅샷을 찾아오는 순회자
            Iterator<DataSnapshot> child = snapshot.getChildren().iterator();
            while(child.hasNext()){
                // 에딧텍스트에 입력한 아이디가 데이터베이스에 존재하는지 이터레이터로 확인하는 작업
                if(edtID.getText().toString().equals(child.next().getKey())) {
                    Toast.makeText(getApplicationContext(), "이미 존재하는 아이디 입니다.", Toast.LENGTH_SHORT).show();
                    // 이벤트를 종료시켜주지 않으면 다음 번 이벤트에 현재상태가 영향을 미칠 수 있으므로
                    // 이벤트를 반드시 종료시켜줘야한다.
                    reference.removeEventListener(this);
                    return;
                }
            }

            makeNewID();
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    };

    public void makeNewID(){
        SimpleDateFormat format = new SimpleDateFormat(("yyyy-MM-dd hh:mm:ss"));
        Date date = new Date(System.currentTimeMillis());
        String reg_Time = format.format(date);
        reference.child(edtID.getText().toString()).setValue(reg_Time);
        Toast.makeText(getApplicationContext(), "회원가입이 완료되었습니다.", Toast.LENGTH_SHORT).show();
        finish();
    }


}