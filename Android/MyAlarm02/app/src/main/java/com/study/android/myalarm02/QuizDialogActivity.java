package com.study.android.myalarm02;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class QuizDialogActivity extends AppCompatActivity implements View.OnClickListener {

    final Context context = this;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
      //  View view = inflater.inflate(R.layout.quiz_dialog, null);

// 제목셋팅
        alertDialogBuilder.setTitle("오늘의 QUIZ");

        // AlertDialog 셋팅
        alertDialogBuilder
                .setMessage("넌 정체가 뭐냐?")
                .setCancelable(false)
                .setPositiveButton("내이름은..",
                        new DialogInterface.OnClickListener() {
                            public void onClick(
                                    DialogInterface dialog, int answerId) {
                                //여기 값을 메인으로 넘기기기


                            }
                        })
                .setNegativeButton("귀찮아!",
                        new DialogInterface.OnClickListener() {
                            public void onClick(
                                    DialogInterface dialog, int id) {
                                //QuizDialogActivity.this.finish();
                                //finishAffinity();

                                Intent intent11 = new Intent(getApplicationContext(), RingtonePlayingService.class);
                                stopService(intent11);

                                onDestroy();

                            }
                        });

//            alertDialogBuilder.setView(view)
//                              .setCancelable(true)
//                              .setNegativeButton("No", new DialogInterface.OnClickListener() {
//                                 public void onClick(DialogInterface dialog, int id){
//                                     dialog.cancel();
//                                }
//                            })
//                              .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                                 @Override
//                                 public void onClick(DialogInterface dialog, int id) {
//                                     dialog.cancel();
//                                 }
//                           });
        // 다이얼로그 생성
        AlertDialog alertDialog = alertDialogBuilder.create();

        // 다이얼로그 보여주기
        alertDialog.show();
    }

   @Override
    public void onClick(View v) {

    }
}


