package com.doiloppa.recycler_realem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmConfiguration;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import io.realm.Sort;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Realm realm;
    TextView tvNotice;
    RealmQuery<Member> query; // 쿼리문
    RealmResults<Member> results; // 쿼리문의 결과
    RecyclerView recyclerView;
    MyAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(this,new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE
        },0); // 위험권한 사용요청
        
        

        realm.init(this); // 초기화
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build();
        Realm.setDefaultConfiguration(realmConfiguration);

        tvNotice = findViewById(R.id.tv_notice);
        Button btDelete = findViewById(R.id.bt_delete);
        btDelete.setOnClickListener(this);
        Button btJoin = findViewById(R.id.bt_join);
        btJoin.setOnClickListener(this);
        Button btnLogin = findViewById(R.id.bt_login);
        btnLogin.setOnClickListener(this);

        recyclerView = findViewById(R.id.my_recycler_view);

        realm = Realm.getDefaultInstance(); // Realm 인스턴스 생성
        query = realm.where(Member.class); // 질의문이 다룰 테이블 설정
        results = query.findAll(); // 모든 데이터를 가져옴
        results.sort("id", Sort.DESCENDING); // Ascending은 기본값이기 때문에 적어주지 않아도 된다.

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new MyAdapter(results);
        recyclerView.setAdapter(adapter);


        // 질의 결과가 바뀌었을 때 Adapter에게 갱신을 요청
        results.addChangeListener(new RealmChangeListener<RealmResults<Member>>() {
            @Override
            public void onChange(RealmResults<Member> members) {
                adapter.notifyDataSetChanged();
            }
        });








    }

    @Override
    public void onClick(View v) {
        Intent intent;

        switch (v.getId()){
            case R.id.bt_join:
                intent = new Intent(this,JoinActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_login:
                intent = new Intent(this,LoginActivity.class);
                startActivityForResult(intent,0);
                break;
            case R.id.bt_delete:
                // 삭제 트랜잭션
                realm.executeTransactionAsync(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        Member member = realm.where(Member.class).findFirst();
                        if(member!=null)
                            member.deleteFromRealm(); // 삭제
                        return;
                    }
                });
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.removeAllChangeListeners(); //
        realm.close(); // 앱을 종료할 때, realm을 닫지 않으면 메모리상에 남아있게 된다.
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 0:
                if(resultCode==RESULT_OK){ // 로그인 성공
                    String name = data.getStringExtra("Name");
                    String email = data.getStringExtra("eMail");
                    tvNotice.setText(name+"("+email+")으로 로그인했습니다.");
                }else
                    Toast.makeText(getApplicationContext(), "취소", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}