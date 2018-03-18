package develops.mad.productmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button ShowAll, AddNew, Order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ShowAll = (Button)findViewById(R.id.ShowAllButton);
        AddNew = (Button)findViewById(R.id.AddScreenButton);
        Order = (Button)findViewById(R.id.OrderButton);

        ShowAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent out = new Intent(getApplicationContext(),ShowProducts.class);
                startActivity(out);
            }
        });

        Order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent out = new Intent(getApplicationContext(), OrderPage.class);
                startActivity(out);
            }
        });

        AddNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent out = new Intent(getApplicationContext(), AddProduct.class);
                out.putExtra("saving", true);
                startActivity(out);
            }
        });
    }
}
