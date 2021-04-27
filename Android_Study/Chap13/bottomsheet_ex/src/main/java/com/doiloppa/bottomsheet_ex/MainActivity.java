package com.doiloppa.bottomsheet_ex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    BottomSheetBehavior<View> persistent_BottomSheet;
    ArrayList<Item> list;
    public static BottomSheetDialog bottomSheetDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View view = findViewById(R.id.bottom_sheet);


        list = new ArrayList<>();
        list.add(new Item(ResourcesCompat.getDrawable(getResources(),R.drawable.ic_lab4_1,null),"Keep"));
        list.add(new Item(ResourcesCompat.getDrawable(getResources(),R.drawable.ic_lab4_2,null),"Inbox"));
        list.add(new Item(ResourcesCompat.getDrawable(getResources(),R.drawable.ic_lab4_3,null),"Messanger"));
        list.add(new Item(ResourcesCompat.getDrawable(getResources(),R.drawable.ic_lab4_4,null),"Google"));


        persistent_BottomSheet = BottomSheetBehavior.from(view);

        persistent_BottomSheet.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if(persistent_BottomSheet.getState()==BottomSheetBehavior.STATE_HIDDEN) // 바텀시트가 숨겨져 있는 상태
                    persistent_BottomSheet.setState(BottomSheetBehavior.STATE_COLLAPSED); // 기본크기
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });

    }

    public void onModal(View view) {
        MyAdapter adapter = new MyAdapter(list,this);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        View v = getLayoutInflater().inflate(R.layout.layout_recycler,null);
        RecyclerView recyclerView = v.findViewById(R.id.recycler_View);
        recyclerView.setLayoutManager(lm);
        recyclerView.setAdapter(adapter);

        bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(v);
        bottomSheetDialog.show();
    }
}