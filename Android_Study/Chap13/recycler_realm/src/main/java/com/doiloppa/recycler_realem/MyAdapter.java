package com.doiloppa.recycler_realem;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.lang.reflect.Array;
import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    RealmResults<Member> mDataset; // 결과값의 집합
    Realm realm;
    MainActivity mainActivity;


    public MyAdapter(RealmResults<Member> mDataset,MainActivity mA) {
        this.mDataset = mDataset;
        realm = Realm.getDefaultInstance();
        mainActivity = mA;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mName.setText(mDataset.get(position).getName());
        holder.mAge.setText(mDataset.get(position).getAge()+"세"); // int형이므로 String으로 변환해줘야함
        holder.mEmail.setText(mDataset.get(position).geteMail());
        holder.mPhoto.setImageURI(Uri.parse(mDataset.get(position).getUri()));


        int mPosition = holder.getAdapterPosition();



        holder.mPhoto.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Snackbar.make(v, "삭제되었습니다."+ mPosition, Snackbar.LENGTH_LONG).show();

                    realm.executeTransactionAsync(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            Member member = realm.where(Member.class).findAll().get(mPosition);
                            if(member!=null){
                                if(member.isLogined()) mainActivity.logOut();
                                member.deleteFromRealm(); // 삭제
                            }
                            return;
                        }
                    });



                return false;
            }
        });





    }


    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mName,mAge,mEmail;
        ImageView mPhoto;



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

//            int mPosition = this.getAdapterPosition();
//            itemView.setOnLongClickListener(new View.OnLongClickListener() {
//                @Override
//                public boolean onLongClick(View v) {
//                    Snackbar.make(v, "삭제되었습니다."+ mPosition, Snackbar.LENGTH_LONG).show();
//
//                    realm.executeTransactionAsync(new Realm.Transaction() {
//                        @Override
//                        public void execute(Realm realm) {
//                            Member member = realm.where(Member.class).findAll().get(mPosition);
//                            if(member!=null)
//                                member.deleteFromRealm(); // 삭제
//                            return;
//                        }
//                    });
//
//
//                    return false;
//                }
//            });

            this.mName = itemView.findViewById(R.id.info_text);
            this.mAge = itemView.findViewById(R.id.info_age);
            this.mEmail = itemView.findViewById(R.id.info_email);
            this.mPhoto = itemView.findViewById(R.id.iv_Preview);
        }





    }
}
