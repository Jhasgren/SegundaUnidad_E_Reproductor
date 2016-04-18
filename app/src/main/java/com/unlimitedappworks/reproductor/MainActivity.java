package com.unlimitedappworks.reproductor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.MediaController;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    Musica musica;
    MediaController mc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        musica = new Musica(this, "song2.mp3");
        musica.play();

        mc = new MediaController(this);
        mc.setMediaPlayer(new MediaController.MediaPlayerControl() {
            @Override
            public void start() {
                musica.play();
            }

            @Override
            public void pause() {
                musica.pause();
            }

            @Override
            public int getDuration() {
                return musica.getMediaPlayer().getDuration();
            }

            @Override
            public int getCurrentPosition() {
                return musica.getMediaPlayer().getCurrentPosition();
            }

            @Override
            public void seekTo(int pos) {
                musica.getMediaPlayer().seekTo(pos);
            }

            @Override
            public boolean isPlaying() {
                return musica.getMediaPlayer().isPlaying();
            }

            @Override
            public int getBufferPercentage() {
                return 100;
            }

            @Override
            public boolean canPause() {
                return true;
            }

            @Override
            public boolean canSeekBackward() {
                return true;
            }

            @Override
            public boolean canSeekForward() {
                return true;
            }

            @Override
            public int getAudioSessionId() {
                return musica.getMediaPlayer().getAudioSessionId();
            }
        });
        RelativeLayout rl = (RelativeLayout) findViewById(R.id.rl_main);
        mc.setAnchorView(rl);
    }

    public void click(View v){
        musica.stop();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mc.show();
        return super.onTouchEvent(event);
    }
}
