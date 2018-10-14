package com.study.android.myalarm02;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Vibrator;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class QuizDialogActivity extends AppCompatActivity implements View.OnClickListener, RecognitionListener {
    private static final String TAG = "lecture";

    private static final int REQUEST_CODE = 1000;
    final Context context = this;

    String[] rs;
    Vibrator vide;

    TextView tv_answer;
    String str = "내 이름은 코난 탐정이지";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();

        final View view = inflater.inflate(R.layout.quiz_dialog, null);

        final TextView txtTitle = view.findViewById(R.id.txtTitle);
        final EditText txtQuiz = view.findViewById(R.id.txtQuiz);
        final ImageView imageView = view.findViewById(R.id.imageView);
        tv_answer  = view.findViewById(R.id.tv_answer);
        final Button btnanswer = view.findViewById(R.id.btnAnswer);
        final Button btnexit = view.findViewById(R.id.btnClose);
        vide = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        alertDialogBuilder.setView(view);

        LinearLayout autolayout=view.findViewById(R.id.autolayout);
        autolayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        if(cb.isChecked()){
//                            cb.setChecked(false);
//                        }else if(!cb.isChecked()){
//                            cb.setChecked(true);
//                        }
                    }
                });
                btnexit.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        Log.d(TAG,"답은:" +str);
                        Log.d(TAG,"음성인식은:" +rs[0]);
                        if(str.equals(rs[0])) {
                            finish();
                        } else {
                            vide.vibrate(1000);
                        }
                    }
                });
                btnanswer.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {

                        try {
                            Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                            intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, getPackageName());
                            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "ko-KR");
                            intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "음성 검색");
                            intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 1);

                            startActivityForResult(intent, REQUEST_CODE);



                        } catch (ActivityNotFoundException e) {
                            Log.d(TAG, "ActivityNotFoundException");
                        }
                    }
                });

        // 다이얼로그 생성
        AlertDialog alertDialog = alertDialogBuilder.create();

        // 다이얼로그 보여주기
        alertDialog.show();
    }


    @Override
    public void onEndOfSpeech() {
    }

    @Override
    public void onReadyForSpeech(Bundle bundle) {
    }

    @Override
    public void onResults(Bundle results) {
        ArrayList<String> matches = results
                .getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);

        for(int i = 0; i <matches.size(); i++){
            str = str + matches.get(i) +"\n";
            Log.d(TAG, "onResults text : " + matches.get(i));
        }

      tv_answer.setText(str);
    }

    @Override
    public void onError(int errorCode) {
        String message;
        switch (errorCode) {
            case SpeechRecognizer.ERROR_AUDIO:
                message = "오디오 에러";
                break;
            case SpeechRecognizer.ERROR_CLIENT:
                message = "클라이언트 에러";
                break;
            case SpeechRecognizer.ERROR_INSUFFICIENT_PERMISSIONS:
                message = "퍼미션없음";
                break;
            case SpeechRecognizer.ERROR_NETWORK:
                message = "네트워크 에러";
                break;
            case SpeechRecognizer.ERROR_NETWORK_TIMEOUT:
                message = "네트워크 타임아웃";
                break;
            case SpeechRecognizer.ERROR_NO_MATCH:
                message = "찾을수 없음";
                break;
            case SpeechRecognizer.ERROR_RECOGNIZER_BUSY:
                message = "BUSY";
                break;
            case SpeechRecognizer.ERROR_SERVER:
                message = "서버이상";
                break;
            case SpeechRecognizer.ERROR_SPEECH_TIMEOUT:
                message = "시간초과";
                break;
            default:
                message = "알수없음";
                break;
        }
        Log.d(TAG,"SPEECH ERROR : " + message);
    }

    @Override
    public void onRmsChanged(float v) {
    }

    @Override
    public void onBeginningOfSpeech() {
    }

    @Override
    public void onEvent(int i, Bundle bundle) {
    }

    @Override
    public void onPartialResults(Bundle bundle) {
    }

    @Override
    public void onBufferReceived(byte[] bytes) {
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQUEST_CODE : {
                if(resultCode == RESULT_OK && null != data) {
                    ArrayList<String> text = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    rs = new String[text.size()];
                    text.toArray(rs);

                    Log.d(TAG, "말 : " + rs[0]);
                    tv_answer.setText(rs[0]);

                } break;
            }
        }
    }

    @Override
    public void onClick(View v) {

    }

}


