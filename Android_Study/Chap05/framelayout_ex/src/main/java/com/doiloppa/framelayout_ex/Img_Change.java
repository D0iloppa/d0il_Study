package com.doiloppa.framelayout_ex;

import android.view.View;
import android.widget.ImageView;

public class Img_Change {
    public static int change_Img(ImageView img1, ImageView img2 , int index){
        if(index == 0){
            img1.setVisibility(View.VISIBLE);
            img2.setVisibility(View.INVISIBLE);
            return 1;
        }
        else {
            img1.setVisibility(View.INVISIBLE);
            img2.setVisibility(View.VISIBLE);
            return 0;
        }
    }

}
