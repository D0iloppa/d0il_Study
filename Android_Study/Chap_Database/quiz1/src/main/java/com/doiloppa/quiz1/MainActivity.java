package com.doiloppa.quiz1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText edt_grpName,edt_Num;
    EditText edt_Left,edt_Right;
    Button btn_Init,btn_Insert,btn_Update,btn_Delete,btn_Select;
    String databaseName;
    int version = 1;
    String tableName = "ggTBL";
    SQLiteOpenHelper dbHelper;
    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DatabaseHelper(this);
        db = dbHelper.getWritableDatabase();

        edt_grpName = findViewById(R.id.editText);
        edt_Num = findViewById(R.id.editText2);
        edt_Left = findViewById(R.id.edt_Left);
        edt_Right = findViewById(R.id.edt_Right);

        // 초기화
        btn_Init = findViewById(R.id.button);
        btn_Init.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.onUpgrade(db,version,2);
                btn_Select.callOnClick();
            }
        });

        btn_Insert = findViewById(R.id.button2);
        btn_Insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edt_grpName.getText().toString();
                int number = Integer.parseInt(edt_Num.getText().toString());
                insertQuery(name,number);
                btn_Select.callOnClick();
            }
        });
        // 수정
        btn_Update= findViewById(R.id.button3);
        btn_Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edt_grpName.getText().toString();
                int number = Integer.parseInt(edt_Num.getText().toString());
                updateQuery(name,number);
                btn_Select.callOnClick();
            }
        });

        // 삭제
        btn_Delete = findViewById(R.id.button4);
        btn_Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edt_grpName.getText().toString();
                deleteQuery(name);
                btn_Select.callOnClick();
            }
        });

        // 조회
        btn_Select = findViewById(R.id.button5);
        btn_Select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String gname = "그룹이름\n------------";
                String gnum = "인원\n------------";

                edt_Left.setText(gname);
                edt_Right.setText(gnum);

                Cursor cursor = selectQuery();
            }
        });


    }


    public void insertQuery(String name,int num){
        String query = "INSERT INTO " +tableName + " (name, number) VALUES('"+name+"', "+num+")";
        db.execSQL(query);
    }

    public void updateQuery(String name,int num){
        String query = "UPDATE " +tableName + " SET number="+num+" WHERE name="+"'"+name+"'";
        db.execSQL(query);
    }

    public void deleteQuery(String name){
        String query = "DELETE FROM " + tableName + " WHERE name="+"'"+name+"'";
        db.execSQL(query);

    }

    public Cursor selectQuery() {
        String query = "SELECT * FROM "+tableName;
        Cursor cursor = db.rawQuery(query,null);
        int recordCount = cursor.getCount();
        for(int i=0; i<recordCount ; i++){
            cursor.moveToNext();
            String name = cursor.getString(1);
            int num = cursor.getInt(2);

            println(name,num);
        }

        return cursor;
    }

    public void println(String name,int num){
        edt_Left.append("\n"+name);
        edt_Right.append("\n"+num);
    }

    class DatabaseHelper extends SQLiteOpenHelper{
        public DatabaseHelper(@Nullable Context context) {
            super(context, databaseName, null, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("DROP TABLE IF EXISTS " + tableName);
            db.execSQL("CREATE TABLE IF NOT EXISTS " + tableName +
                    "(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "name TEXT, number INTEGER)");

//            db.execSQL("INSERT INTO " + tableName + "(name, number) VALUES('twice', 9)");

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("drop table if exists "+tableName);
            onCreate(db);
            Toast.makeText(getApplicationContext(),"테이블이 초기화되었습니다.",Toast.LENGTH_LONG).show();

        }
    }
}