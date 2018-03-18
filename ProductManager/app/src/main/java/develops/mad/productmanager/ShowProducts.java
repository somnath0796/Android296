package develops.mad.productmanager;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ShowProducts extends AppCompatActivity {

    ListView prod_list;

    DBManager db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_products);

        prod_list = (ListView)findViewById(R.id.product_list);

        db = new DBManager(this, null, null, 1);


        ArrayList<Products> prods = db.getProducts();

        ImageButton home = (ImageButton) findViewById(R.id.homeButton);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent out = new Intent(ShowProducts.this, MainActivity.class);
                startActivity(out);
            }
        });

        Button clear = (Button) findViewById(R.id.clearAll);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Products prod = new Products();
                prod.set_name("No Product Selected");
                prod.set_price(0.0);
                prod.set_dateMfg("00/00");
                db.deleteProduct(0,true);
                db.addProduct(prod);
                Intent in = new Intent(ShowProducts.this, ShowProducts.class);
                startActivity(in);
            }
        });

        if(prods.isEmpty()){

        }
        else{
            ArrayList<String> p_names  = new ArrayList<String>();
            for(Products pro:prods){
                p_names.add(pro.toString());
            }

            ArrayAdapter<Products> list = new ArrayAdapter<Products>(this, android.R.layout.simple_list_item_1, prods);

            prod_list.setAdapter(list);
        }

        prod_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull AdapterView<?> parent, View view, int position, long id) {
                Intent out = new Intent(getApplicationContext(),AddProduct.class);
                Products p =(Products)parent.getItemAtPosition(position);
                out.putExtra("saving",false);
                out.putExtra("p_id", p.get_id());
                out.putExtra("p_name",p.get_name());
                out.putExtra("p_price",p.get_price());
                out.putExtra("p_date",p.get_dateMfg());
                startActivity(out);
            }
        });

    }
}
