package com.clubgeny.currencyconvertor;

import android.database.CursorIndexOutOfBoundsException;
import android.icu.text.NumberFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // setting radio group
        final RadioGroup r1 = (RadioGroup)findViewById(R.id.RadioGroup1);
        // setting editext
        final  EditText Currencysetter = (EditText)findViewById(R.id.amounttext);

        // setting button object

        Button convertor = (Button)findViewById(R.id.cconvert);
        //defining on click
          convertor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String money = Currencysetter.getText().toString(); //converting money to string

                int selectedID = r1.getCheckedRadioButtonId();  //getting the chosen radio button
                RadioButton rbutton = (RadioButton) findViewById(selectedID);  //defining the radiobutton which is selected
                try
                { {  final double amount = Double.parseDouble(money);  //parsing to double
                    if(!(Double.isNaN(amount)))

                    if (rbutton.getId()==R.id.dollar)
                        calculate(0, "USD", amount);  //passing to calculate function
                    else if (rbutton.getId()==R.id.euro)
                        calculate(1, "EURO", amount);

                    else
                        calculate(2, "YEN", amount);


                    Toast.makeText(MainActivity.this, rbutton.getText(), Toast.LENGTH_SHORT).show();
                }

                }catch (RuntimeException e)
                {
                    Currencysetter.setText("");
                }


            }
        });


    }





    void calculate(int val ,String currency,double money)
    { double amount=0.0;
        EditText Currencyset = (EditText)findViewById(R.id.amounttext);
        switch(val){
            case 0 : amount = 0.015*money;
                break;
            case 1 : amount = 0.013 * money;
                break;
            case 2 : amount = 1.5 *money;
                break;
        }

        Currencyset.setMaxWidth(5);
        Currencyset.setText(String.valueOf(amount)+ " " + currency);


    }


}
