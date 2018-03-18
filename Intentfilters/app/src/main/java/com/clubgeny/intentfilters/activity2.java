package com.clubgeny.intentfilters;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class activity2 extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "ACTIVITY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);

        TextView t1 = (TextView)findViewById(R.id.textView);
        Button b1 = (Button)findViewById(R.id.button1);
        Bundle data = getIntent().getExtras();
        String message = data.getString("text");

        t1.setText(message);

        b1.setOnClickListener(this);





    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "ACT 2 : STARTED ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "ACT 2 : STOPPED ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "ACT 2 : DESTROYED ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "ACT 2 : PAUSED ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "ACT 2 : RESUMED ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "ACT 2 : RESTARTED ");
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        intent = new Intent(this,MainActivity.class);
        intent.putExtra("text","hi i am from ACTIVITY 2");
        startActivity(intent);
    }
}
