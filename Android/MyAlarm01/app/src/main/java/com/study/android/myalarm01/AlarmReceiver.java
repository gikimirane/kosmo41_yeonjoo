package com.study.android.myalarm01;


import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {

    Toast mToast;
    alarmmanager AActivity = (alarmmanager) this.AActivity;

    @Override
    public void onReceive(Context context, Intent intent) {

        mToast = Toast.makeText(context, "현재 시간:" + DefineClass.mTime
                + "분 지났습니다.", Toast.LENGTH_SHORT);

        if (DefineClass.mTime < 10) {
            DefineClass.mTime = DefineClass.mTime + 1;
            // Log.d("define", ""+DefineClass.mTime);
            mToast.show();
        } else {
            Toast.makeText(context,
                    "현재 시간:" + DefineClass.mTime + "분 지났습니다. 알람을 종료합니다.",
                    Toast.LENGTH_SHORT).show();

            // Log.d("test", "멈추자");

            /*
             * Intent go = new Intent(context, alarmmanager.class);
             *
             * go.putExtra("STR", "A1");
             * intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
             * context.startActivity(go);
             */

            // 펜딩인텐트를 send형식으로 보내서 성공했다.
            Intent go = new Intent(context, alarmmanager.class);

            go.putExtra("STR", "A1");
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0,
                    go, 0);

            try {
                pendingIntent.send();
            } catch (PendingIntent.CanceledException e) {
                e.printStackTrace();
            }

            //아래에 있는 프로세스킬이라던지 시스템 exit, finish부분은
            //프로그램만 종료가 된다.
            // System.exit(0);
            // android.os.Process.killProcess(android.os.Process.myPid());
            // finish();

        }

    }
}