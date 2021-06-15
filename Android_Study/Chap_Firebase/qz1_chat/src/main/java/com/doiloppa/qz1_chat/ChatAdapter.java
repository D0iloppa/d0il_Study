package com.doiloppa.qz1_chat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.transition.Hold;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.Holder> {
    ArrayList<Chat> list;

    public ChatAdapter(ArrayList<Chat> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.cell_chat, parent, false);
        return new Holder(view);

    }



    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.txt_Name.setText(list.get(position).getName());
        holder.txt_Content.setText(list.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        public TextView txt_Name,txt_Content;

        public Holder(@NonNull View itemView) {
            super(itemView);
            txt_Name = itemView.findViewById(R.id.txtName);
            txt_Content = itemView.findViewById(R.id.txtContends);
        }
    }

}
