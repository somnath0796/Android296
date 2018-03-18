package com.clubgeny.alarmclock;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import java.util.Calendar;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
   //set our variables
   java.util.Calendar calendar;
    AlarmManager alarm_manager;
    TimePicker alarm_timepicker;
    Button set, stop;
    Context context;
    TextView textup;
    PendingIntent alarmpintent;
    Intent alarmintent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.context = this;
        //intaialize our alarm manager
        alarm_manager = (AlarmManager)getSystemService(ALARM_SERVICE);
        //intaialize our timepicker
        alarm_timepicker = (TimePicker)findViewById(R.id.timePicker);
        //intaialize the text field
        textup = (TextView) findViewById(R.id.textView);
        //create and instance of calendar


            calendar = Calendar.getInstance();

        //intaialize the buttons
        set = (Button)findViewById(R.id.set);
        stop = (Button)findViewById(R.id.stop);

        //*create and intent
           alarmintent = new Intent(this.context, Alarm_Receiver.class);


        set.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                //setting calendar instance with the hour and minute that we picked
                //on the time picker


                    calendar.set(Calendar.HOUR_OF_DAY,alarm_timepicker.getHour());
                    calendar.set(Calendar.MINUTE,alarm_timepicker.getMinute());


                //get the string vale of the hour and minute


                int hour = 0;int minute = 0;

                    hour = alarm_timepicker.getHour();
                    minute = alarm_timepicker.getMinute();



                //convert the values to string
                String hour_string = String.valueOf(hour);
                String min_string = String.valueOf(minute);

                //convert 24 hour time to 12 hour time

                set_alarm_text("Alarm set to "  + hour_string+ ":" +min_string);





                //create a pending intetn until a specified calendar time
                alarmpintent = PendingIntent.getBroadcast(MainActivity.this,0,alarmintent, PendingIntent.FLAG_UPDATE_CURRENT);
                //set the alarm manager

                    alarm_manager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),alarmpintent);


            }

        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               set_alarm_text("Alarm off");
                //cancel the alarm
                alarm_manager.cancel(alarmpintent);

                sendBroadcast(alarmintent);
            }
        });

    }

    void set_alarm_text(String text)
    {
        textup.setText(text);
    }

    @Override
    public void onClick(View view) {

    }
}
