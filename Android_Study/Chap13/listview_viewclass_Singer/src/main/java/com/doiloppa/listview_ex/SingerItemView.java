package com.doiloppa.listview_ex;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SingerItemView extends LinearLayout { // 리니어 레이아웃의 뷰클래스를 상속받음


    TextView txtName,txtMobile,txtAge;
    ImageView prfImg;

    public SingerItemView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) { // 인플레이션 초기화 과정을 함수화
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.singer_item,this,true);

        // 요소들 연결
        txtName = findViewById(R.id.textView);
        txtMobile = findViewById(R.id.textView2);
        txtAge = findViewById(R.id.textView3);
        prfImg = findViewById(R.id.imageView);

    }

    // 세터
    public void setName(String name) { txtName.setText(name); }
    public void setMobile(String mobile) { txtMobile.setText(mobile); }
    public void setAge(int age) { txtAge.setText(""+age); }
    public void setPrf(int resId) { prfImg.setImageResource(resId); }

}
