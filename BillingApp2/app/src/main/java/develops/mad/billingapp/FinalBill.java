package develops.mad.billingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FinalBill extends AppCompatActivity implements View.OnClickListener {
    Button back, gen;
    TextView billQty1, billQty2, billQty3, billQty4;
    TextView billP1, billP2, billP3, billP4;
    TextView totalBill, discAmt, finalAmt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_bill);
        Double prices[] = {85.60, 130.34, 75.38, 50.23};


        //retrieving layout objects
        back = (Button) findViewById(R.id.buttonBack);
        gen = (Button) findViewById(R.id.buttonGen);
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


        Bundle data = this.getIntent().getExtras();

        int Qty[] = data.getIntArray("qty");

        //setting recieved quantities
        billQty1.setText("X "+Qty[0]);
        billQty2.setText("X "+Qty[1]);
        billQty3.setText("X "+Qty[2]);
        billQty4.setText("X "+Qty[3]);

        billP1.setText(""+(Qty[0]*prices[0]));
        billP2.setText(""+(Qty[1]*prices[1]));
        billP3.setText(""+(Qty[2]*prices[2]));
        billP4.setText(""+(Qty[3]*prices[3]));

        //calculating grand total
        double total = Double.parseDouble(billP1.getText().toString())+
                Double.parseDouble(billP2.getText().toString())+
                Double.parseDouble(billP3.getText().toString())+
                Double.parseDouble(billP4.getText().toString());
        double disc = 0;
        double finAmt = 0;

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
        finAmt = total - (disc * total);

        totalBill.setText(total+"");
        discAmt.setText("- "+(disc*total));
        finalAmt.setText(""+finAmt);


        back.setOnClickListener(this);
        gen.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        int v1, v2, v3, v4;

        //for reviewing any changes
        if(view==back){
            Intent in = new Intent(this, MainActivity.class);
            v1 = Integer.parseInt(billQty1.getText().toString());
            v2 = Integer.parseInt(billQty2.getText().toString());
            v3 = Integer.parseInt(billQty3.getText().toString());
            v4 = Integer.parseInt(billQty4.getText().toString());
            int qty[] = {v1,v2,v3,v4};
            in.putExtra("qty", qty);
            startActivity(in);
        }
        if(view==gen){
            Intent out = new Intent(this, MainActivity.class);
            Toast.makeText(this, "Bill is now generated...", Toast.LENGTH_LONG).show();
            Toast.makeText(this, "Thanks for shopping with us...", Toast.LENGTH_SHORT).show();
            startActivity(out);

        }
    }
}
