package com.study.android.myalarm02;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import static android.content.Context.ALARM_SERVICE;

public class Fragment1 extends Fragment {
    private static final String TAG = "lecture";

    AlarmManager alarm_manager;
    TimePicker alarm_timepicker;
    Context context;
    PendingIntent pendingIntent;


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView =
                (ViewGroup) inflater.inflate(R.layout.fragment1, container, false);

        context = container.getContext();

        // 알람매니저 설정
        alarm_manager = (AlarmManager) context.getSystemService(ALARM_SERVICE);

        // 타임피커 설정
        alarm_timepicker = rootView.findViewById(R.id.time_picker);

        // Calendar 객체 생성
        final Calendar calendar = Calendar.getInstance();

        // 알람리시버 intent 생성
        final Intent my_intent = new Intent(this.context, Alarm_Receiver.class);

        // 알람 시작 버튼
        Button alarm_on = rootView.findViewById(R.id.btn_start);

        alarm_on.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {

                // 캘린더에 시간을 셋팅
                calendar.set(Calendar.HOUR_OF_DAY, alarm_timepicker.getHour());
                calendar.set(Calendar.MINUTE, alarm_timepicker.getMinute());
                calendar.set(Calendar.SECOND, 0);

                // 시간을 가져온다
                int hour = alarm_timepicker.getHour();
                int minute = alarm_timepicker.getMinute();
                Toast.makeText(context, "Alarm 예정 " + hour + "시 " + minute + "분", Toast.LENGTH_SHORT).show();

                // 리시버에 값을 넘겨준다
                my_intent.putExtra("state", "alarm on");

                pendingIntent = PendingIntent.getBroadcast(context, 0, my_intent,
                        PendingIntent.FLAG_UPDATE_CURRENT);

                // 알람을 세팅한다
                alarm_manager.setAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                        pendingIntent);

            }
        });



        // 알람 끄기 버튼
        Button alarm_off = rootView.findViewById(R.id.btn_finish);
        alarm_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Alarm 종료",Toast.LENGTH_SHORT).show();
                // 알람매니저를 종료
                alarm_manager.cancel(pendingIntent);

                my_intent.putExtra("state","alarm off");

                // 알람을 취소
                context.sendBroadcast(my_intent);

            }
        });

        return rootView;
    }

}
