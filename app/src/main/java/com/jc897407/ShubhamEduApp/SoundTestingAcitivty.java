package com.jc897407.ShubhamEduApp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.jc897407.ShubhamEduApp.helper.SoundManager;

public class SoundTestingAcitivty extends AppCompatActivity {

    private SoundManager soundManager;
    private int marimbaSoundID;
    private int merengueSoundID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_testing);
        soundManager = new SoundManager(this);
//        Button btnMarimba = findViewById(R.id.btnMarimba);
//        Button btnMerengue = findViewById(R.id.btnMerengue);
        //if you have to load many songs then load them in another thread
        marimbaSoundID = soundManager.addSound(R.raw.marimba);
        merengueSoundID = soundManager.addSound(R.raw.merengue);
    }

    public void buttonClicked(View view) {
        Button b = (Button) view;
        String btnText = b.getText().toString();
        if (btnText.equals("MARIMBA")) {
            soundManager.play(marimbaSoundID, 2);
        }
        else {
            soundManager.play(merengueSoundID, 2);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(soundManager != null){
            soundManager.releaseSoundPool();
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(soundManager != null){
            soundManager.releaseSoundPool();
        }
    }


}