package com.doiloppa.singlefragment_ex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    MainFragment mainFragment;
    MenuFragment menuFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager(); // 프래그먼트 매니저 호출
        // 메인 액티비티의 xml에 생성되어있는 프래그먼트를 매니저를 통해서 가져옴
//        mainFragment = (MainFragment) fragmentManager.findFragmentById(R.id.mainFragment);

        // 메인 액티비티의 xml에 정적으로 생성하지 않고 프래그먼트 생성하는 방법
        mainFragment = new MainFragment();
        menuFragment = new MenuFragment();

        // 매니저에 프래그먼트 추가
        // 프래그먼트가 들어갈 컨테이너의 아이디와, 집어넣을 프래그먼트를 입력
        fragmentManager.beginTransaction().add(R.id.container,mainFragment).commit();

    }

    public void onSelect(View view) {
        Fragment fr = null;
        switch(view.getId()){
            case R.id.btn_Main:
                fr = mainFragment;
                break;
            case R.id.btn_Menu:
                fr = menuFragment;
                break;
        }

        // 프래그먼트의 교체는 프래그먼트매니저가 수행해준다.
        // 프래그먼트가 담겨있는 뷰의 아이디와, 집어넣을 프래그먼트를 입력해준다.
        // 마지막에 commit()까지 해주어야 정상적으로 수행됨
        fragmentManager.beginTransaction().replace(R.id.container,fr).commit();

    }

    public void onFragmentChanged(int index) {
        if(index==0)
            fragmentManager.beginTransaction().replace(R.id.container,mainFragment).commit();
        else if(index==1)
            fragmentManager.beginTransaction().replace(R.id.container,menuFragment).commit();
    }



}