package com.doiloppa.recycler_realem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import io.realm.Realm;

public class JoinActivity extends AppCompatActivity {

    // 업캐스팅되기 때문에 TextView라고 적어도 오류는 안난다.
    EditText tv_Name,tv_Age,tv_email,tv_password;
    Realm realm;

    ImageView iv_Preview;
    Uri uri; // 외부 이미지의 주소
    String img_Source;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);


        realm = Realm.getDefaultInstance();

        tv_Name =findViewById(R.id.tv_name);
        tv_Age = findViewById(R.id.tv_age);
        tv_email = findViewById(R.id.tv_email);
        tv_password = findViewById(R.id.tv_password);
        iv_Preview = findViewById(R.id.iv_Preview);


        Button bt_photo = findViewById(R.id.bt_photo);




        // Select 버튼 눌렀을 때 외부 사진 가져오는 이벤트 작성
        bt_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 외부사진 가져오는 것이기 때문에 manifest에서 위험권한 줘야한다.
                Intent intent = new Intent(Intent.ACTION_PICK); // 사진 선택하는 창
                intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
                intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent,0);
            }
        });


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
                member.setUri(img_Source);
            }
        });

        realm.where(Member.class);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close(); // realm 닫아줘야함
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // 외부 라이브러리에서 사진을 가져옴 (Glide) 사용
        if(resultCode==RESULT_OK){
            uri = data.getData();
            img_Source = uri.toString(); // uri를 테이블에 바로 담을 수 없으므로 우선 문자열로 변환
            Glide.with(this).load(uri).centerCrop().into(iv_Preview); // 이미지를 가져와서 이미지 뷰로 설정

        }



    }
}