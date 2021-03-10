package com.doiloppa.j_chap16;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;

public abstract class CarPrototype implements Car{
    Context context;

    public static ArrayList<Car> cars = new ArrayList<Car>();


    public CarPrototype(Context context) {
        this.context = context;
    }

    @Override
    public void doStart() {
        Toast.makeText(context.getApplicationContext(), "CarPrototype의 doStart 메서드가 호출되었습니다",Toast.LENGTH_LONG).show();
    }

    @Override
    public void doStop() {
        Toast.makeText(context.getApplicationContext(), "CarPrototype의 doStop 메서드가 호출되었습니다",Toast.LENGTH_LONG).show();
    }

    @Override
    public void doTurn() {
        Toast.makeText(context.getApplicationContext(), "CarPrototype의 doTurn 메서드가 호출되었습니다",Toast.LENGTH_LONG).show();
    }




}
