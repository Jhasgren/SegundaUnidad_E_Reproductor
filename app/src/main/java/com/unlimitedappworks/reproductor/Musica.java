package com.unlimitedappworks.reproductor;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import java.io.IOException;

/**
 * Created by Luis Fernando on 22/03/2016.
 */
public class Musica {
    private String recurso;
    private MediaPlayer mediaPlayer;

    public Musica(Context contexto, String recurso) {
        this.recurso = recurso;
        mediaPlayer = new MediaPlayer();
        try {
            AssetFileDescriptor fd = contexto.getAssets().openFd(recurso);
            mediaPlayer.setDataSource(fd.getFileDescriptor(), fd.getStartOffset(), fd.getLength());
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Musica play() {
        try {
            mediaPlayer.start();
        } catch (Exception e) {

        }
        return this;
    }

    public Musica pause() {
        try {
            mediaPlayer.pause();
        } catch (Exception e) {

        }
        return this;
    }

    public Musica stop() {
        try {
            mediaPlayer.stop();
        } catch (Exception e) {

        }
        return this;
    }

    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }
}