package com.doiloppa.movie_database;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {
    EditText edt_name,edt_year,edt_director,edt_rate,edt_country;
    Button btn_save,btn_update,btn_delete;
    Intent intent;
    int state;
    String databaseName = "movieDB";
    int version = 1;
    String tableName = "movieTBL";
    SQLiteOpenHelper dbHelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        dbHelper = new DatabaseHelper(this);
        db = dbHelper.getWritableDatabase();





        edt_name = findViewById(R.id.edt_Movie_Name);
        edt_year = findViewById(R.id.edt_Movie_Year);
        edt_director = findViewById(R.id.edt_Movie_Director);
        edt_rate = findViewById(R.id.edt_Movie_Rate);
        edt_country = findViewById(R.id.edt_Movie_Country);

        btn_save = findViewById(R.id.btn_Save);
        btn_update = findViewById(R.id.btn_Update);
        btn_delete = findViewById(R.id.btn_Delete);

        intent = getIntent();
        state = intent.getIntExtra("state",1);

        if(state==2) {
            btn_save.setVisibility(View.INVISIBLE);
            String name = intent.getStringExtra("movie_name");
            edt_name.setText(name);

            // 영화 이름을 기준으로 데이터 불러오기
//            String query = "SELECT * FROM "+tableName+" WHERE movie_name ='"+name+"'";
            String query = String.format("SELECT * FROM %s WHERE movie_name='%s'",tableName,name);
            Cursor cursor = db.rawQuery(query,null);
            for(int i=0; i<cursor.getCount(); i++){
                cursor.moveToNext();
                String title = cursor.getString(1);
                int year = cursor.getInt(2);
                edt_year.setText(year+"");
                String director = cursor.getString(3);
                edt_director.setText(director);
                float rate  = cursor.getFloat(4);
                edt_rate.setText(rate+"");
                String country = cursor.getString(5);
                edt_country.setText(country);
            }

        }




        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edt_name.getText().toString();
                int year = Integer.parseInt(edt_year.getText().toString());
                String director = edt_director.getText().toString();
                float rate  = Float.parseFloat(edt_rate.getText().toString());
                String country = edt_country.getText().toString();

                insertQuery(name,year,director,rate,country);
                Toast.makeText(getApplicationContext(), "데이터가 추가되었음", Toast.LENGTH_SHORT).show();
                finish();

            }
        });

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edt_name.getText().toString();
                int year = Integer.parseInt(edt_year.getText().toString());
                String director = edt_director.getText().toString();
                float rate  = Float.parseFloat(edt_rate.getText().toString());
                String country = edt_country.getText().toString();

                updateQuery(name,year,director,rate,country);
                Toast.makeText(getApplicationContext(), "데이터가 수정되었음", Toast.LENGTH_SHORT).show();
                finish();

            }
        });


        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edt_name.getText().toString();
                deleteQuery(name);
                Toast.makeText(getApplicationContext(), "데이터가 삭제되었음", Toast.LENGTH_SHORT).show();
                finish();

            }
        });





    }

    public void insertQuery(String name, int year, String director, float rate, String country){


//        String query = "INSERT INTO " + tableName +
//                "(movie_Name, movie_Year, movie_Director, movie_Rate, movie_Country) " +
//                "VALUES('"+ name + "'," + year + ", '" + director + "',"+rate+",'"+country+"')";

        @SuppressLint("DefaultLocale") String query =
                String.format("INSERT INTO %s (movie_Name, movie_Year, movie_Director, movie_Rate, movie_Country) " +
                        "VALUES('%s',%d,'%s',%f,'%s')", tableName,name,year,director,rate,country);

        db.execSQL(query);
    }

    public void updateQuery(String name, int year, String director, float rate, String country){
//        String query = "UPDATE " +tableName + " SET (movie_Name, movie_Year, movie_Director, movie_Rate, movie_Country) = ('"+
//                name + "'," + year + ", '" + director + "',"+rate+",'"+country+"')"
//                +" WHERE movie_Name = "+"'"+name+"'";

        @SuppressLint("DefaultLocale") String query =
                String.format("UPDATE %s SET (movie_Name, movie_Year, movie_Director, movie_Rate, movie_Country) " +
                        "= ('%s',%d,'%s',%f,'%s') WHERE movie_Name ='%s'",tableName,name,year,director,rate,country,name);
        db.execSQL(query);
    }

    public void deleteQuery(String name){
        String query = "DELETE FROM " + tableName + " WHERE movie_Name="+"'"+name+"'";
        db.execSQL(query);

    }


    class DatabaseHelper extends SQLiteOpenHelper {

        public DatabaseHelper(@Nullable Context context) {
            super(context, databaseName, null, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
        }

        @Override
        public void onOpen(SQLiteDatabase db) {
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }






}