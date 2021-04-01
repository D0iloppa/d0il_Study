package com.doiloppa.doublefragment_ex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    List_Fragment list_fragment;
    ImageFragment imageFragment;
    Dialog_Fragment dialog_fragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        list_fragment = new List_Fragment();
        imageFragment = new ImageFragment();
        dialog_fragment = new Dialog_Fragment();

        fragmentManager.beginTransaction().add(R.id.container1,list_fragment).commit();
        fragmentManager.beginTransaction().add(R.id.container2,imageFragment).commit();

    }

    public void onImageSelected(int position){
        imageFragment.setImage(position);
    }


    @Override
    public void onBackPressed() { // 백버튼 눌렀을 때
        // 프래그먼트 다이얼로그 생성하는 것을 보기위해 백버튼 눌렀을 때의 이벤트로 확인해본다.
        dialog_fragment.show(fragmentManager,null);

    }
}