package com.clubgeny.alarmclock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Iyappan on 7/30/2016.
 */
public class Alarm_Receiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {



       //create and intent to the ringtone service
        Intent service_intent = new Intent(context,TexttoSpeech.class);
       //start service

        context.startService(service_intent);
    }
}
