package com.study.android.myalarm01;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.SystemClock;
import android.os.Bundle;
import android.widget.Toast;

import com.study.android.projectex1.R;

import java.text.SimpleDateFormat;

public class alarmmanager extends Activity {
    Toast mToast;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // AlarmReceiver.class에서 go.putExtra로 보낸 데이터를 intents에 getIntent();시킨다.
        Intent intents = getIntent();
        String data = intents.getStringExtra("STR");

        long firstTime = SystemClock.elapsedRealtime();
        firstTime += 1 * 1000;

        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);

        // AlarmReceiver.class로 값을 보내기위한 intent 변수
        Intent intent = new Intent(alarmmanager.this, AlarmReceiver.class);
        PendingIntent sender = PendingIntent.getBroadcast(this, 0, intent, 0);

        //플래그-업데이트 부분을 받은 펜딩인텐트 변수
        PendingIntent pi = PendingIntent.getBroadcast(this, 0, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        //처음 시작할때 AlarmReceiver.class에서 data의 값이 넘어오지 않기 때문에
        //else부분부터 먼저 시작한다.
        //펜딩센드로 받아오면 그때부턴 data부분이 null이 아니기 때문에 am.cancel을
        //실행한다.
        if (data != null) {
            if (data.equals("A1")) {
                am.cancel(pi);
            }
        } else {
            am.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, firstTime,
                    5 * 1000, sender);
        }
        /*
         * if (mToast != null) { mToast.cancel();
         */

    }

}