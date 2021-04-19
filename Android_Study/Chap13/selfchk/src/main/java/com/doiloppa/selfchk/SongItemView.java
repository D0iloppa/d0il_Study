package com.doiloppa.selfchk;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SongItemView extends LinearLayout {

    ImageView mImg;
    TextView mSong_tv,mSinger_tv;

    public SongItemView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) { // 인플레이션 초기화 과정을 함수화
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.song_item,this,true);

        // 요소들 연결
        mSong_tv = findViewById(R.id.txtSongName);
        mSinger_tv = findViewById(R.id.txtSinger);
        mImg = findViewById(R.id.imageView);

    }

    // 세터
    public void setSong(String song) { mSong_tv.setText(song); }
    public void setmSinger(String singer) { mSinger_tv.setText(singer); }
    public void setPrf(int resId) { mImg.setImageResource(resId); }

}
