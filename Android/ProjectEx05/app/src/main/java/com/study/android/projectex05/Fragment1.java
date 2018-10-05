package com.study.android.projectex05;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static android.content.Context.ALARM_SERVICE;

public class Fragment1 extends Fragment {
    private static final String TAG = "lecture";

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView =
                (ViewGroup) inflater.inflate(R.layout.fragment1,container, false);

        Button button = rootView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.d(TAG,"Fragment1");
            }
        });

        return rootView;
    }

    //시간 설정을 위한 객체
    Calendar Time;

    //알람 설정을 위한 객체
    private Intent intent;
    private AlarmManager alarmManager;
    private PendingIntent ServicePending;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 mm분 ss초");

    TextView textView;

    DatePickerDialog.OnDateSetListener
            eDateSetListener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet
                (DatePicker view, int year, int monthOfYear, int dayOfMonth) {

            Time.set(Calendar.YEAR,year);
            Time.set(Calendar.MONTH,monthOfYear);
            Time.set(Calendar.DAY_OF_MONTH,dayOfMonth);

            updateLabel();

        }
    };

    private TimePickerDialog.OnTimeSetListener sTimeSetListener =
            new TimePickerDialog.OnTimeSetListener() {

                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                    Time.set(Calendar.HOUR_OF_DAY,hourOfDay);
                    Log.d("check","1 = " + hourOfDay);
                    Time.set(Calendar.MINUTE,minute);
                    Log.d("check","2 = " + minute);
                    Time.set(Calendar.SECOND, 0);

                    updateLabel();
                }
            };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
                | WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD
                | WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON
                | WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);

        //타임 피커, 데이트 피커 리스너 및 아이디 등록
        Time = Calendar.getInstance();

        //알람 설정, 해제 버튼
        Button.OnClickListener bClickListener = new View.OnClickListener() {

            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.setAlarm:

                        setAlarm();
                        break;

                    case R.id.removeAlarm:

                        removeAlarm();
                        break;

                    case R.id.button:
                        new TimePickerDialog(Fragment1.this, sTimeSetListener,
                                Time.get(Calendar.HOUR_OF_DAY), Time.get(Calendar.MINUTE), false).show();

                        new DatePickerDialog(Fragment1.this, eDateSetListener,
                                Time.get(Calendar.YEAR), Time.get(Calendar.MONTH), Time.get(Calendar.DAY_OF_MONTH)).show();
                        break;

                    case R.id.repeatAlarm:

                        setRepeatAlarm();
                        break;

                }
            }
        };

        rootView.findViewById(R.id.setAlarm).setOnClickListener(bClickListener);
        rootView.findViewById(R.id.removeAlarm).setOnClickListener(bClickListener);
        rootView.findViewById(R.id.button).setOnClickListener(bClickListener);
        rootView.findViewById(R.id.repeatAlarm).setOnClickListener(bClickListener);

        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        textView = rootView.findViewById(R.id.textView);

        updateLabel();
    }

    private void updateLabel() {
        textView.setText(simpleDateFormat.format(Time.getTime()));
    }

    void setAlarm() {
        //Receiver로 보내기 위한 인텐트
        //intent = new Intent(this, AlarmReceiver.class);
        intent = new Intent("AlarmReceiver");
        //PendingIntent.getBroadcast(Context context, int requestCod, Intent intent int flag);

        ServicePending = PendingIntent.getBroadcast(
                Fragment1.this, 111, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        //정해진 시간에 알람 설정
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Time.getTimeInMillis(), 1000, ServicePending);
        //alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Time.getTimeInMillis(), 1000, ServicePending);

        //Millis * Second * Minute

        Toast.makeText(getBaseContext(), "알람 설정" + Time.getTime(), Toast.LENGTH_SHORT).show();

    }

    void removeAlarm() {

        intent = new Intent("AlarmReceiver");
        //PendingIntent.getBroadcast(Context context, int requestCod, Intent intent, int flag);

        ServicePending = PendingIntent.getBroadcast(
                Fragment1.this, 111, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        Toast.makeText(getBaseContext(), "알람 해제" + Time.getTime(), Toast.LENGTH_SHORT).show();

        alarmManager.cancel(ServicePending);
    }

    void setRepeatAlarm() {
        //Receiver로 보내기 위한 인텐트
        //intent = new Intent(this, AlarmReceiver.class);
        intent = new Intent("AlarmReceiver");
        //PendingIntent.getBroadcast(Context context, int requestCod, Intent intent int flag);

        ServicePending = PendingIntent.getBroadcast(
                Fragment1.this, 111, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        Log.d("ServicePending : ", "" + ServicePending.toString());

        //정해진 시간에 알림 설정
        // alarmManager.set(AlarmManager.RTC_WAKEUP,Time.getTimeInMillis(),servicePending);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Time.getTimeInMillis(), 20000, ServicePending);
        //Millis * Second * Minute

        Toast.makeText(getBaseContext(), "알람 설정" + Time.getTime(), Toast.LENGTH_SHORT).show();

    }

}
