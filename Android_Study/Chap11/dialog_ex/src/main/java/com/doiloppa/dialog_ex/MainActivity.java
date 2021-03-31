package com.doiloppa.dialog_ex;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    EditText edt_Name, edt_Email, dig_Name, dig_Email;
    int index;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_Name = findViewById(R.id.editText);
        edt_Email = findViewById(R.id.editText2);

        Button btn1 = findViewById(R.id.button);
        Button btn2 = findViewById(R.id.button2);


        // 대화상자를 띄우는 버튼
        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                // 다이얼로그 레이아웃을 뷰형태로 가져옴(인플레이션) 그러기 위해서는 인플레이터가 필요하다.
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.dialog,null);
                builder.setView(layout); // 빌더에게 가져온 레이아웃을 넘겨줌
                builder.setTitle("사용자 정보 입력"); // 다이얼로그의 제목설정
                builder.setIcon(R.drawable.ic_menu_allfriends); // 아이콘 설정
                // 인플레이션을 시켰기 때문에 레이아웃 안에있는 요소들을 findViewByID 하는 것이 가능해졌다.
                dig_Name = layout.findViewById(R.id.editText3);
                dig_Email = layout.findViewById(R.id.editText4);
                // 메인에 입력된 값을 대화상자에 설정
                dig_Name.setText(edt_Name.getText().toString());
                dig_Email.setText(edt_Email.getText().toString());
                builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) { // 대화상자의 값을 메인 값들로 설정
                        edt_Name.setText(dig_Name.getText().toString());
                        edt_Email.setText(dig_Email.getText().toString());
                    }
                });

                builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "취소했습니다.", Toast.LENGTH_SHORT).show();
                    }
                });


                builder.show();

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] singer = {"아이유", "브레이브걸스", "트와이스", "블랙핑크"};
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("좋아하는 걸그룹은?");
                ArrayList<String> item = new ArrayList<>();
                /*
                // SingleChoice아이템은 라디오버튼처럼 하나의 값만 선택할 수 있다.
                // 요소중에서 하나를 선택하도록 함
                // 체크드아이템은 기본 체크값(인덱스)를 의미한다. -1이면 아무것도 선택하지 않음
                builder.setSingleChoiceItems(singer, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //which는 체크한 요소의 인덱스 번호
                        index = which; // 이 값을 넘겨준다.
                    }
                });
                builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(index>=0){
                            Toast.makeText(getApplicationContext(), "좋아하는 걸그룹은 ["+ singer[index] + "]입니다.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                */
                // 체크박스형태이며, 여러개의 요소를 선택 가능
                builder.setMultiChoiceItems(singer, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        String value = singer[which];
                        if(isChecked) item.add(value); // 체크되어있으면 item에 추가
                        else item.remove(value); // 체크 안되어있으면 item에서 제거
                    }
                });

                builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String msg = "[";
                        for(int i=0;i<item.size();i++){
                            if(i==item.size()-1)
                                msg += item.get(i) + "]";
                            else msg += item.get(i)+", ";
                        }
                        if(msg.equals("["))
                            Toast.makeText(getApplicationContext(), "선택되지 않음", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(getApplicationContext(), "좋아하는 걸그룹 : \n" + msg, Toast.LENGTH_SHORT).show();
                    }
                });

                builder.show();




            }
        });








    }




    // 백버튼 눌렀을 때 이벤트
    @Override
    public void onBackPressed() {
        // 기본 대화사장자 처리를 위한 기본구조를 생성하는 빌더
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // 제목영역, 메시지영역, 버튼영역

        builder.setTitle("종료 확인");
        builder.setMessage("현재 프로그램을 종료하시겠습니까?");

        // 실제 긍적,부정의 의미보다는 단순한 위치적인 의미가 크다.
        // 서구권과 우리나라의 버튼배치 위치가 다르기 때문, 나라별로 다를 수 있다.
        // negative와 positive 버튼은 우측에 배치된다.
        // negative는 음의 값 => 왼쪽
        // positive는 양의 값 => 오른쪽 (Right)
        // Neutral은 중립 값  => 실제 배치는 화면 좌측

        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
             finish();
            }
        });

        builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // 취소는 말그대로 다이얼로그 창만 종료시켜주므로 아무 작업을 하지 않는다.
            }
        });

        builder.setNeutralButton("자세한 정보", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.show();






    }
}