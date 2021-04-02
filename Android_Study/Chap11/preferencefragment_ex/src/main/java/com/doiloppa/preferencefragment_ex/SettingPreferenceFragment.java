package com.doiloppa.preferencefragment_ex;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;
import androidx.preference.PreferenceScreen;

public class SettingPreferenceFragment extends PreferenceFragmentCompat {

    Preference soundPreference;
    Preference keywordScreen;
    Preference editPreference;

    SharedPreferences prfs;


    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.settings_preference, rootKey);
        if (rootKey == null) {
            soundPreference = findPreference("sound_List");
            keywordScreen = findPreference("keyword_screen");
            editPreference = findPreference("nickname");

            prfs = PreferenceManager.getDefaultSharedPreferences(getActivity());


            if (!prfs.getString("sound_List", "").equals(""))
                soundPreference.setSummary(prfs.getString("sound_List", "카톡"));

            if (prfs.getBoolean("keyword", false))
                keywordScreen.setSummary("사용");
            else keywordScreen.setSummary("사용안함");

            if (!prfs.getString("nickname", "").equals(""))
                editPreference.setSummary(prfs.getString("nickname", "닉네임을 설정해주세요"));

            prfs.registerOnSharedPreferenceChangeListener(preferenceChangeListener);
        }


    }

    SharedPreferences.OnSharedPreferenceChangeListener preferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() {
        @Override
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
            if (key.equals("sound_List"))
                soundPreference.setSummary(prfs.getString("sound_List", "카톡"));

            if (prfs.getBoolean("keyword", false))
                keywordScreen.setSummary("사용");
            else keywordScreen.setSummary("사용안함");

            if (key.equals("nickname"))
                editPreference.setSummary(prfs.getString("nickname", "닉네임을 설정해주세요"));
        }
    };

    @Override
    public void onNavigateToScreen(PreferenceScreen preferenceScreen) {
        Intent intent = new Intent(getActivity(), MainActivity.class);
        intent.putExtra("target", preferenceScreen.getKey());
        startActivity(intent);
    }


}
