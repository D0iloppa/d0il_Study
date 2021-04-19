package com.doiloppa.selfchk;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    // 1. 어레이리스트를 어뎁터에서 인스턴스화
    ArrayList<SongItem> mData = new ArrayList<>();


    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    class ViewHolder {
        ImageView mImg;
        TextView mSong_tv,mSinger_tv;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        SongItemView songItemView = new SongItemView(parent.getContext());

        SongItem item = mData.get(position);
        // 각 데이터에서 각 항목들을 가져오고 뷰에 정보를 set해줌
        songItemView.setSong(item.getSongName());
        songItemView.setmSinger(item.getSinger());
        songItemView.setPrf(item.getResId());

        return songItemView;

    }

    void addItem(SongItem item){
        mData.add(item);
    }


}
