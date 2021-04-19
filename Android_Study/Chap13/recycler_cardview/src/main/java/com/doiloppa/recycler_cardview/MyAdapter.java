package com.doiloppa.recycler_cardview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    ArrayList<Item> itemArrayList;

    public MyAdapter(ArrayList<Item> itemArrayList) {
        this.itemArrayList = itemArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name_Tv.setText(itemArrayList.get(position).getName());
        holder.age_Tv.setText(itemArrayList.get(position).getAge() + "세");
        holder.email_Tv.setText(itemArrayList.get(position).getE_Mail());
        holder.img.setImageResource(itemArrayList.get(position).getRes_Id());
    }

    @Override
    public int getItemCount() {
        return itemArrayList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name_Tv,age_Tv,email_Tv;
        ImageView img;


        public MyViewHolder(@NonNull View itemView) { // 뷰홀더에서 객체들 연결
            super(itemView);
            name_Tv = itemView.findViewById(R.id.info_text);
            age_Tv = itemView.findViewById(R.id.info_age);
            email_Tv = itemView.findViewById(R.id.info_email);
            img = itemView.findViewById(R.id.iv_photo);
        }
    }



}
