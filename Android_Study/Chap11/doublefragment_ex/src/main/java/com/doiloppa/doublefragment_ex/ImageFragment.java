package com.doiloppa.doublefragment_ex;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class ImageFragment extends Fragment {

    ImageView imageView;
    int[] img_Id = {R.drawable.jeju1,R.drawable.jeju2,R.drawable.jeju3};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // xml에 접근하기 위한 뷰 그룹
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_image, container, false);

        imageView = viewGroup.findViewById(R.id.imageView);

        return viewGroup;
    }

    public void setImage(int id){
        imageView.setImageResource(img_Id[id]);
    }
}