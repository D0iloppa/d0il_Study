package com.doiloppa.movie_database;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    ListView movie_List;
    String databaseName = "movieDB";
    int version = 1;
    String tableName = "movieTBL";
    SQLiteOpenHelper dbHelper;
    SQLiteDatabase db;

    @Override
    protected void onResume() {
        super.onResume();
        Cursor cursor = executeQuery();
        String[] columns = {"movie_Name"};
        int[] to={R.id.list_Title};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(getApplicationContext(),R.layout.movie_list,cursor,columns,to);
        movie_List.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 리스트뷰
        movie_List = findViewById(R.id.movie_list);

        // 디비생성
        boolean isOpen = creatDatabase();
        if(isOpen){
            Cursor cursor = executeQuery();
            String[] columns = {"movie_Name"};
            int[] to={R.id.list_Title};
            SimpleCursorAdapter adapter = new SimpleCursorAdapter(getApplicationContext(),R.layout.movie_list,cursor,columns,to);
            movie_List.setAdapter(adapter);
        }

        // 버튼
        Button btn_Add = findViewById(R.id.btn_Add);
        btn_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),AddActivity.class);
                intent.putExtra("state",1); // 추가
                startActivity(intent);

            }
        });



        // 리스트뷰 아이템 클릭
        movie_List.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // 영화 제목 가져오기, 이를 기준으로 DB 검색할 것
                ViewGroup child = (ViewGroup) parent.getChildAt(position);
                TextView tv = child.findViewById(R.id.list_Title);
                String name = tv.getText().toString();

                Intent intent = new Intent(getApplicationContext(),AddActivity.class);
                intent.putExtra("state",2); // 수정
                intent.putExtra("movie_name",name);
                startActivity(intent);
            }
        });
    }

    private Cursor executeQuery() {
        String query = "SELECT * FROM "+tableName;
        Cursor cursor = db.rawQuery(query,null);
        int recordCount = cursor.getCount();
        for(int i=0; i<recordCount ; i++){
            cursor.moveToNext();
            String title = cursor.getString(1);
        }

        return cursor;
    }

    private boolean creatDatabase() {
        dbHelper = new DatabaseHelper(this);
        db = dbHelper.getWritableDatabase();

        return true;
    }

    class DatabaseHelper extends SQLiteOpenHelper {

        public DatabaseHelper(@Nullable Context context) {
            super(context, databaseName, null, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE IF NOT EXISTS " + tableName +
                    "(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "movie_Name TEXT, movie_Year YEAR, movie_Director TEXT, movie_Rate FLOAT, movie_Country TEXT)");


//            db.execSQL("INSERT INTO " + tableName +
//                    "(movie_Name, movie_Year, movie_Director, movie_Rate, movie_Country) " +
//                    "VALUES('Spider-Man:Homecomming',2017, 'Jon Watts',8.92,'USA')");



        }

        @Override
        public void onOpen(SQLiteDatabase db) {
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }

}