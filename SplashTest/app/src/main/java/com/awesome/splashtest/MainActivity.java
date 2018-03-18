package com.awesome.splashtest;

import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    ViewGroup myLayout;
    TextToSpeech t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            TransitionManager.beginDelayedTransition(myLayout);
        }
        myLayout = (RelativeLayout)findViewById(R.id.main_view);


        t1 =  new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {

            @Override
            public void onInit(int status) {
                String seek ="lala";
                if(status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.UK);
                }

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                    t1.speak("Hii There, I'm Geek!", t1.QUEUE_FLUSH, null, seek + "jj");
            }
        });

    }
}
