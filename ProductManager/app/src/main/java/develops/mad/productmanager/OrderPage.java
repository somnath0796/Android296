package develops.mad.productmanager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class OrderPage extends AppCompatActivity {
    ImageButton checkout;
    Spinner item1, item2, item3, item4, qty1, qty2, qty3, qty4;
    TextView price1, price2, price3, price4;
    DBManager db;
    int q1,q2,q3,q4;
    double v1,v2,v3,v4;
    String i1,i2,i3,i4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_page);

        checkout = (ImageButton) findViewById(R.id.checkoutButton);
        item1 = (Spinner) findViewById(R.id.item1);
        item2 = (Spinner) findViewById(R.id.item2);
        item3 = (Spinner) findViewById(R.id.item3);
        item4 = (Spinner) findViewById(R.id.item4);
        qty1 = (Spinner) findViewById(R.id.qty1);
        qty2 = (Spinner) findViewById(R.id.qty2);
        qty3 = (Spinner) findViewById(R.id.qty3);
        qty4 = (Spinner) findViewById(R.id.qty4);
        price1 = (TextView) findViewById(R.id.itemPrice1);
        price2 = (TextView) findViewById(R.id.itemPrice2);
        price3 = (TextView) findViewById(R.id.itemPrice3);
        price4 = (TextView) findViewById(R.id.itemPrice4);


        ImageButton home = (ImageButton) findViewById(R.id.homeButton2);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent out = new Intent(OrderPage.this, MainActivity.class);
                startActivity(out);
            }
        });

        db = new DBManager(this, null, null, 1);

        ArrayList<Products> prods = db.getProducts();
        ArrayAdapter<Products> prodlist = new ArrayAdapter<Products>(this, android.R.layout.simple_spinner_dropdown_item, prods);
        ArrayAdapter<CharSequence> qtylist = ArrayAdapter.createFromResource(this,R.array.Quantity, android.R.layout.simple_spinner_dropdown_item);

        item1.setAdapter(prodlist);
        item2.setAdapter(prodlist);
        item3.setAdapter(prodlist);
        item4.setAdapter(prodlist);
        qty1.setAdapter(qtylist);
        qty2.setAdapter(qtylist);
        qty3.setAdapter(qtylist);
        qty4.setAdapter(qtylist);

        item1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(@NonNull AdapterView<?> parent, View view, int position, long id) {
                Products prod = (Products)parent.getItemAtPosition(position);
                price1.setText(""+prod.get_price());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        item2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(@NonNull AdapterView<?> parent, View view, int position, long id) {
                Products prod = (Products)parent.getItemAtPosition(position);
                price2.setText(""+prod.get_price());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        item3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(@NonNull AdapterView<?> parent, View view, int position, long id) {
                Products prod = (Products)parent.getItemAtPosition(position);
                price3.setText(""+prod.get_price());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        item4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(@NonNull AdapterView<?> parent, View view, int position, long id) {
                Products prod = (Products)parent.getItemAtPosition(position);
                price4.setText(""+prod.get_price());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sp = getSharedPreferences("ProductSelect", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = sp.edit();

                edit.putInt("q1",Integer.parseInt(qty1.getSelectedItem().toString()));
                edit.putInt("q2",Integer.parseInt(qty2.getSelectedItem().toString()));
                edit.putInt("q3",Integer.parseInt(qty3.getSelectedItem().toString()));
                edit.putInt("q4",Integer.parseInt(qty4.getSelectedItem().toString()));


                edit.putFloat("v1",Float.parseFloat(price1.getText().toString()));
                edit.putFloat("v2",Float.parseFloat(price2.getText().toString()));
                edit.putFloat("v3",Float.parseFloat(price3.getText().toString()));
                edit.putFloat("v4",Float.parseFloat(price4.getText().toString()));


                edit.putString("i1",item1.getSelectedItem().toString());
                edit.putString("i2",item2.getSelectedItem().toString());
                edit.putString("i3",item3.getSelectedItem().toString());
                edit.putString("i4",item4.getSelectedItem().toString());



                Intent out = new Intent(OrderPage.this, FinalBill.class);



                edit.commit();
                startActivity(out);
            }
        });
    }
}
