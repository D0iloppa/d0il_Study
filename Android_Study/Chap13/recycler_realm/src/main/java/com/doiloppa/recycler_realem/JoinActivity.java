package com.doiloppa.recycler_realem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import io.realm.Realm;

public class JoinActivity extends AppCompatActivity {

    // 업캐스팅되기 때문에 TextView라고 적어도 오류는 안난다.
    EditText tv_Name,tv_Age,tv_email,tv_password;
    Realm realm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);


        realm = Realm.getDefaultInstance();

        tv_Name =findViewById(R.id.tv_name);
        tv_Age = findViewById(R.id.tv_age);
        tv_email = findViewById(R.id.tv_email);
        tv_password = findViewById(R.id.tv_password);

        Button bt_ok = findViewById(R.id.bt_join_ok);
        Button bt_cancel = findViewById(R.id.bt_join_cancel);



        bt_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tv_Name.getText().toString().isEmpty()||tv_Age.getText().toString().isEmpty()||tv_email.getText().toString().isEmpty()||tv_password.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "필수 입력 항목이 비어 있음.", Toast.LENGTH_SHORT).show();
                    return;
                }

                insertDB();
                Intent intent = new Intent();
                setResult(RESULT_OK,intent);
                finish();


            }
        });

        bt_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    void insertDB() {
        // executeTransaction으로 하면 동작이 안된다.
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Number num = realm.where(Member.class).max("id");
                if(num==null) num = 0;
                else num = num.intValue()+1;

                Member member = realm.createObject(Member.class,num);
                member.setName(tv_Name.getText().toString());
                member.setAge(Integer.parseInt(tv_Age.getText().toString()));
                member.seteMail(tv_email.getText().toString());
                member.setPassword(tv_password.getText().toString());
            }
        });

        realm.where(Member.class);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close(); // realm 닫아줘야함
    }
}