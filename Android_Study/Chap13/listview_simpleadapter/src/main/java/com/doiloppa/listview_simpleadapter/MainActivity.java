package com.doiloppa.listview_simpleadapter;



import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ListView mListView = null;
    ArrayList<HashMap<String, String>> mData = null;

    SimpleAdapter mAdapter = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. 뷰와 그 뷰에 설정될 데이터를 연결하기 위한 배열을 정의한다.
        // ====================================================================
        String[] dataKeyList = {"name", "number", "department"};

        int[] viewIdList = {R.id.name_text,
                R.id.number_text,
                R.id.department_text};
        // ====================================================================

        // 2. 어뎁터에서 사용할 데이터 설정
        // ====================================================================
        mData = new ArrayList<HashMap<String, String>>();

        String[] first_Names = {"김","나","박","이","권","최","설","장"};
        String[] names = {"지은","지수","제니","민영","유나","도일","태형"};
        String[] departments = {"간호학과","건축학과","컴퓨터공학과","시스템공학과","경영학과"};
        Random r = new Random();


        for (int i = 0; i < 100; i++) {
            HashMap<String, String> mapData = new HashMap<String, String>();

            mapData.put(dataKeyList[0], first_Names[r.nextInt(first_Names.length)] + names[r.nextInt(names.length)]);
            mapData.put(dataKeyList[1], "202100" + (i<10 ? "0"+i : i));
            mapData.put(dataKeyList[2], departments[r.nextInt(departments.length)]);

            mData.add(mapData);
        }
        // ====================================================================

        // 3. 어뎁터를 생성하고 데이터 설정
        // ====================================================================
        mAdapter = new SimpleAdapter(this,
                mData,
                R.layout.list_view_item_layout,
                dataKeyList,
                viewIdList);
        // ====================================================================

        // 4. 리스트뷰에 어뎁터 설정
        // ====================================================================
        mListView = (ListView) findViewById(R.id.list_view);
        mListView.setAdapter(mAdapter);
        // ====================================================================
    }

}