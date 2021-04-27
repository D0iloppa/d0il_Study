package com.doiloppa.appbarlayout_ex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coordinatorLayout = findViewById(R.id.coordinator);
        Toolbar toolbar = findViewById(R.id.toolbar);

        FloatingActionButton floatingActionButton = findViewById(R.id.fab);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        setSupportActionBar(toolbar);

        ArrayList<String> list = new ArrayList<>();

        for(int i=0;i<20;i++)
            list.add("Item = " + i);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter adapter = new MyAdapter(list);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new MyItemDecoration(this));


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(coordinatorLayout,"나는 스낵바",Snackbar.LENGTH_LONG).show();
            }
        });









    }
}