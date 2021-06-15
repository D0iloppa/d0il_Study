package com.doiloppa.firestorage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    ImageView iv_Preview, iv_Result;
    Uri filePath;
    String filename;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // 뷰 연결
        iv_Preview = findViewById(R.id.iv_Preview);
        iv_Result = findViewById(R.id.iv_Result);

        Button btnChoose = findViewById(R.id.bt_Choose);
        Button btnUpload = findViewById(R.id.bt_Upload);
        Button btnDownload = findViewById(R.id.bt_Download);

        /////////////////////////////////////////////////////////

        // 버튼 리스너 연결
        btnChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                // 하드웨어에 있는 내용을 가져올 수 있는 액션 지정
                intent.setAction(Intent.ACTION_GET_CONTENT);
                // 선택창을 띄워줌
                startActivityForResult(Intent.createChooser(intent, "Get Choose the image"), 1000);

            }
        });

        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (filePath != null) { // 파일패스가 지정되어있는 경우에만 동작되도록 해준다.
                    ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                    progressDialog.setTitle("Uploading now...");
                    progressDialog.show();

                    FirebaseStorage storage = FirebaseStorage.getInstance();
                    SimpleDateFormat format = new SimpleDateFormat("yyyyMMHH_mmss");
                    Date date = new Date();
                    filename = format.format(date + ".png");
                    StorageReference reference =
                            storage.getReferenceFromUrl("gs://fir-2021-e41df.appspot.com").child("images/" + filename);
                    // 성공,실패,처리중에 해당되는 이벤트리스너를 각각 달아준다.
                    reference.putFile(filePath).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            // 성공시 프로그레스 다이얼로그 종료
                            progressDialog.dismiss();
                            Toast.makeText(getApplicationContext(), "Upload Complete", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            progressDialog.dismiss();
                            Toast.makeText(getApplicationContext(), "Upload Fail", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                            @SuppressWarnings("VisibleFortests")
                            double progress = (100 * snapshot.getBytesTransferred()) / snapshot.getTotalByteCount();
                            progressDialog.setMessage("UPLOAD " + (int) progress + "%...");
                        }
                    });


                } else
                    Toast.makeText(getApplicationContext(), "Choose the File first", Toast.LENGTH_SHORT).show();
            }
        });

        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseStorage storage = FirebaseStorage.getInstance();
                StorageReference reference = storage.getReferenceFromUrl("gs://fir-2021-e41df.appspot.com").child("images/");
                reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        Toast.makeText(getApplicationContext(), "다운로드 성공", Toast.LENGTH_SHORT).show();

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(), "Download Failed", Toast.LENGTH_SHORT).show();
                    }
                });
                try {
                    File localFile = File.createTempFile("images",".png");
                    reference.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                            Toast.makeText(MainActivity.this, "File save Success", Toast.LENGTH_SHORT).show();
                            Bitmap bitmap = BitmapFactory.decodeFile(localFile.getAbsolutePath());
                            iv_Result.setImageBitmap(bitmap);
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(MainActivity.this, "File Save Failed", Toast.LENGTH_SHORT).show();
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });


        ////////////////////////////////////////////////


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000 && resultCode == RESULT_OK) {
            filePath = data.getData(); // 이미지를 가져옴
            try {
                // 우선은 파일형식으로 가져오기 때문에 비트맵 형식으로 변환시켜줘야 한다.
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                iv_Preview.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}