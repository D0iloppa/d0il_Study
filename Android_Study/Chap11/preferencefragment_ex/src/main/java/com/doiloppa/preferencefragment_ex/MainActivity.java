package com.doiloppa.preferencefragment_ex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    // Preference Compat이 사용되어야만 peferencescreen을 사용할 수 있다.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SettingPreferenceFragment settingPreferenceFragment = new SettingPreferenceFragment();
        Intent intent = getIntent();
        if(intent!=null){
            String rootKey = intent.getStringExtra("target");
            if(rootKey!=null){
                Bundle bundle = new Bundle();
                bundle.putString(PreferenceFragmentCompat.ARG_PREFERENCE_ROOT, rootKey);
                settingPreferenceFragment.setArguments(bundle);
            }
        }

        getSupportFragmentManager().beginTransaction().replace(android.R.id.content, settingPreferenceFragment,null).commit();


    }
}