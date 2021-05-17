package com.example.mission_0514;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class SongAdapter extends BaseAdapter {

    ArrayList<SongItem> items = new ArrayList<SongItem>();
    Context context;

    public SongAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return items.size();
    }
    // getCount는 리스트의 사이즈만큼 getView를 돌리기 때문에 반드시 명시해줘야 하는 메소드

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void addItem(SongItem item){
        items.add(item);
    }

    public void removeItem(int postion){
        items.remove(postion);
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        SongItemView view = null;
        if(convertView==null){
            view = new SongItemView(context);
        }else{
            view = (SongItemView)convertView;
        }

        SongItem item = items.get(position);
        view.setTitle(item.getTitle());
        view.setName(item.getSinger());
        view.setImage(item.getImageResource());

        return view;
    }
}
