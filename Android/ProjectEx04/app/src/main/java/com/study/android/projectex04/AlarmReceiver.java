package com.study.android.projectex04;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.icu.util.Calendar;
import android.media.MediaPlayer;
import android.util.Log;
import android.widget.Toast;

import java.io.File;

public class AlarmReceiver extends BroadcastReceiver {

    private final static String TAG_ALARM_TRIGGER_BROADCAST = "ALARM_TRIGGER_BROADCAST";

    @Override
    public void onReceive(Context context, Intent intent) {
        String alarmType = intent.getStringExtra(MainActivity.ALARM_TYPE);

        String alarmDescription = intent.getStringExtra(MainActivity.ALARM_DESCRIPTION);

        Log.d(TAG_ALARM_TRIGGER_BROADCAST, alarmDescription);

        Toast.makeText(context, alarmDescription, Toast.LENGTH_LONG).show();

    }
}