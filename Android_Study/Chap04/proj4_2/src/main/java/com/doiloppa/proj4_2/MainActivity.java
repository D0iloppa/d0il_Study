package com.doiloppa.proj4_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    CheckBox chk;
    RadioGroup rdoG;
    RadioButton rdo1,rdo2,rdo3;
    LinearLayout lay;
    Button btn;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lay = findViewById(R.id.lay);
        chk = findViewById(R.id.checkBox);
        chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(chk.isChecked()==true) {
                    lay.setVisibility(View.VISIBLE);
                }
                else{
                    lay.setVisibility(View.INVISIBLE);

                }

            }
        });

        btn = findViewById(R.id.button);
        img = findViewById(R.id.imageView);

        rdoG = findViewById(R.id.radioG);
        rdo1 = findViewById(R.id.radioButton);
        rdo2 = findViewById(R.id.radioButton2);
        rdo3 = findViewById(R.id.radioButton3);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img.setVisibility(View.VISIBLE);

                switch(rdoG.getCheckedRadioButtonId()){
                    case R.id.radioButton:
                        img.setImageResource(R.drawable.dog);
                        break;
                    case R.id.radioButton2:
                        img.setImageResource(R.drawable.cat);
                        break;
                    case R.id.radioButton3:
                        img.setImageResource(R.drawable.rabbit);
                        break;

                }


            }
        });




    }
}