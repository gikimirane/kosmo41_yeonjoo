package com.study.android.projectex1;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "lecture";


    AlarmManager am;
    Intent intent;
    PendingIntent receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        am = (AlarmManager)getSystemService(Context.ALARM_SERVICE);

    intent = new Intent(this, AlarmReceiver.class);
    receiver =PendingIntent.getBroadcast(this,
            0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
}

    public void onBtn1Clicked(View v) {
        //알람시간. 60초 후
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.add(Calendar.SECOND, 10);

        //알람등록
        am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),receiver);
    }

    public void onBtn2Clicked(View v) {
        //10초당 한번 알람 등록 : 24 * 60 * 60 * 1000
        am.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                SystemClock.elapsedRealtime(),
                10 * 1000, receiver);
    }

    public void onBtn3Clicked(View v) {
        am.cancel(receiver);
    }

}

}
