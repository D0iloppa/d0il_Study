package com.KwonKooLook.shop;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.CustomViewHolder>{

    private ArrayList<RecyclerItem> arrayList;

    public FeedAdapter(ArrayList<RecyclerItem> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public FeedAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 리스트뷰가 생성될 때의 생명주기

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_detail,parent,false);
        CustomViewHolder holder = new CustomViewHolder(view); // 인플레이션 된 뷰를 가져옴

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull FeedAdapter.CustomViewHolder holder, int position) {
        // 추가될 때의 생명주기
        holder.iv_profile.setImageResource(arrayList.get(position).getProfile_Img());
        holder.iv_main.setImageResource(arrayList.get(position).getMain_Img());
        holder.iv_like.setImageResource(arrayList.get(position).getLike_Img());
        holder.iv_comment.setImageResource(arrayList.get(position).getComment_Img());

        holder.tv_profile.setText(arrayList.get(position).getProfile_Txt());
        holder.tv_likecount.setText(arrayList.get(position).getLike_Count_Txt());
        holder.tv_comment.setText(arrayList.get(position).getComment_Txt());

        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String curName = holder.tv_profile.getText().toString();
                Toast.makeText(v.getContext(), curName, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        protected ImageView iv_profile,iv_main,iv_like,iv_comment;
        protected TextView tv_profile,tv_likecount,tv_comment;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            // 아이템들을 연결해줌
            this.iv_profile = (ImageView)itemView.findViewById(R.id.detailViewitem_profile_img);
            this.iv_main = (ImageView)itemView.findViewById(R.id.detailViewItem_imgView_content);
            this.iv_like = (ImageView)itemView.findViewById(R.id.detailViewItem_favorite_img);
            this.iv_comment = (ImageView)itemView.findViewById(R.id.detailViewItem_comment_img);
            this.tv_profile = (TextView)itemView.findViewById(R.id.detailViewitem_profile_txt);
            this.tv_likecount = (TextView)itemView.findViewById(R.id.detailViewItem_favoritecounter_txt);
            this.tv_comment = (TextView)itemView.findViewById(R.id.detailViewItem_explain_txt);



        }
    }
}
