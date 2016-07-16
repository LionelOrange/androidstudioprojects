package com.example.chen.playvideotest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private VideoView videoView;
    private Button play;
    private Button pause;
    private Button replay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play=(Button) findViewById(R.id.play);
        pause=(Button) findViewById(R.id.pause);
        replay=(Button) findViewById(R.id.replay);
        videoView=(VideoView) findViewById(R.id.video_view);
        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        replay.setOnClickListener(this);
        initVideoPath();
    }
    private void initVideoPath(){
        videoView.setVideoPath("/storage/extSdCard/指针数组.wmv");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.play:
                if (!videoView.isPlaying()){
                    videoView.start();
                }
                break;
            case R.id.pause:
                if (videoView.isPlaying()){
                    videoView.pause();
                }
                break;
            case R.id.replay:
                if (videoView.isPlaying()){
                    videoView.resume();
                }
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (videoView!=null){
            videoView.suspend();
        }
    }
}
