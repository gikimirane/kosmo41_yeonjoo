package com.study.android.lifecycle;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity {

    private static final String TAG = "lecture"; // 코드를 합칠 때 공통적으로 알아볼 수 있도록 작성

    String sName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        Toast.makeText(getApplicationContext(),"onCreate() 호출됨",Toast.LENGTH_SHORT).show();
        Intent intent = getIntent();
        sName = intent.getStringExtra("CustomerName");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Toast.makeText(getApplicationContext(),"onCreate() 호출됨",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();

        Toast.makeText(getApplicationContext(),"onResume() 호출됨",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();

        Toast.makeText(getApplicationContext(),"onPause() 호출됨",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();

        Toast.makeText(getApplicationContext(),"onStop() 호출됨",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Toast.makeText(getApplicationContext(),"onDestory() 호출됨",Toast.LENGTH_SHORT).show();
    }

    public void onBtn1Clicked(View v) {
        Intent intent = new Intent();
        intent.putExtra("BackData","정필교");
        setResult(10,intent);

        finish();

    }



}
