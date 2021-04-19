package com.doiloppa.listview_ex;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class SingerAdapter extends BaseAdapter {

    ArrayList<SingerItem> items = new ArrayList<>();

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 뷰정보가 담겨져 있는 클래스에 context정보를 넘겨줌
        SingerItemView singerItemView = new SingerItemView(parent.getContext());
        SingerItem item = items.get(position);
        // 각 데이터에서 각 항목들을 가져오고 뷰에 정보를 set해줌
        singerItemView.setName(item.getName());
        singerItemView.setMobile(item.getMobile());
        singerItemView.setAge(item.getAge());
        singerItemView.setPrf(item.getResId());

        return singerItemView;
    }


    void addItem(SingerItem item){
        items.add(item);
    }

}
