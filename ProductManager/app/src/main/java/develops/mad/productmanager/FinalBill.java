package develops.mad.productmanager;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FinalBill extends AppCompatActivity implements View.OnClickListener {
    Button gen;
    TextView textItem1, textItem2, textItem3, textItem4;
    TextView billQty1, billQty2, billQty3, billQty4;
    TextView billP1, billP2, billP3, billP4;
    TextView totalBill, discAmt, finalAmt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_bill);

        //retrieving layout objects
        gen = (Button) findViewById(R.id.buttonGen);
        textItem1 = (TextView) findViewById(R.id.textitem1);
        textItem2 = (TextView) findViewById(R.id.textitem2);
        textItem3 = (TextView) findViewById(R.id.textitem3);
        textItem4 = (TextView) findViewById(R.id.textitem4);
        billQty1 = (TextView) findViewById(R.id.billQty1);
        billQty2 = (TextView) findViewById(R.id.billQty2);
        billQty3 = (TextView) findViewById(R.id.billQty3);
        billQty4 = (TextView) findViewById(R.id.billQty4);
        billP1 = (TextView) findViewById(R.id.billP1);
        billP2 = (TextView) findViewById(R.id.billP2);
        billP3 = (TextView) findViewById(R.id.billP3);
        billP4 = (TextView) findViewById(R.id.billP4);
        totalBill = (TextView) findViewById(R.id.totalBill);
        discAmt = (TextView) findViewById(R.id.discAmt);
        finalAmt = (TextView) findViewById(R.id.finalAmt);


        SharedPreferences sp = getSharedPreferences("ProductSelect",MODE_PRIVATE);


        Bundle data = this.getIntent().getExtras();


        //setting recieved Items
        textItem1.setText(sp.getString("i1",null));
        textItem2.setText(sp.getString("i2",null));
        textItem3.setText(sp.getString("i3",null));
        textItem4.setText(sp.getString("i4",null));


        //setting recieved quantities
        billQty1.setText("X "+sp.getInt("q1",0));
        billQty2.setText("X "+sp.getInt("q2",0));
        billQty3.setText("X "+sp.getInt("q3",0));
        billQty4.setText("X "+sp.getInt("q4",0));

        billP1.setText(""+(sp.getInt("q1",0)*sp.getFloat("v1",0)));
        billP2.setText(""+(sp.getInt("q2",0)*sp.getFloat("v2",0)));
        billP3.setText(""+(sp.getInt("q3",0)*sp.getFloat("v3",0)));
        billP4.setText(""+(sp.getInt("q4",0)*sp.getFloat("v4",0)));

        //calculating grand total
        double total = Double.parseDouble(billP1.getText().toString())+
                Double.parseDouble(billP2.getText().toString())+
                Double.parseDouble(billP3.getText().toString())+
                Double.parseDouble(billP4.getText().toString());
        double disc = 0;
        float finAmt = 0;

        //calculating discount
        if(total>=500 && total<1000){
            disc = 0.05;
        }
        else if(total>=1000 && total<2000){
            disc = 0.15;
        }
        else if(total>=2000){
            disc = 0.25;
        }
        //calculating final amount
        finAmt = (float)(total - (disc * total));

        totalBill.setText((float)total+"");
        discAmt.setText("- "+(float)(disc*total));
        finalAmt.setText(""+finAmt);

        gen.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(view==gen){
            Intent out = new Intent(this, MainActivity.class);
            Toast.makeText(this, "Bill is now being generated...", Toast.LENGTH_LONG).show();
            Toast.makeText(this, "Products will be delivered in 4 hours..", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "Thanks for shopping with us...", Toast.LENGTH_SHORT).show();

            startActivity(out);
        }
    }
}
