package com.example.mission_0514;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class SongItemView extends LinearLayout {

    Context context;
    TextView txtTitle;
    TextView txtSinger;
    ImageView imageView;


    public SongItemView(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public SongItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public void init(){
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.songitemview, this, true);
        txtTitle = findViewById(R.id.txtTitle);
        txtSinger = findViewById(R.id.txtSinger);
        imageView = findViewById(R.id.imageView);
    }

    public void setTitle(String title){
        txtTitle.setText(title);
    }

    public void setName(String name){
        txtSinger.setText(name);
    }

    public void setImage(int id){
        imageView.setImageResource(id);
    }
}
