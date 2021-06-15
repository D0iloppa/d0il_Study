package com.doiloppa.firebase_authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SigningActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edt_Email, edt_PW;
    TextView txt_Signin,txt_Message;
    Button btn_SignUp;
    FirebaseAuth auth;
    ProgressDialog progressDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signing);

        edt_Email = findViewById(R.id.edtEmail);
        edt_PW = findViewById(R.id.edtPassword);
        txt_Signin = findViewById(R.id.viewSignIn);
        txt_Message = findViewById(R.id.textView2);
        btn_SignUp = findViewById(R.id.btnSignUP);

        auth = FirebaseAuth.getInstance();
        if(auth.getCurrentUser()!=null){
            startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
            finish();
        }

        progressDialog = new ProgressDialog(this);

        btn_SignUp.setOnClickListener(this);
        txt_Signin.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnSignUP:
                registerUser();
                break;
            case R.id.viewSignIn:
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
                break;
        }

    }

    private void registerUser() {
        String email = edt_Email.getText().toString();
        String pw = edt_PW.getText().toString();
        if(email.isEmpty() || pw.isEmpty()){
            Toast.makeText(getApplicationContext(), "Email 주소나 Password를 입력해주세요.", Toast.LENGTH_SHORT).show();
            return;
        }
        progressDialog.setMessage("등록중입니다. 잠시 기다려주세요");
        progressDialog.show();

        auth.createUserWithEmailAndPassword(email,pw).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
                    finish();
                }else
                    Toast.makeText(getApplicationContext(), "회원가입 실패", Toast.LENGTH_SHORT).show();

                progressDialog.dismiss();

            }
        });
    }


}