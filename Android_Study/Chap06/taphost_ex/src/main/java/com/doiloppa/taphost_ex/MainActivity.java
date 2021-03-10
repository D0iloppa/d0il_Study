package com.doiloppa.taphost_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityGroup;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends ActivityGroup {
    TabHost tabHost;
    TabHost.TabSpec tabDog,tabCat,tabRabbit,tabHorse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        

        
    }
}