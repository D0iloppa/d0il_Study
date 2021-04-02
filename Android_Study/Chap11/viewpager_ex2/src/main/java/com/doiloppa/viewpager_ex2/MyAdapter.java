package com.doiloppa.viewpager_ex2;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class MyAdapter extends FragmentPagerAdapter {

    ArrayList<Fragment> datas; // 프래그먼트를 담아주는 어레이리스트

    public MyAdapter(@NonNull FragmentManager fm) {
        super(fm);
        datas =  new ArrayList<Fragment>();
        datas.add(new FragmentA());
        datas.add(new FragmentB());
        datas.add(new FragmentC());
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return datas.get(position);
    }

    @Override
    public int getCount() {
        return datas.size();
    }
}
