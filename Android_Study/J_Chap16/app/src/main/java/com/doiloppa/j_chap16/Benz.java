package com.doiloppa.j_chap16;

import android.content.Context;
import android.widget.Toast;

public class Benz extends CarPrototype {

    Context context;
    int price;

    public Benz(Context context) {
        super(context);
    }

    @Override
    public void doRun() {
        Toast.makeText(context.getApplicationContext(), "Benz의 doRun메소드가 호출되었습니다.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }


}
