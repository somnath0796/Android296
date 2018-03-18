package develops.mad.productmanager;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class AddProduct extends AppCompatActivity {

    TextView pgtitle;
    EditText pName, pPrice, pDate;
    Button saveButton, updateButton, deleteButton;
    DBManager db;
    Boolean save;
    Integer p_id;
    @Nullable
    String p_name, p_date;
    Double p_price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        pgtitle = (TextView) findViewById(R.id.pageTitle);
        pName = (EditText) findViewById(R.id.prodName);
        pPrice = (EditText) findViewById(R.id.prodPrice);
        pDate = (EditText) findViewById(R.id.prodDate);
        saveButton = (Button) findViewById(R.id.addButton);
        updateButton = (Button) findViewById(R.id.updateButton);
        deleteButton  = (Button) findViewById(R.id.deleteButton);


        Bundle BundleMainData = getIntent().getExtras();

        save=BundleMainData.getBoolean("saving");
        p_id = BundleMainData.getInt("p_id");
        p_name = BundleMainData.getString("p_name");
        p_price = BundleMainData.getDouble("p_price");
        p_date = BundleMainData.getString("p_date");


        if(save){
            pgtitle.setText("Add a New Product");
            saveButton.setVisibility(View.VISIBLE);
            updateButton.setVisibility(View.INVISIBLE);
        }
        else{
            saveButton.setVisibility(View.INVISIBLE);
            updateButton.setVisibility(View.VISIBLE);

            pgtitle.setText("Edit Product");

            pName.setText(p_name);
            pPrice.setText(p_price.toString());
            pDate.setText(p_date);
        }

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = new DBManager(getApplicationContext(), null, null, 1);
                Products p = new Products();
                p.set_name(pName.getText().toString());
                p.set_price(Double.parseDouble(pPrice.getText().toString()));
                p.set_dateMfg(pDate.getText().toString());
                db.addProduct(p);
                Toast.makeText(AddProduct.this, "Product Added!", Toast.LENGTH_SHORT).show();
                Intent out = new Intent(AddProduct.this, ShowProducts.class);
                startActivity(out);
            }
        });

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = new DBManager(getApplicationContext(), null, null, 1);
                Products p = new Products();
                p.set_id(p_id);
                p.set_name(pName.getText().toString());
                p.set_price(Double.parseDouble(pPrice.getText().toString()));
                p.set_dateMfg(pDate.getText().toString());
                db.updateProduct(p);
                Toast.makeText(AddProduct.this, "Product Updated!", Toast.LENGTH_SHORT).show();
                Intent out = new Intent(AddProduct.this, ShowProducts.class);
                startActivity(out);
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!save){
                    db = new DBManager(getApplicationContext(), null, null, 1);
                    db.deleteProduct(p_id,false);
                    Toast.makeText(AddProduct.this, "Product Deleted!", Toast.LENGTH_SHORT).show();
                    Intent out = new Intent(AddProduct.this, ShowProducts.class);
                    startActivity(out);
                }
                else{
                    Toast.makeText(AddProduct.this, "New Product Scrapped!", Toast.LENGTH_SHORT).show();
                    Intent out = new Intent(AddProduct.this, MainActivity.class);
                    startActivity(out);
                }
            }
        });



    }
}
