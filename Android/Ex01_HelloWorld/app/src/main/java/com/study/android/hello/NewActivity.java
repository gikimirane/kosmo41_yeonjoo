package com.study.android.hello;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity {

    String sName; //전역변수 설정

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        //인텐트에 전달된 데이타 구하기
        Intent intent = getIntent();
        sName = intent.getStringExtra("CustomerName"); // main 버튼5에 넣은 putExtra 값
    }

    public void onBtn1Clicked(View v) {
        // 토스트로 전달받은 데이터 보여주기
        Toast.makeText(getApplicationContext(),
                "CustomerName : " + sName, Toast.LENGTH_SHORT).show();
    }

    // 종료버튼 : finish();
    public void onBtn2Clicked(View v) {
        // 현재 인텐트 종료시 인텐트에 전달할 데이터 세팅
        Intent intent = new Intent();
        intent.putExtra("BackData","정필교"); //10은 0~9 intent에 대해 역으로 보낼 내용
        setResult(10,intent);

        finish();
    }
}
