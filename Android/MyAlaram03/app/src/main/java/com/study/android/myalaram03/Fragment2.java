package com.study.android.myalaram03;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Fragment2 extends Fragment {
    private static final String TAG = "lecture";
    public Context mContext;

    DatePicker datePicker;
    TextView viewDatePick;
    EditText edtDiary;
    Button btnSave;

    String fileName;

    MyDBHelper helper = new MyDBHelper(this);

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        ViewGroup rootView =
                (ViewGroup) inflater.inflate(R.layout.fragment2,container, false);

    //    context = container.getContext();

        // 뷰에 있는 위젯들 리턴 받아두기
        datePicker = rootView.findViewById(R.id.datePicker);
        viewDatePick = rootView.findViewById(R.id.viewDatePick);
        edtDiary = rootView.findViewById(R.id.edtDiary);
        btnSave = rootView.findViewById(R.id.btnSave);

        // 오늘 날짜를 받게해주는 Calender 친구들
        Calendar c = Calendar.getInstance();
        int cYear = c.get(Calendar.YEAR);
        int cMonth = c.get(Calendar.MONTH);
        int cDay = c.get(Calendar.DAY_OF_MONTH);

        // 첫 시작 시에는 오늘 날짜 일기 읽어주기
        SQLiteDatabase db = helper.getWritableDatabase();

        // 파일 이름을 만들기
        fileName = Integer.toString(cYear) + "" + Integer.toString(cMonth + 1) + "" + Integer.toString(cDay) + ".txt";

        String str = readDiary(fileName);
        edtDiary.setText(str);
        btnSave.setEnabled(true);

        // datePick 기능 만들기 (datePicker.init(연도,달,일))
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
                if(btnSave.getText().toString().equals("새일기저장")){
                    SQLiteDatabase db = helper.getWritableDatabase();
                    String sql = "insert into yjDiary values("+fileName+","+edtDiary.getText().toString()+";";
                    db.execSQL(sql);
                    db.close();
                    Toast.makeText(mContext, "일기 저장 완료", Toast.LENGTH_SHORT).show();
                } else {
                    SQLiteDatabase db = helper.getWritableDatabase();
                    String sql = "update yjDiary set content="+edtDiary.getText().toString()+"where diaryDate="+fileName+";";
                    db.execSQL(sql);
                    db.close();
                    Toast.makeText(mContext, "일기 수정 완료", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return rootView;
    }

    private void checkedDay(int year, int monthOfYear, int dayOfMonth) {
        // 받은 날짜를 출력
        viewDatePick.setText(year + " - " + (monthOfYear + 1) + " - " + dayOfMonth);
    }

    // 일기 내용 출력
    public String readDiary(String fName) {

        String strDiary = null;

        SQLiteDatabase db = helper.getReadableDatabase();

        String sql = "select * from yjDiary where diaryDate="+fName+";";

        Cursor cursor = db.rawQuery(sql,null);

        if(cursor == null) {
            edtDiary.setHint("일기를 작성해 주세요");
            btnSave.setText("새일기저장");
        } else {
            strDiary = cursor.getString(1);
            btnSave.setText("수정하기");
        }
        cursor.close();
        db.close();
        return strDiary;
    }

}

