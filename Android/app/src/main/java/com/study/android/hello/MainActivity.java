package com.study.android.hello;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "lecture"; // 코드를 합칠 때 공통적으로 알아볼 수 있도록 작성

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //메모리에 있는 내용 불러오기

        // 버튼1 :
        // 클릭 이벤트 추가
        // 로그 출력 추가
        // 토스트 생성 추가

        //전통적인 방식
        Button button1 = findViewById(R.id.button1); // 버튼을 불러오기
        button1.setOnClickListener(new View.OnClickListener() {
            // 클릭시 반응하는 거
            @Override
            public void onClick(View v){ // 뭐라고 반응할지 적기

                Log.d("lecture","로그 출력");
                Toast.makeText(getApplicationContext(),"긴 토스트", Toast.LENGTH_LONG).show();
            }
        });
    }

    // 버튼2 :
    // 인텐트를 만들어 웹브라우저 띄우기  (인텐트의 정보에 따라 어떤 액티비티가 뜨느냐가 결정됨)
                //함수명은 임의 설정값
    public void onBtn2Clicked(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
        startActivity(intent);
    }

    // 버튼3 :
    // 인텐트를 만들어 전화걸기 창 띄우기 (인텐트의 정보에 따라 어떤 액티비티가 뜨느냐가 결정됨)
                //함수명은 임의 설정값
    public void onBtn3Clicked(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:01094488471"));
        startActivity(intent);
    }


}
