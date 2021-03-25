package com.doiloppa.systembroadcastreciever_ex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView; // 어뎁터가 필요함
    ArrayAdapter<String> arrayAdapter; //data와 리스트뷰를 연결해주는 어뎁터
    ArrayList<String> datas; // 리스트뷰의 칼럼(한 줄)에 들어갈 데이터들



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 전화는 위험권한 설정이 되어있지 않으면 막혀있다.
        // 위험권한이 승인되어졌을 경우에만 작동하도록 구성

        // 위험권한이 승인되지 않았을 경우 승인요청하는 리퀘스트
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.PROCESS_OUTGOING_CALLS) != PackageManager.PERMISSION_GRANTED ||
            ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CALL_LOG) != PackageManager.PERMISSION_GRANTED ||
            ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,  new String[] { Manifest.permission.PROCESS_OUTGOING_CALLS,
                            Manifest.permission.READ_CALL_LOG, Manifest.permission.READ_PHONE_STATE},100);

        }

        listView = findViewById(R.id.list);
        datas = new ArrayList<>();

        // 어뎁터에서는 안드로이드에서 기본적으로 제공하는 레이아웃을 활용
        // simple_list_item_1 은 한칸에 데이터 하나만 넣게 만들어진 레이아웃
        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,datas);
        listView.setAdapter(arrayAdapter); // 어뎁터에 담긴 내용을 리스트뷰에 담아준다.

        // onCreate()호출되면서 batteryStatus() 함수를 한번 호출해줌
        batteryStatus();




    }

    private void batteryStatus() {
        // 인텐트 필터를 생성
        IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        // 생성한 인텐트 필터로 리시버 등록
        Intent battery_Status = registerReceiver(null,filter);
        // 배터리 충전상태 식별인자
        int status = battery_Status.getIntExtra(BatteryManager.EXTRA_STATUS,-1);
        // 충전상태의 인자에 따라 충전중인지 아닌지 상태를 명시 => 명시된 상태에 따라 이벤트 처리를 위함
        boolean isCharging = (status == BatteryManager.BATTERY_STATUS_CHARGING);

        if(isCharging){ // 충전중 상태
            int chargePlug = battery_Status.getIntExtra(BatteryManager.EXTRA_PLUGGED,-1);
            boolean usbCharge = (chargePlug == BatteryManager.BATTERY_PLUGGED_USB);
            boolean acCharge = (chargePlug == BatteryManager.BATTERY_PLUGGED_AC);
            // usb충전인지 AC충전인지 구별해서 각 상황에 맞는 String으로 addListItem해준다.
            if(usbCharge){
                addListItem("Battery is USB Charging");
            }else if(acCharge){
                // 그냥 else로 해버리면 usbCharge가 아니면 무조건 acCharge라는 뜻이 되버림
                // 따라서 else if로 해서 acCharge값을 주는 것이 좋다.
                addListItem("Battery is AC Charging");
            }

        }

        // 배터리의 레벨(현재 배터리의 양)과 스케일(총 배터리의 양) 정보를 가져옴
        int level = battery_Status.getIntExtra(BatteryManager.EXTRA_LEVEL,-1);
        int scale = battery_Status.getIntExtra(BatteryManager.EXTRA_SCALE,-1);
        float pct = (level/(float)scale) * 100; // 위 두 정보를 퍼센트로 환산

        // 리스트에 추가
        addListItem("Current Battery : " + pct +"%");

        // 리시버 등록
        registerReceiver(brOn,new IntentFilter(Intent.ACTION_SCREEN_ON));
        registerReceiver(brOff,new IntentFilter(Intent.ACTION_SCREEN_OFF));
        registerReceiver(battery_Receiver,new IntentFilter(Intent.ACTION_POWER_CONNECTED));
        registerReceiver(battery_Receiver,new IntentFilter(Intent.ACTION_POWER_DISCONNECTED));




    }

    public void addListItem(String msg){
        datas.add(msg);
        // 데이터가 리스트에 추가되어도 실시간으로 화면이 변화하지는 않는다.
        // 어뎁터에게 갱신을 요청
        arrayAdapter.notifyDataSetChanged();
    }

    // 배터리 리시버라는
    BroadcastReceiver battery_Receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            // 받아온 인텐트의 액션값(String)에 따라 이벤트처리
            String action = intent.getAction();
            if(action.equals(Intent.ACTION_POWER_CONNECTED)){
                // 파워 연결 액션
                addListItem("on Connected");
                // batteryStatus에서 현재 배터리 상태를 출력해주는 부분을 호출

                batteryStatus();
            } else if(action.equals(Intent.ACTION_POWER_DISCONNECTED)){
                // 연결 해제 액션
                addListItem("off Connected");
                batteryStatus();
            }

        }
    };

    BroadcastReceiver brOn = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            addListItem("Screen ON");;

        }
    };


    BroadcastReceiver brOff = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            addListItem("Screen OFF");;

        }
    };







    // 리퀘스트퍼미션 결과를 출력해줌
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==100 && grantResults.length>0){
            if(grantResults[0] != PackageManager.PERMISSION_GRANTED || grantResults[1] != PackageManager.PERMISSION_GRANTED || grantResults[2] != PackageManager.PERMISSION_GRANTED)
                Toast.makeText(getApplicationContext(), "No Permission", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(getApplicationContext(), "Permission OK", Toast.LENGTH_SHORT).show();
        }
    }


    // 프로그램이 종료될 때( onDestroy() ), 리시버도 등록해제 해줌
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(brOn);
        unregisterReceiver(brOff);
        unregisterReceiver(battery_Receiver);
    }
}