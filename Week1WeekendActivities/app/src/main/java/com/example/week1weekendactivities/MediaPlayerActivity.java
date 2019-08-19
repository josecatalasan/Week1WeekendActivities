package com.example.week1weekendactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MediaPlayerActivity extends AppCompatActivity {
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player);

    }

    public void play(View view){
        if(player == null){
            player = MediaPlayer.create(this, R.raw.song);
            player.setVolume(1,1);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    stopPlayer();
                }
            });
        }
        player.start();
    }

    public void pause(View view){
        if(player != null){
            player.pause();
        }

    }

    public void stop(View view){
        stopPlayer();
    }

    private void stopPlayer(){
        if(player != null){
            player.release();
            player = null;
            Toast.makeText(this, "MediaPlayer released", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopPlayer();
    }
}
