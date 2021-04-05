package com.doiloppa.preferencefragment_ex2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    public static final String TARGET_SETTING_PAGE = "target";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SettingsFragment settingPreferenceFragment = new SettingsFragment();
        Intent intent = getIntent();
        if(intent!=null){
            String rootKey = intent.getStringExtra("target");
            if(rootKey!=null){
                Bundle bundle = new Bundle();
                bundle.putString(PreferenceFragmentCompat.ARG_PREFERENCE_ROOT, rootKey);
                settingPreferenceFragment.setArguments(bundle);
            }
        }

        getSupportFragmentManager().beginTransaction()
                .replace(android.R.id.content, settingPreferenceFragment, null)
                .commit();
    }
}