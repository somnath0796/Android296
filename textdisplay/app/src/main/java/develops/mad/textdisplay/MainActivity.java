package develops.mad.textdisplay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText source;
    Button myButton1;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        source = (EditText) findViewById(R.id.source);
        myButton1 = (Button) findViewById(R.id.myButton);
        result = (TextView) findViewById(R.id.result);

        myButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = source.getText().toString();
                result.setText(text);
            }
        });
    }


}
