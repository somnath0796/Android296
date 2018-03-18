package develops.mad.converter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{


    double Currency[] = {67.29, 88.44, 49.55,0.64}; //currency values
    EditText sou;
    TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Retrieving Layout Objects
        Spinner select = (Spinner)findViewById(R.id.C_lecter);

         sou = (EditText)findViewById(R.id.c_source);
         res = (TextView)findViewById(R.id.c_result);

        //array adapter for setting items on Spinner
        ArrayAdapter<CharSequence> adapt = ArrayAdapter.createFromResource(this, R.array.Currency,
                android.R.layout.simple_spinner_item);
        adapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        select.setAdapter(adapt);
        select.setOnItemSelectedListener(this);

    }

    @Override
   public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        String c = parent.getItemAtPosition(pos).toString();

        double source = 0.0;
        if(sou.getText().equals("")){
            /*Do Nothing*/
        }
        else{
            source = Double.parseDouble(sou.getText().toString());
        }

        double result = 0.0;

        switch(c){
            case "US Dollar(US$)":
                result = calculate(Currency[0],source);
                break;
            case "UK Pound(UK£)":
                result = calculate(Currency[1],source);
                break;
            case "SGP Dollar(SG$)":
                result = calculate(Currency[2],source);
                break;
            case "Jap Yen":
                result = calculate(Currency[3],source);
                break;
            default:

        }

        res.setText(Double.toString(result));
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    //converter function
    private double calculate(double rate, double source){
        double res = source/rate;
        return res;
    }
}
