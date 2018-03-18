package com.awesome.texttospeech;

import android.os.Build;
import android.support.v4.app.BundleCompat;
import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.hardware.SensorManager;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import java.util.List;
import java.util.Locale;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {

    EditText ed1;
    TextToSpeech t1;
    Button b1;

    String seek = "MyText";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = (EditText)findViewById(R.id.Text_speech);
        b1 = (Button) findViewById(R.id.button);

       t1 =  new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {

            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.UK);
                }

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                    t1.speak("Hii, Let's Talk!", t1.QUEUE_FLUSH, null, seek + "jj");
            }
        });



        b1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String toSpeak = ed1.getText().toString();
                Toast.makeText(getApplicationContext(),toSpeak,Toast.LENGTH_SHORT).show();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    t1.speak(toSpeak,t1.QUEUE_FLUSH, null,seek);
                }
            }
        });
    }

    public void onPause(){
        if(t1 !=null){
            t1.stop();
            t1.shutdown();
        }
        super.onPause();
    }



}
