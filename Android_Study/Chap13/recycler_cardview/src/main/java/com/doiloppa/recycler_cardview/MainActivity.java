package com.doiloppa.recycler_cardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Item> itemArrayList;
    RecyclerView recyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        itemArrayList = new ArrayList<>();
        itemArrayList.add(new Item("아이유",29,"IU@naver.com",R.drawable.iu));
        itemArrayList.add(new Item("미노이",25,"meenoi@gamil.com",R.drawable.meenoi));
        itemArrayList.add(new Item("블랙핑크",26,"BlackPink@hanmail.net",R.drawable.blackpink));
        itemArrayList.add(new Item("트와이스",23,"tWice@naver.com",R.drawable.twice));
        itemArrayList.add(new Item("에이핑크",28,"aPink@gmail.com",R.drawable.apink));

        MyAdapter adapter = new MyAdapter(itemArrayList);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);






    }
}