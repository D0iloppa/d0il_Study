package com.doiloppa.doublefragment_ex;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class List_Fragment extends ListFragment {


    // 리스트 프래그먼트는 onViewCreated 메소드를 사용해야한다.
    // 이 클래스에서 구조를 만들어 주기 때문에 인플레이션할 xml파일이 필요없다.
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String[] datas = {"첫번째 이미지","두번째 이미지","세번째 이미지"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,datas);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        // 리스트뷰에서 클릭한 번호를 메인액티비티로 넘겨줌
        ((MainActivity) getActivity()).onImageSelected(position);
    }
}