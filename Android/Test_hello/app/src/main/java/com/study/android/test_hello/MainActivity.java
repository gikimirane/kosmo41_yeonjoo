package com.study.android.test_hello;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "lecture";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() { //버튼1에 클릭 리스너 추가

            @Override // 토스트 메시지 띄우기
            public void onClick(View v) {  //클릭이라는 동작 시
                Log.d(TAG, "로그 출력");
                Toast.makeText(getApplicationContext(), "긴 토스트", Toast.LENGTH_LONG).show();
                //"ㄴ검정색창(Toast)에                   ㄴ "긴토스트" 라는 문자열이 출력 됨
            }
        });
    }

    public void onBtn2Clicked(View v) { // 브라우저 연결
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
        startActivity(intent); //이 인텐트 페이지로 넘어가는 것을 시작해!
    }

    public void onBtn3Clicked(View v) { //전화연결
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:01094488471"));
        startActivity(intent);
    }

    public void onBtn4Clicked(View v) {
        EditText editText = findViewById(R.id.editText1); //edittext에서 값을 가지고 옴
        TextView textView = (TextView)findViewById(R.id.textView1); //textview에 할당

        textView.setText(editText.getText());

    }

    public void onBtn5Clicked(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:01094488471"));
        startActivity(intent);

    }
}
