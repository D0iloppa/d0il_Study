package com.doiloppa.menu_ex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {

    SearchView searchView;
    ImageView imageView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        // 이미지에 컨텍스트메뉴를 달아보기
        registerForContextMenu(imageView);


    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0,0,0,"안드로이드 프로그래밍");
        menu.add(0,1,0,"iOS 프로그래밍");
        menu.add(0,2,0,"자바 프로그래밍");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case 0:
                Toast.makeText(getApplicationContext(), "안드로이드 프로그래밍 선택", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(getApplicationContext(), "iOS 프로그래밍 선택", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(getApplicationContext(), "자바 프로그래밍 선택", Toast.LENGTH_SHORT).show();
                break;
        }
            return super.onContextItemSelected(item);
    }

    // xml을 인플레이션 하는 법
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        // 인플레이터가 menu_main을 가져와서 menu와 연결해준다
        inflater.inflate(R.menu.menu_main,menu);

        // 아이콘이 나오지 않도록 기본설정되어있으므로, 아이콘 사용 가능하도록 설정을 변경해준다.
        try {
            // setOptionalIconsVisble이라는 속성이 잠겨있어서
            // 이 속성을 Method라는 클래스를 통해서 강제적으로 불러온다.
            Method method = menu.getClass().getDeclaredMethod("setOptionalIconsVisible",boolean.class);
            method.setAccessible(true);
            method.invoke(menu,true);
        } catch (Exception e) { // 예외사항
            e.printStackTrace();
        }

        // 액션바에서 서치아이콘을 가져와서 이용가능하도록 액션 설정
        MenuItem menuItem = menu.findItem(R.id.menu_main_search);
        searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("검색어를 입력하세요"); // 힌트설정
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() { // 리스너 설정
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchView.setQuery("",false);
                searchView.setIconified(true); // 아이콘을 뜨게함
                Toast.makeText(getApplicationContext(), query, Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });


        return super.onCreateOptionsMenu(menu);
    }

    /*
    // xml파일 말고, 코드로 메뉴를 생성하고 이벤트 처리할 경우 아래처럼 코드작성하면 된다.

    // 메뉴를 만들어줌
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 그룹아이디, 그룹내 인덱스, 오더
        MenuItem item1 = menu.add(0,0,0,"선택");
        MenuItem item2 = menu.add(0,1,0,"레이아웃");

        return true;

    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case 0:
                Toast.makeText(getApplicationContext(), "선택 메뉴를 선택하셨습니다.", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(getApplicationContext(), "레이아웃 메뉴를 선택하셨습니다.", Toast.LENGTH_SHORT).show();
                break;
        }


        return super.onOptionsItemSelected(item);
    }*/








}