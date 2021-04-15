package com.doiloppa.chap13;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ListView mListView = null;
    BaseAdapterEx mAdapter = null;
    ArrayList<Student> mData = null;

    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        mData = new ArrayList<Student>();

        String[] first_Names = {"김","나","박","이","권","최","설","장"};
        String[] names = {"지은","지수","제니","민영","유나","도일","태형"};
        String[] departments = {"간호학과","건축학과","컴퓨터공학과","시스템공학과","경영학과"};
        Random r = new Random();

        for( int i = 0 ; i < 100 ; i++ ) {
            Student student = new Student();

            student.mName = first_Names[r.nextInt(first_Names.length)] + names[r.nextInt(names.length)];
            student.mNumber = "202100" + (i<10 ? "0"+i : i); // i가 10보다 작으면 앞에 0을 붙여서 추가해줌
            student.mDepartment = departments[r.nextInt(departments.length)];

            mData.add( student );
        }

        mAdapter = new BaseAdapterEx ( this, mData );

        mListView = (ListView) findViewById( R.id.list_view );
        mListView.setAdapter( mAdapter );

    }

    public void onClick( View v )
    {
        switch ( v.getId() )
        {
            case R.id.add_btn:
            {
                EditText nameEt =  (EditText) findViewById( R.id.name_edit );
                EditText numberEt = (EditText) findViewById( R.id.number_edit );
                EditText departmentEt = (EditText) findViewById( R.id.department_edit );

                Student addData = new Student();

                addData.mName = nameEt.getText().toString();
                addData.mNumber = numberEt.getText().toString();
                addData.mDepartment = departmentEt.getText().toString();

                mAdapter.add( 0 , addData);

                break;
            }

            case R.id.del_btn:
            {
                EditText delItmeIndexEt = (EditText) findViewById( R.id.del_item_index_edit );

                Integer index = Integer.parseInt( delItmeIndexEt.getText().toString() );

                mAdapter.delete( index );
                break;
            }

            case R.id.all_del_btn:
            {
                mAdapter.clear();
                break;
            }
        }
    }
}