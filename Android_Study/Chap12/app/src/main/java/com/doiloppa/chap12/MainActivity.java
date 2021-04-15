package com.doiloppa.chap12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    FloatingActionButton fab, fab_Sub1, fab_Sub2;
    boolean isFabOpen = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.pager);
        TabLayout tabLayout = findViewById(R.id.layout);
        fab = findViewById(R.id.fab);
        fab_Sub1 = findViewById(R.id.fabsub1);
        fab_Sub2 = findViewById(R.id.fabsub2);

        // 어뎁터 설정
        MyAdapter mAdapter = new MyAdapter(getSupportFragmentManager());
        viewPager.setAdapter(mAdapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition()); // tab에서 인덱스 값을 가져온다.

                if (tab.getPosition() == 2) { // 세번째 탭 클릭하면(0부터 시작하니까) 다이얼로그 프래그먼트 출력
                    DialogFragment dialogFragment = new DialogFragment();
                    dialogFragment.show(getSupportFragmentManager(), "");
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        // fab 온클릭 리스너 설정
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                toggleFab(); // 토글로 서브 fab를 출력해주는 액션을 정의해준다.


            }
        });

        fab_Sub1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               Snackbar.make(v, "알림 Fab의 스낵바를 실행하였습니다.", Snackbar.LENGTH_LONG).setAction("More Action", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "스낵바의 액션입니다.", Toast.LENGTH_SHORT).show();
                    }
                }).show();

            }
        });

        fab_Sub2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Snackbar.make(v, "쇼핑 Fab의 스낵바를 실행하였습니다.", Snackbar.LENGTH_LONG).setAction("More Action", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "스낵바의 액션입니다.", Toast.LENGTH_SHORT).show();
                    }
                }).show();

            }
        });


    }

    private void toggleFab() {
        if (isFabOpen) {
            //fab 버튼이 클릭 되지 않았을 때, 서브버튼들의 y축을 0으로 설정해주고 이동
            ObjectAnimator.ofFloat(fab_Sub1, "translationY", 0f).start();
            ObjectAnimator.ofFloat(fab_Sub2, "translationY", 0f).start();
            fab.setImageResource(R.drawable.ic_add);
        } else {
            ObjectAnimator.ofFloat(fab_Sub1, "translationY", -200f).start();
            ObjectAnimator.ofFloat(fab_Sub2, "translationY", -400f).start();
            fab.setImageResource(R.drawable.ic_sub);
        }

        isFabOpen = !isFabOpen; // 토글시켜줌

    }


}