package com.doiloppa.realtime_firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    EditText chkID;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chkID = findViewById(R.id.editText);
        reference = FirebaseDatabase.getInstance().getReference("users");

        Button login = findViewById(R.id.login);
        Button register = findViewById(R.id.register);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        Iterator<DataSnapshot> child = snapshot.getChildren().iterator();
                        while(child.hasNext()){
                            DataSnapshot mChild = child.next();
                            String loginedID = mChild.getKey();
                            String reg_Date = mChild.getValue().toString();
                            if(loginedID.equals(chkID.getText().toString())){
//                            if(child.next().getKey().equals(chkID.getText().toString())){
                                // 로그인이 성공되었을 경우, 회원가입한 날짜데이터를 가져와 출력해줌
//                                Toast.makeText(getApplicationContext(), loginedID+"", Toast.LENGTH_SHORT).show();

                                Toast.makeText(getApplicationContext(),loginedID+"로그인 성공! "
                                        +reg_Date+"에 가입하셨습니다.", Toast.LENGTH_SHORT).show();
                                chkID.setText(""); // 로그인창 공백으로 비워둠
                                reference.removeEventListener(this);
                                return;
                            }
                        }
                        Toast.makeText(getApplicationContext(), "존재하지 않는 아이디 입니다.", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(intent);

            }
        });
    }
}