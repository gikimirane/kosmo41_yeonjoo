package com.study.android.projectex05;


import android.content.Context;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import static android.content.Context.INPUT_METHOD_SERVICE;
import static android.content.Context.MODE_NO_LOCALIZED_COLLATORS;

public class Fragment2 extends Fragment {
    private static final String TAG = "lecture";

    InputMethodManager imm;

    DatePicker datePicker;
    TextView viewDatePick;  //  viewDatePick - 선택한 날짜를 보여주는 textView
    EditText edtDiary;   //  edtDiary - 선택한 날짜의 일기를 쓰거나 기존에 저장된 일기가 있다면 보여주고 수정하는 영역
    Button btnSave;   //  btnSave - 선택한 날짜의 일기 저장 및 수정(덮어쓰기) 버튼

    String fileName;   //  fileName - 돌고 도는 선택된 날짜의 파일 이름
    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater,
                            ViewGroup container, Bundle savedInstanceState) { // 앱 첫 시작 시 돌아가는 메소드
        super.onCreate(savedInstanceState);

        imm = (InputMethodManager)context.getSystemService(INPUT_METHOD_SERVICE);

        ViewGroup rootView =
                (ViewGroup) inflater.inflate(R.layout.fragment2, container, false);

        Button button = rootView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Fragment2");
            }
        });

        // 뷰에 있는 위젯들 리턴 받아두기
        datePicker = rootView.findViewById(R.id.datePicker);
        viewDatePick = rootView.findViewById(R.id.viewDatePick);
        edtDiary = rootView.findViewById(R.id.edtDiary);
        btnSave = rootView.findViewById(R.id.btnSave);

        // 오늘 날짜를 받게해주는 Calender
        Calendar c = Calendar.getInstance();
        int cYear = c.get(Calendar.YEAR);
        int cMonth = c.get(Calendar.MONTH);
        int cDay = c.get(Calendar.DAY_OF_MONTH);

        // 첫 시작 시에는 오늘 날짜 일기 읽어주기
        checkedDay(cYear, cMonth, cDay);

        // datePick 기능 만들기
        // datePicker.init(연도,달,일)
        datePicker.init(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth(), new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // 이미 선택한 날짜에 일기가 있는지 없는지 체크
                checkedDay(year, monthOfYear, dayOfMonth);
            }
        });

        // 저장/수정 버튼 누르면 실행되는 리스너
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // fileName을 넣고 저장 시키는 메소드를 호출
                saveDiary(fileName);
            }
        });

    }

    // 일기 파일 읽기
    private void checkedDay(int year, int monthOfYear, int dayOfMonth) {

        // 받은 날짜로 날짜 보여주는
        viewDatePick.setText(year + " - " + monthOfYear + " - " + dayOfMonth);

        // 파일 이름을 만들어준다. 파일 이름은 "20170318.txt" 이런식으로 나옴
        fileName = year + "" + monthOfYear + "" + dayOfMonth + ".txt";
        
        FileInputStream fis = null;
        Context context;

        try {
            fis = openFileInput(fileName);

            byte[] fileData = new byte[fis.available()];
            fis.read(fileData);
            fis.close();

            String str = new String(fileData, "EUC-KR");
            // 읽어서 토스트 메시지로 보여줌
            Toast.makeText(context.getApplicationContext(), "일기 있는 날", Toast.LENGTH_SHORT).show();
            edtDiary.setText(str);
            btnSave.setText("일기 수정");
        } catch (Exception e) { // UnsupportedEncodingException , FileNotFoundException , IOException
            // 없어서 오류가 나면 일기가 없는 것 -> 일기를 쓰게 한다.
            Toast.makeText(context.getApplicationContext(), "일기 없는 날", Toast.LENGTH_SHORT).show();
            edtDiary.setText("");
            btnSave.setText("새일기 저장");
            e.printStackTrace();
        }

    }


    // 일기 저장하는 메소드
    private void saveDiary(String readDay) {

        FileOutputStream fos = null;

        try {
            fos = openFileOutput(readDay, MODE_NO_LOCALIZED_COLLATORS); //MODE_WORLD_WRITEABLE
            String content = edtDiary.getText().toString();

            // String.getBytes() = 스트링을 배열형으로 변환?
            fos.write(content.getBytes());
            //fos.flush();
            fos.close();

            // getApplicationContext() = 현재 클래스.this ?
            Toast.makeText(context.getApplicationContext(), "일기 저장됨", Toast.LENGTH_SHORT).show();

        } catch (Exception e) { // Exception - 에러 종류 제일 상위 // FileNotFoundException , IOException
            e.printStackTrace();
            Toast.makeText(context.getApplicationContext(), "오류오류", Toast.LENGTH_SHORT).show();
        }
    }

        return;

    public void linearOnClick(View v) {
        imm.hideSoftInputFromWindow(edtDiary.getWindowToken(), 0);
    }
}