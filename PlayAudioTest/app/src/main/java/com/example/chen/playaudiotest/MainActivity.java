package com.example.chen.playaudiotest;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button play;
    private Button pause;
    private Button stop;
    private MediaPlayer mediaPlayer=new MediaPlayer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play=(Button) findViewById(R.id.play);
        pause=(Button) findViewById(R.id.pause);
        stop=(Button) findViewById(R.id.stop);
        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);
        initMediaPlayer();
/*        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mediaPlayer.setDataSource("/storage/extSdCard/music.mp3");
                    mediaPlayer.prepare();
                    mediaPlayer.start();
                }catch (IllegalArgumentException e){
                    e.printStackTrace();
                }catch (IllegalStateException e){
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer!=null){
                    mediaPlayer.pause();
                }
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer!=null){
                    mediaPlayer.stop();
                }
            }
        });*/
    }
    private  void initMediaPlayer(){
        try {
            mediaPlayer.setDataSource("/storage/extSdCard/music.mp3");
            mediaPlayer.prepare();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mediaPlayer!=null){
            mediaPlayer.stop();
            mediaPlayer.release();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.play:
                if (!mediaPlayer.isPlaying()){
                    mediaPlayer.start();
                }
                break;
            case R.id.pause:
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                }
                break;
            case R.id.stop:
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.reset();
                    initMediaPlayer();
                }
                break;
            default:
                break;
        }
    }
}
