package com.doiloppa.webview_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edtUrl;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 위젯 가져오기
        edtUrl = findViewById(R.id.edt_Url);
        webView = findViewById(R.id.webView);
        Button btnMove = findViewById(R.id.btn_Move);
        Button btnBack = findViewById(R.id.btn_Back);

        webView.setWebViewClient(new WebBrowser()); // 아래에 설정해놓은 클래스로 웹브라우저를 설정해준다.

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true); // 자바스크립트 허용
        
        webView.loadUrl("file:///android_asset/index.html"); // 웹뷰의 첫 페이지는 index.html로 설정

        btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl(edtUrl.getText().toString());
                // 에딧텍스트의 값을 가져와서 웹뷰의 url로 넘겨준다.
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.goBack(); // 뒤로가기 버튼
            }
        });

    }

    class  WebBrowser extends WebViewClient { // 사용할 웹 브라우저 클래스 정의
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                view.loadUrl(request.getUrl().toString()); // url을 불러와서 이동한다.
            }

            return true;
        }
    }



}