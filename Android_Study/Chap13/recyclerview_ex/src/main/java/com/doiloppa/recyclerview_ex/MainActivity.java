package com.doiloppa.recyclerview_ex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView; // 리사이클러뷰
    ArrayList<Recycler_Model> list; // 리사이클러뷰에 담을 리스트
    MyAdapter myAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        list = new ArrayList<>();
        list.add(new Recycler_Model("질서너머","조던피터슨"));
        list.add(new Recycler_Model("달러구트 꿈 백화점","이미예"));
        list.add(new Recycler_Model("제12회 젊은작가상 수상작품집(2021)","전하영"));
        list.add(new Recycler_Model("흔한남매. 7(양장본 HardCover)","흔한남매"));
        list.add(new Recycler_Model("주린이가 가장 알고 싶은 최다질문 TOP 77","염승환"));
        list.add(new Recycler_Model("부자 아빠 가난한 아빠. 1(20주년 특별 기념판)(개정증보판) ","로버트 기요사키"));

        MyAdapter adapter = new MyAdapter(this,list,recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter); // 어뎁터를 지정해주면 끝


    }
}