package com.doiloppa.singlefragment_ex;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class MainFragment extends Fragment {



    // 이 메소드만 있어도 작동함
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // 프래그먼트 내의 요소들에 접근 가능하도록 뷰그룹을 가져와 인플레이션을 해준다.
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_main, container, false);

        Button button = viewGroup.findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // getActivity는 이 프래그먼트의 액티비티의 정보를 가져올 수 있는 메소드
                // 기본적으로 FragmentActivity를 리턴하므로 해당 액티비티로 형변환을 해주어야 한다.
                ((MainActivity)getActivity()).onFragmentChanged(1);


            }
        });


        return viewGroup;
    }

}