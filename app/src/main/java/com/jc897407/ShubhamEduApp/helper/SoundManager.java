package com.jc897407.ShubhamEduApp.helper;

import android.content.Context;
import android.media.SoundPool;

public class SoundManager {
    private SoundPool pool;
    private final Context context;

    // Constructor
    public SoundManager(Context context){
        this.context = context;
        SoundPool.Builder builder = new SoundPool.Builder();
        builder.setMaxStreams(1);
        pool = builder.build();
    }

    // Load the sound file
    public int addSound(int resourceID){
        return pool.load(context, resourceID, 1);
    }

    // Use soundID o play the audio
    public void play(int soundID, float rate){
        //rate: from 0.5 to 2.0
        //play(int soundID, float leftVolume, float rightVolume, int priority, int loop, float rate)
        pool.play(soundID, 1, 1, 1, 0, rate); // loop 0: play 1 time, loop 2: repeat 2 times
        // volume: set it on 1 to play it on default
    }


    public void releaseSoundPool(){
        if (pool != null){
            pool.release();
            pool = null;
        }
    }
}
