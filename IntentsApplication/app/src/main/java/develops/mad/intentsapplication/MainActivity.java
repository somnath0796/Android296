package develops.mad.intentsapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button Next_Activity;
    EditText transferText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Next_Activity = (Button) findViewById(R.id.nextactivity);
        transferText = (EditText) findViewById(R.id.transferData);

        Next_Activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent out = new Intent("MyActivity");
                out.putExtra("Intent Data",transferText.getText().toString());
                startActivity(out);
            }
        });
    }
}
