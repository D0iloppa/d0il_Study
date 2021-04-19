package com.doiloppa.recyclerview_ex;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    Context context;
    int layoutId;
    ArrayList<Recycler_Model> list;
    RecyclerView recyclerView;


    public MyAdapter(Context context, ArrayList<Recycler_Model> list, RecyclerView recyclerView) {
        this.context = context;
        this.list = list;
        this.recyclerView = recyclerView; // 이벤트 처리를 위해서 리사이클러뷰도 가져와준다.
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler,parent,false);
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler,parent,false);

        // 리사이클러뷰의 아이템에 온클릭리스너를 달아주기 위해서 리사이클러뷰를 가져와야한다.
        //
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 포지션 정보를 모르기 때문에 알려줘야한다.
                int position = recyclerView.getChildAdapterPosition(v); // 현재 항목의 위치를 알려줌
                Recycler_Model recycler_model = list.get(position);
                Toast.makeText(context.getApplicationContext(), recycler_model.getTitle(), Toast.LENGTH_SHORT).show();

            }
        });

        return new MyViewHolder(view); // 인플레이션 된 뷰로 뷰홀더 인스턴스화
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Recycler_Model recycler_model = list.get(position);
        holder.title_Tv.setText(recycler_model.getTitle()); // Title을 가져와서 Holder에 넘겨준다.
        holder.author_Tv.setText(recycler_model.getAuthor()); // Author를 가져와서 Holder에 넘겨준다.

    }

    @Override
    public int getItemCount() { // 리스트의 사이즈만큼 사이클이 돌아야 하기 때문에 크기를 지정해줌
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView title_Tv,author_Tv;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.title_Tv = itemView.findViewById(R.id.titleText);
            this.author_Tv = itemView.findViewById(R.id.authorText);

        }
    }
}
