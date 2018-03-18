package com.clubgeny.intentfilters;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
      private static final String TAG = "ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button act2 = (Button)findViewById(R.id.b1);
        Button act3 = (Button)findViewById(R.id.b2);
        Button act4 = (Button)findViewById(R.id.b3);
        act2.setOnClickListener(this);
        act3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                Intent intent2 = new Intent();
                intent2.setClassName("com.clubgeny.currencyconvertor","com.clubgeny.currencyconvertor.MainActivity");
                startActivity(intent2);

            }
        });

        act4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com"));
                startActivity(intent3);

            }
        });



    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "ACT 1 : STARTED ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "ACT 1 : STOPPED ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "ACT 1 : DESTROYED ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "ACT 1 : PAUSED ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "ACT 1 : RESUMED ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "ACT 1 : RESTARTED ");
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        intent = new Intent(this,activity2.class);
        intent.putExtra("text","hi i am from ACTIVITY 1");
        startActivity(intent);
    }
}
