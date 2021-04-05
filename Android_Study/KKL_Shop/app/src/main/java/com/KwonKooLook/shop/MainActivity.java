package com.KwonKooLook.shop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView; // 하단 메뉴바
    private FragmentManager fm; // 프래그먼트 매니저
    private FragmentTransaction ft; // 프래그먼트 교체할때 이용
    private Fragment1 fragment1;
    private Fragment2 fragment2;
    private Fragment3 fragment3;
    private Fragment4 fragment4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        // 하단 네비에서 메뉴가 선택될 때의 이벤트처리
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.kkl_action_home:
                        setFrag(0);
                        break;
                    case R.id.kkl_action_hot_item:
                        setFrag(1);
                        break;
                    case R.id.kkl_action_cart:
                        setFrag(2);
                        break;
                    case R.id.kkl_action_setting:
                        setFrag(3);
                        break;
                }
                return true;
            }
        });



        // 프래그먼트 생성
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        fragment4 = new Fragment4();
        setFrag(0); // 처음 어플 시작 보여질 화면 기본값은 첫번째 프래그먼트





    }

    // 프래그먼트 교체 메소드
    private void setFrag(int n) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction(); // 실질적인 프래그먼트 교체
        switch (n) { // 입력된 n에 의해 프래그먼트 교체 스위치문
            case 0:
                ft.replace(R.id.main_Frame, fragment1);
                ft.commit();
                break;
            case 1:
                ft.replace(R.id.main_Frame, fragment2);
                ft.commit();
                break;
            case 2:
                ft.replace(R.id.main_Frame, fragment3);
                ft.commit();
                break;
            case 3:
                ft.replace(R.id.main_Frame, fragment4);
                ft.commit();
                break;
        }

    }


}