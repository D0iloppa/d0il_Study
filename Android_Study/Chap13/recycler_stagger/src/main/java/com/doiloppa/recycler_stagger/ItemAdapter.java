package com.doiloppa.recycler_stagger;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Random;

import javax.microedition.khronos.opengles.GL;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> {
    ArrayList<Item> list;
    Context context;


    public ItemAdapter(ArrayList<Item> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_Title.setText(list.get(position).getTitle());
//        holder.iv.setImageResource(list.get(position).getResID());
        Glide.with(context).load(list.get(position).getResID()).centerCrop().into(holder.iv);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_Title;
        ImageView iv;

        int[] resId = {R.drawable.pic_001,R.drawable.pic_002,R.drawable.pic_003,R.drawable.pic_004,R.drawable.pic_005,R.drawable.pic_006};

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tv_Title = itemView.findViewById(R.id.country_name);
            this.iv = itemView.findViewById(R.id.country_photo);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context.getApplicationContext(), "클릭한 사진 위치 = "+getLayoutPosition(), Toast.LENGTH_SHORT).show();
                    Random r = new Random();
                    int i = r.nextInt(6);
                    iv.setImageResource(resId[i]);
//                    Glide.with(context).load(resId[i]).centerCrop().into(iv);
                }
            });
        }
    }
}
