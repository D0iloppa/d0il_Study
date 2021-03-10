package com.doiloppa.j_chap16;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    LinearLayout layout;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = findViewById(R.id.layout);
        editText = findViewById(R.id.editText);
    }

    public void onBenz(View view) {
        int price = Integer.parseInt(editText.getText().toString());
        Car car = new  Benz(this);
        car.setPrice(price);
        CarPrototype.cars.add(car);
        Toast.makeText(getApplicationContext(), "Benz 구매함", Toast.LENGTH_SHORT).show();
        addToLayout();
    }

    public void onBMW(View view) {
        int price = Integer.parseInt(editText.getText().toString());
        Car car = new  BMW(this);
        car.setPrice(price);
        CarPrototype.cars.add(car);
        Toast.makeText(getApplicationContext(), "BMW 구매함", Toast.LENGTH_SHORT).show();
        addToLayout();
    }

    void addToLayout(){
        // 차 버튼 생성
        Button button = new Button(this);
        button.setTag(CarPrototype.cars.size()-1);
        button.setText("Car"+CarPrototype.cars.size());
        button.setTextSize(TypedValue.COMPLEX_UNIT_DIP,50); //50dp로 설정
        layout.addView(button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button curBtn = (Button) v;
                int idx = (Integer) curBtn.getTag();
                Car curCar = CarPrototype.cars.get(idx); // 정보 가져옴
                int price = curCar.getPrice();

                if(curCar instanceof Benz)
                    Toast.makeText(getApplicationContext(), "지금 선택하신 차종은 Benz이고 가격은 " + price + "만원입니다.", Toast.LENGTH_SHORT).show();
                else if(curCar instanceof BMW)
                    Toast.makeText(getApplicationContext(),"지금 선택하신 차종은 BMW 가격은 " + price + "만원입니다.",Toast.LENGTH_SHORT).show();
            }
        });
    }


}