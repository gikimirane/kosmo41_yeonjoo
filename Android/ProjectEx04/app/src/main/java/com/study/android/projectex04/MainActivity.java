package com.study.android.projectex04;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Environment;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    public static final String ALARM_TYPE = "ALARM_TYPE";

    public static final String ALARM_TYPE_ONE_TIME = "ALARM_TYPE_ONE_TIME";

    public static final String ALARM_TYPE_REPEAT = "ALARM_TYPE_REPEAT";

    public static final String ALARM_DESCRIPTION = "ALARM_DESCRIPTION";

    private AlarmManager alarmManager = null;

    private PendingIntent pendingIntent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // setTitle("타이틀"); 타이틀 작성

        // 알람 매니저 객체를 가져옴
        alarmManager = (AlarmManager)getApplicationContext().getSystemService(Context.ALARM_SERVICE);

        // 클릭 후 5초 후에 알람이 울리도록 설정
        Button startOneTimeAlarmButton = (Button)findViewById(R.id.alarm_start_one_time_button);
        startOneTimeAlarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // 오픈 인텐트를 만들고
                Intent intent = new Intent(getApplicationContext(), AlarmTriggerActivity.class);
                // 알람 타입을 만들고
                intent.putExtra(ALARM_TYPE, ALARM_TYPE_ONE_TIME);
                // 부가설명 문자열을 만듬
                intent.putExtra(ALARM_DESCRIPTION, "단일 알람을 시작합니다.");
                // 나중에 사용할 수 있도록 Intent 객체를 래핑하여 MainActivity를 시작
                pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, 0);
                // 5초 후에 알람이 울리도록 설정
                long alarmTriggerTime = System.currentTimeMillis() + 5000;
                alarmManager.set(AlarmManager.RTC_WAKEUP, alarmTriggerTime, pendingIntent);

                Toast.makeText(getApplicationContext(), "A one time alarm has been created, it will be triggered after 5 seconds. This alarm will open another activity.", Toast.LENGTH_LONG).show();
            }
        });

        // Click this button to start a repeated alarm, it will execute every interval seconds to invoke a service.
        Button startRepeatServiceAlarmButton = (Button)findViewById(R.id.alarm_start_repeat_service_button);
        startRepeatServiceAlarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AlarmTriggerService.class);
                intent.putExtra(ALARM_TYPE, ALARM_TYPE_REPEAT);
                intent.putExtra(ALARM_DESCRIPTION, "Repeat alarm start this service.");
                pendingIntent = PendingIntent.getService(getApplicationContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                long alarmStartTime = System.currentTimeMillis();
                long alarmExecuteInterval = 90*1000;

                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, alarmStartTime, alarmExecuteInterval, pendingIntent);

                Toast.makeText(getApplicationContext(), "A repeat alarm has been created. This alarm will open a service.", Toast.LENGTH_LONG).show();
            }
        });

        // Click this button to start a repeated alarm, it will execute every interval seconds to send a broadcast.
        Button startRepeatBroadcastAlarmButton = (Button)findViewById(R.id.alarm_start_repeat_broadcast_button);
        startRepeatBroadcastAlarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AlarmReceiver.class);
                intent.putExtra(ALARM_TYPE, ALARM_TYPE_REPEAT);
                intent.putExtra(ALARM_DESCRIPTION, "Repeat alarm start this broadcast.");
                pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                long alarmStartTime = System.currentTimeMillis();
                // This is too short, it will be expanded by android os to 60 seconds by default.
                long alarmExecuteInterval = 10*1000;
                alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, alarmStartTime, alarmExecuteInterval, pendingIntent);

                Toast.makeText(getApplicationContext(), "A repeat alarm has been created. This alarm will send to a broadcast receiver.", Toast.LENGTH_LONG).show();
            }
        });

        // Click this button to cancel current pendingIntent related alarm.
        Button cancelRepeatAlarmButton = (Button)findViewById(R.id.alarm_cancel_repeat_button);
        cancelRepeatAlarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alarmManager.cancel(pendingIntent);
                Toast.makeText(MainActivity.this, "Cancel current alarm.", Toast.LENGTH_LONG).show();
            }
        });

    }
}