package com.awesome.namechanger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b1 = (Button)findViewById(R.id.Button);

        if (b1 != null) {
            b1.setOnClickListener(
                    new Button.OnClickListener(){

                        @Override
                        public void onClick(View v) {
                            TextView tv =  (TextView)findViewById(R.id.onScreenText);
                            tv.setText("Potato");
                        }
                    }
            );
            b1.setOnLongClickListener(
                    new Button.OnLongClickListener(){

                        @Override
                        public boolean onLongClick(View v) {
                            TextView tv =  (TextView)findViewById(R.id.onScreenText);
                            tv.setText("Pooooootaaaatooooooooo");
                            return false;
                        }
                    }
            );
        }



    }
}
