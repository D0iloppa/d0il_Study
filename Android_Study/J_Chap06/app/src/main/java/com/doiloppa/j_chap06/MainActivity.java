package com.doiloppa.j_chap06;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtName;
    ImageView img;
    Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = findViewById(R.id.edt_Name);
        img = findViewById(R.id.imageView);
    }

    public void onCreatePerson(View view) {
        String name = edtName.getText().toString();
        person = new Person(name,this);
        img.setImageResource(R.drawable.person);

    }

    public void onWalk(View view) {
        if(person.created == false) {
   //         Toast.makeText(getApplicationContext(),"아직 사람이 생성되지 않았습니다.",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(),person.name +"이(가) 걷습니다.",Toast.LENGTH_SHORT).show();
            img.setImageResource(R.drawable.person_walk);
        }
    }

    public void onRun(View view) {
        if(!person.created) {
     //       Toast.makeText(getApplicationContext(),"아직 사람이 생성되지 않았습니다.",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(),person.name + "이(가) 뜁니다.",Toast.LENGTH_SHORT).show();
            img.setImageResource(R.drawable.person_run);
        }

    }
}