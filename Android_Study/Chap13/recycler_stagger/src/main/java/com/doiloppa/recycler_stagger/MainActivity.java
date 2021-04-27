package com.doiloppa.recycler_stagger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ArrayList<Item> list;
    RecyclerView recyclerView;
    ItemAdapter itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        list = getAllList();
//      GridLayoutManager lm = new GridLayoutManager(this,3);
        StaggeredGridLayoutManager lm = new StaggeredGridLayoutManager(2,1);
        recyclerView.setLayoutManager(lm);


        itemAdapter = new ItemAdapter(list,this);
        recyclerView.setAdapter(itemAdapter);





    }

    private ArrayList<Item> getAllList() {

        Random r = new Random();


        int[] resIDs = {R.drawable.pic_001,R.drawable.pic_002,R.drawable.pic_003,R.drawable.pic_004,R.drawable.pic_005,R.drawable.pic_006};
        int resID2 = R.drawable.pic_003;
        int resID3 = R.drawable.pic_004;

        ArrayList<Item> allItems = new ArrayList<>();
        for(int i = 0; i<15; i++){
            int idx = r.nextInt(6);
            allItems.add(new Item("연예인#"+(i<10?"0"+i:i),resIDs[idx]));
        }



        return  allItems;

    }
}