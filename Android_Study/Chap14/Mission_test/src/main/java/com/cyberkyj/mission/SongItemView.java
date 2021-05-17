package com.cyberkyj.mission;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class SongItemView extends LinearLayout {

    Context context;
    TextView title;
    TextView singer;
    ImageView imageView;

    public SongItemView(Context context) {
        super(context);
        this.context = context;
        init();

    }

    private void init(){
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.songitem,this, true);
        title = findViewById(R.id.textView);
        singer = findViewById(R.id.textView2);
        imageView = findViewById(R.id.imageView);
     }

    public void setTitle(String title) {
        this.title.setText(title);
    }

    public void setSinger(String singer) {
        this.singer.setText(singer);
    }

    public void setImageView(int id) {
       imageView.setImageResource(id);
    }
}
