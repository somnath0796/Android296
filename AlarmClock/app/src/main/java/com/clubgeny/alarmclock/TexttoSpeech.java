package com.clubgeny.alarmclock;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import java.util.Locale;




public class TexttoSpeech extends Service {
    @Nullable
    String seek = "MyText";
     TextToSpeech t1;

    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override


    public void onDestroy() { t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {


        public void onInit(int status) {
            int result=0;
            if(status != TextToSpeech.ERROR) {
                result = t1.setLanguage(Locale.UK);
            }
            if (status == TextToSpeech.SUCCESS) {
                    speakOut();

            } else {
                Log.e("TTS", "Initilization Failed!");
            }
        }
    });

    }

    @Override
    public int onStartCommand(Intent intent, int flags, final int startId) {
        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {


               public void onInit(int status) {
                   int result=0;
                   if(status != TextToSpeech.ERROR) {
                       result = t1.setLanguage(Locale.UK);
                   }
                   if (status == TextToSpeech.SUCCESS) {
                       speakOut();

                   } else {
                       Log.e("TTS", "Initilization Failed!");
                   }
            }
        });



                return START_NOT_STICKY;
    }

    private void speakOut() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            t1.speak("Wake up Homies!", t1.QUEUE_FLUSH, null, seek + "jj");
        Toast.makeText(this,"Work",Toast.LENGTH_SHORT).show();
    }
}

