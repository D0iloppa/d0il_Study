package com.doiloppa.qz1_chat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {
    EditText edt_Chat;
    Button btn_Send;
    FirebaseDatabase database;
    DatabaseReference myRef;
    RecyclerView recyclerView;
    ChatAdapter adapter;

    int id=0;


    ArrayList<Chat> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("message");

        myRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Iterator<DataSnapshot> iterator = dataSnapshot.getChildren().iterator();
                list.clear();

                while(iterator.hasNext()){
                    DataSnapshot ds = iterator.next();
                    String jsonString = ds.getValue().toString();
                    id = Integer.parseInt(ds.getKey().toString());

                    try {
                        JSONObject data = new JSONObject(jsonString);
                        String name = data.getString("name");
                        String content = data.getString("content");
                        list.add(new Chat(name,content));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });

        // 이름을 받아오는 인텐트
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        edt_Chat = findViewById(R.id.edtContent);
        btn_Send = findViewById(R.id.btnSend);
        btn_Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = edt_Chat.getText().toString();
                if(content.isEmpty()) return;

                writeChat(id,name,content);
                edt_Chat.setText("");
                adapter.notifyDataSetChanged();

            }
        });

        list = new ArrayList<>();


        // 리사이클러뷰 추가
        adapter = new ChatAdapter(list);
        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }

    public void writeChat(int id, String name, String content) {
        Chat chat = new Chat(name, content);

        myRef.child(String.valueOf(++id)).setValue(chat);
    }
}