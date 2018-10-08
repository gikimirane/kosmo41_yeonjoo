package com.study.android.projectex2;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class VolumeTest extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    Spinner spn;

    MediaPlayer mAudio = null;
    boolean isPlay = false;

    int StreamType = 0;

    Button btnPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume_test);

        // Spinner -->
        spn = (Spinner)findViewById(R.id.Spinner01);
        ArrayAdapter<charsequence> adapter = ArrayAdapter.createFromResource(this, R.array.UserList, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spn.setAdapter(adapter);
        spn.setOnItemSelectedListener(this);
        // <-- Spinner

        btnPlay = (Button) findViewById(R.id.Button01);

        btnPlay.setOnClickListener(this);

    }

    public void PlayTest()
    {
        try{
            mAudio = new MediaPlayer();
            // 디바이스에 설정된 벨소리를 사용할 때
            //Uri alert = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
            //Log.d("URI", "Ringtone URI : " + alert.toString()); // content://settings/system/ringtone
            //mAudio.setDataSource(alert.toString());
            // 벨소리로 재생 할 음원 파일 패스
            String path = "/system/media/audio/ringtones/Red_Beats.ogg";
            mAudio.setDataSource(path);;

            // 벨소리
            //mAudio.setAudioStreamType(AudioManager.STREAM_RING);
            // 미디어
            //mAudio.setAudioStreamType(AudioManager.STREAM_MUSIC);
            // 전화(수신 스피커)
            //mAudio.setAudioStreamType(AudioManager.STREAM_VOICE_CALL);

            // Spinner에서 설정한 스트리밍 타입
            mAudio.setAudioStreamType(StreamType);

            mAudio.setLooping(true);
            mAudio.prepare();
        }
        catch (Exception e) {

        }

        mAudio.start();

        isPlay = true;



    }
    public void StopTest()
    {
        if(mAudio.isPlaying())
        {
            mAudio.stop();
            isPlay = false;
        }
        else
        {
            // not playing
        }
    }

    @Override
    public void onItemSelected(AdapterView arg0, View arg1, int arg2,
                               long arg3) {
        switch(arg2)
        {
            case 0:
            {
                StreamType = AudioManager.STREAM_RING;
                break;
            }
            case 1:
            {
                StreamType = AudioManager.STREAM_MUSIC;
                break;
            }
            case 2:
            {
                StreamType = AudioManager.STREAM_VOICE_CALL;
                break;
            }
        }
        // TODO Auto-generated method stub

    }

    @Override
    public void onNothingSelected(AdapterView arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onClick(View arg0) {
        // TODO Auto-generated method stub
        switch(arg0.getId())
        {
            case R.id.Button01:
            {
                Log.d("BTN", "PLAY/STOP");
                if(!isPlay)
                {
                    PlayTest();
                }
                else
                {
                    StopTest();
                }

                break;
            }
        }
    }
}
