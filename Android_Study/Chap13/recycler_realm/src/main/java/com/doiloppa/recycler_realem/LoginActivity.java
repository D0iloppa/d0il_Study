package com.doiloppa.recycler_realem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

public class LoginActivity extends AppCompatActivity {

    EditText etEmail,etPassword;
    CheckBox chk_Auto;

    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        realm = Realm.getDefaultInstance();



        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        chk_Auto = findViewById(R.id.chk_Autologin);




        Button bt_Login_Ok = findViewById(R.id.bt_login_ok);

        bt_Login_Ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RealmQuery<Member> query = realm.where(Member.class);
                RealmResults<Member> results = query.equalTo("eMail",etEmail.getText().toString()).findAll();
                if(results.size()==0)
                    Toast.makeText(getApplicationContext(), "일치하는 회원정보가 없습니다.", Toast.LENGTH_SHORT).show();
                else{ 
                    if(results.get(0).getPassword().equals(etPassword.getText().toString())){


                        Intent intent = new Intent();
                        intent.putExtra("Name",results.get(0).getName());
                        intent.putExtra("eMail",results.get(0).geteMail());
                        intent.putExtra("autoLogin",chk_Auto.isChecked());
                        setResult(RESULT_OK,intent);
                        finish();
                    }else
                        Toast.makeText(getApplicationContext(), "암호가 틀렸습니다.", Toast.LENGTH_SHORT).show();
                        
                    
                }
                    

            }
        });

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }
}