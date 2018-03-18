package com.awesome.dynamicui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.Button;
import android.widget.EditText;
import android.graphics.Color;
import android.content.res.Resources;
import android.util.TypedValue;

public class MainActivity extends AppCompatActivity {

    //Pixel converter
    public int toPix(int dip){
        Resources r = getResources();
        int px = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,dip, r.getDisplayMetrics() );

        return px;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        //Layout
        RelativeLayout somsLayout = new RelativeLayout(this);
        somsLayout.setBackgroundColor(Color.BLUE);

        //username
        EditText username = new EditText(this);


        //button
        Button myButton = new Button(this);
        myButton.setBackgroundColor(Color.RED);
        myButton.setText("Click Me");
        myButton.setTextColor(Color.WHITE);


        myButton.setId(1);
        username.setId(2);

        //relative positioning
        RelativeLayout.LayoutParams buttonDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        RelativeLayout.LayoutParams usernameDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        usernameDetails.addRule(RelativeLayout.ABOVE,myButton.getId());
        usernameDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        usernameDetails.setMargins(0,0,0,50);

        buttonDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonDetails.addRule(RelativeLayout.CENTER_VERTICAL);


        //changing username width
        username.setWidth(toPix(100));

        somsLayout.addView(myButton, buttonDetails);
        somsLayout.addView(username,usernameDetails);


        setContentView(somsLayout);
    }
}
