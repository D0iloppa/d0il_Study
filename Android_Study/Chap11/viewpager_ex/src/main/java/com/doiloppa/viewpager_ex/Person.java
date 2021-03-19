package com.doiloppa.viewpager_ex;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Person extends LinearLayout {

    Context context;
    TextView textView;
    ImageView imageView;
    Button button;



    public Person(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public void init() {
        // 일반 클래스에서는 getSystemService를 수행할 수 없다. 따라서 context를 받아오고 호출해야함
        // 아래 두 방법중 어떤 것을 사용해도 상관 없다. 아래가 더 의미적으로 받아들이기 쉬워보인다.
        // context를 가져오지 않으면 이러한 인플레이터를 쓸 수 없다는 점 다시한번 확인
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LayoutInflater inflater1 = LayoutInflater.from(context);

        // 본인이 레이아웃 자체가 된다는 뜻
        inflater1.inflate(R.layout.activity_pager,this,true);
        textView = findViewById(R.id.textView);
        imageView = findViewById(R.id.imageView);
        button = findViewById(R.id.button);

        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = (String) button.getTag();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:"+number));
                context.startActivity(intent);

            }
        });

    }

    public void setName(String name){
        textView.setText(name);
    }

    public void setImage(int id){
        imageView.setImageResource(id);
    }

    public void setCall_Btn(String number){
        button.setText(number);
        button.setTag(number);
    }


}
