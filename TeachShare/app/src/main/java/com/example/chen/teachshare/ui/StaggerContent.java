package com.example.chen.teachshare.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import com.example.chen.teachshare.R;


/**
 * Created by Administrator on 2016/5/27.
 */
public class StaggerContent extends Activity implements View.OnClickListener {
    private VideoView videoView;
    private Button play;
    private Button pause;
    private Button replay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stagget_content);
        play = (Button) findViewById(R.id.play);
        pause = (Button) findViewById(R.id.pause);
        replay = (Button) findViewById(R.id.replay);
        videoView = (VideoView) findViewById(R.id.video_view);
        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        replay.setOnClickListener(this);
        initVideoPath();
    }

    private void initVideoPath() {
        Intent intent = getIntent();
        int type=intent.getIntExtra("TYPE",1);
        switch (type){//"/storage/extSdCard/交换.mp4"
            case 0:
                videoView.setVideoPath("/storage/emulated/0/指针数组.3gp");
                break;
            case 1:
                videoView.setVideoPath("/storage/emulated/0/交换.mp4");
                break;
            case 2:
                videoView.setVideoPath("/storage/emulated/0/auto.mp4");
                break;
                default:
                    videoView.setVideoPath("/storage/emulated/0/函数.mp4");
                    break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play:
                if (!videoView.isPlaying()) {
                    videoView.start();
                }
                break;
            case R.id.pause:
                if (videoView.isPlaying()) {
                    videoView.pause();
                }
                break;
            case R.id.replay:
                if (videoView.isPlaying()) {
                    videoView.resume();
                }
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (videoView != null) {
            videoView.suspend();
        }
    }
}
