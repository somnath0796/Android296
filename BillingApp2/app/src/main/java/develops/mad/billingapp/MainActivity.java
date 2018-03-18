package develops.mad.billingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Spinner Qty1, Qty2, Qty3, Qty4;
    TextView price1, price2, price3, price4,item1,item2,item3,item4;
    Button checkout;
    int v1, v2, v3, v4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Price of items
        Double prices[] = {85.60, 130.34, 75.38, 50.23};

        //Retrieving layout Objects
        Qty1 = (Spinner) findViewById(R.id.spinQty1);
        Qty2 = (Spinner) findViewById(R.id.spinQty2);
        Qty3 = (Spinner) findViewById(R.id.spinQty3);
        Qty4 = (Spinner) findViewById(R.id.spinQty4);
        price1 = (TextView) findViewById(R.id.itemPrice1);
        price2 = (TextView) findViewById(R.id.itemPrice2);
        price3 = (TextView) findViewById(R.id.itemPrice3);
        price4 = (TextView) findViewById(R.id.itemPrice4);
        item1 = (TextView) findViewById(R.id.item1);
        item2 = (TextView) findViewById(R.id.item2);
        item3 = (TextView) findViewById(R.id.item3);
        item4 = (TextView) findViewById(R.id.item4);
        checkout = (Button) findViewById(R.id.buttonCheck);


        ArrayAdapter<CharSequence> adapt = ArrayAdapter.createFromResource(this, R.array.Quantity, android.R.layout.simple_spinner_item);
        adapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Qty1.setAdapter(adapt);
        Qty2.setAdapter(adapt);
        Qty3.setAdapter(adapt);
        Qty4.setAdapter(adapt);


        Bundle data = this.getIntent().getExtras();

        if(data!= null){
            int Qty[] = data.getIntArray("qty");
            Qty1.setSelection(Qty[0]);
            Qty2.setSelection(Qty[1]);
            Qty3.setSelection(Qty[2]);
            Qty4.setSelection(Qty[3]);
        }

        price1.setText(prices[0]+" /kg");
        price2.setText(prices[1]+" /kg");
        price3.setText(prices[2]+" /kg");
        price4.setText(prices[3]+" /kg");

        checkout.setOnClickListener(this);



    }


    @Override
    public void onClick(View view) {

        //going to checkout activity
        if(view==checkout){

            v1 = Integer.parseInt(Qty1.getSelectedItem().toString());
            v2 = Integer.parseInt(Qty2.getSelectedItem().toString());
            v3 = Integer.parseInt(Qty3.getSelectedItem().toString());
            v4 = Integer.parseInt(Qty4.getSelectedItem().toString());
            int qty[] = {v1,v2,v3,v4};

            Intent out = new Intent(this, FinalBill.class);

            out.putExtra("qty", qty);
            startActivity(out);
        }
    }
}
