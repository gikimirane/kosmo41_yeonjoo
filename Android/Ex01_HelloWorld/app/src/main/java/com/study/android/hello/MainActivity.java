package com.study.android.hello;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "lecture"; // 코드를 합칠 때 공통적으로 알아볼 수 있도록 작성

    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //메모리에 있는 내용 불러오기

        editText = findViewById(R.id.editText1);
        textView = (TextView)findViewById(R.id.textView1);

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
    public void onBtn3Clicked(View v) {                        //mailto는 메일, SMS는 문자
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:01094488471"));
        startActivity(intent);
    }

    // 버튼4 :
    //textView에서 텍스트를 가져오고 editText에서 받아서 보여주고
    public void onBtn4Clicked(View v) {
        textView.setText(editText.getText());

    }

    // 버튼5 :
    // 명시적 인텐트 사용으로 새 창 열기
    public void onBtn5Clicked(View v) {
        Intent intent = new Intent(getApplicationContext(),NewActivity.class);
                                  //ㄴ정보를 보여줄때 어떤 컨텍스트를 보여줄 거냐?  >> 새로운 클래스것을 가지고 옴
        intent.putExtra("CustomerName","박충재");// putExtra : 원하는 정보를 넘길때 사용
        //startActivity(intent);
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d(TAG,"콜백 함수 호출됨");

        if(requestCode == 1 && resultCode == 10)
        {
            String sData = "";
            String str = "OnActivityResult() called : " +
                    requestCode + " : " +     //requstCode 는 1
                    resultCode;               //resultCode 는 10
            sData = data.getStringExtra("BackData");   //그럼 backdata를 가져와서
            str = str + " : " + sData;
            //토스트를 띄워서 보여줘라
            Toast.makeText(getApplicationContext(),str,Toast.LENGTH_SHORT).show();
        }
    }


}
