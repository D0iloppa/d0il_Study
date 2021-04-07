package com.KwonKooLook.shop;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;


public class Fragment1 extends Fragment {

    private RecyclerView mRecyclerView;
    private FeedAdapter mAdapter;
    private LinearLayoutManager linearLayoutManager;
    ArrayList<RecyclerItem> mList = new ArrayList<RecyclerItem>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_1,container,false);

        mRecyclerView = (RecyclerView) viewGroup.findViewById(R.id.recycler1);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        mAdapter = new FeedAdapter(mList);
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        Button btn_add = (Button) viewGroup.findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RecyclerItem recyclerItem = new RecyclerItem(R.drawable.kkl_logo,R.drawable.easteregg,R.drawable.ic_baseline_favorite_border_24,R.drawable.ic_baseline_chat_24,"KwonKooLook","0","none");
                mList.add(recyclerItem);
                mAdapter.notifyDataSetChanged(); // 새로고침
            }
        });




        return viewGroup;

    }



}