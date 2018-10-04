package com.study.android.projectex2;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.TextView;

public class removeActivity extends Activity {
    private static final String TAG = "lecture";

    private Intent intent;
    private PendingIntent ServicePending;
    private AlarmManager alarmManager;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove);

        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.shinhwa);
        mediaPlayer.start();



    }
}
