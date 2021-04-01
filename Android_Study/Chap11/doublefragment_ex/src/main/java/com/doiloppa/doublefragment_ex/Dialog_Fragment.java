package com.doiloppa.doublefragment_ex;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.ListFragment;

public class Dialog_Fragment extends DialogFragment {


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        // 안드로이드x버전꺼로 선택할 것!
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setTitle("종료");
        builder.setMessage("이 프로그램을 종료하시겠습니까?");
        // 확인버튼
        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // 메인액티비티를 종료시켜줌
                ((MainActivity)getActivity()).finish();
            }
        });

        builder.setNegativeButton("취소", null);

        AlertDialog dialog = builder.create(); // 빌더로 다이얼로그 생성하고 다이얼로그에 연결시켜줌

        // 프래그먼트에서 다이얼로그를 만들어주고 리턴해준다
        return dialog;
    }
}