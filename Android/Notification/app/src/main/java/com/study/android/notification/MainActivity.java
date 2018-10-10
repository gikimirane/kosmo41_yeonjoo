package com.study.android.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    //각 알림을 식별하는 점수
    public static final int NOTIFICATION_ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        String channelId = "channel";
        String channelName = "Channel Name";
        int importance = NotificationManager.IMPORTANCE_HIGH;

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel mChannel = new NotificationChannel(
                    channelId, channelName, importance);

            mNotificationManager.createNotificationChannel(mChannel);

        }


    }

    public void sendNotification(View view) {

        String channelId = "channel";
        String channelName = "Channel Name";

        NotificationManager notifManager

                = (NotificationManager) getSystemService  (Context.NOTIFICATION_SERVICE);


        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {

            int importance = NotificationManager.IMPORTANCE_HIGH;

            NotificationChannel mChannel = new NotificationChannel(
                    channelId, channelName, importance);

            notifManager.createNotificationChannel(mChannel);

        }

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(getApplicationContext(), channelId);

        Intent notificationIntent = new Intent(getApplicationContext()

                , MainActivity.class);

        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                Intent.FLAG_ACTIVITY_SINGLE_TOP);

        int requestID = (int) System.currentTimeMillis();

        PendingIntent pendingIntent
                = PendingIntent.getActivity(getApplicationContext()

                , requestID

                , notificationIntent

                , PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setContentTitle("Title") // required
                .setContentText("Content")  // required
                .setDefaults(Notification.DEFAULT_ALL) // 알림, 사운드 진동 설정
                .setAutoCancel(true) // 알림 터치시 반응 후 삭제

                .setSound(RingtoneManager

                        .getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))

                .setSmallIcon(android.R.drawable.btn_star)
                .setLargeIcon(BitmapFactory.decodeResource(getResources()

                        , android.R.drawable.btn_star))
                .setBadgeIconType(android.R.drawable.btn_star)

                .setContentIntent(pendingIntent);

        notifManager.notify(0, builder.build());
    }
}
