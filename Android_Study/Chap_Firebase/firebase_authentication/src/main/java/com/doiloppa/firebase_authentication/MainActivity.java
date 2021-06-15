package com.doiloppa.firebase_authentication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{






    EditText edt_Email,edt_PW;
    TextView txt_Find,txt_Sign,txt_Google;
    Button btn_Sign;
    FirebaseAuth auth;
    ProgressDialog progressDialog;

    private static final int RC_SIGN_IN = 10;
    private GoogleSignInClient mGoogleSignInClient;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        mAuth = FirebaseAuth.getInstance();

        // 뷰 연결
        edt_Email = findViewById(R.id.edtEmail2);
        edt_PW = findViewById(R.id.edtPassword2);

        txt_Find = findViewById(R.id.txtFindPassword);
        txt_Sign = findViewById(R.id.txtViewSign);
        txt_Google = findViewById(R.id.googleSignIn);

        btn_Sign = findViewById(R.id.btnSignUP2);

        // authentication 인스턴스화
        auth = FirebaseAuth.getInstance();
        if(auth.getCurrentUser()!=null) // 현재 로그인 된 상태의 처리
            startActivity(new Intent(this,ProfileActivity.class));

        // 프로그레스
        progressDialog = new ProgressDialog(this);

        btn_Sign.setOnClickListener(this);
        txt_Find.setOnClickListener(this);
        txt_Sign.setOnClickListener(this);
        txt_Google.setOnClickListener(this);



        /////////////////////////////////////


    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnSignUP2:
                userLogin();
                break;
            case R.id.txtFindPassword:
                startActivity(new Intent(this,FindActivity.class));
                finish();
                break;
            case R.id.txtViewSign:
                startActivity(new Intent(this,SigningActivity.class));
                finish();
                break;
            case R.id.googleSignIn:
                signIn();
                break;
        }
    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    public void userLogin(){
        String email = edt_Email.getText().toString();
        String pw = edt_PW.getText().toString();
        // e메일이나 암호를 입력하지 않은 경우
        if(email.isEmpty() || pw.isEmpty()) {
            Toast.makeText(this, "Email 주소나 Password를 입력해주세요.", Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("로그인중입니다. 잠시만 기다려주세요");
        progressDialog.show();

        auth.signInWithEmailAndPassword(email,pw)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if(task.isSuccessful()){ // 로그인 성공
                            startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
                            finish();
                        }else
                            Toast.makeText(MainActivity.this, "로그인 실패", Toast.LENGTH_SHORT).show();

                    }
                });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account.getIdToken());
            } catch (ApiException e) {
            }
        }
    }

    private void firebaseAuthWithGoogle(String idToken) {
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
                            finish();
                        } else {
                            Toast.makeText(MainActivity.this, "로그인 실패", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

}