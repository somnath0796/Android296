package develops.mad.intentsapplication;


import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StateIntent2 extends AppCompatActivity {
    TextView data2;
    Button startBrowse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_intent2);

        data2 = (TextView) findViewById(R.id.iData2);
        startBrowse = (Button) findViewById(R.id.browsebutton);

        Bundle MainData = this.getIntent().getExtras();
        data2.setText(MainData.getString("Intent Data"));

        startBrowse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent out = new Intent(Intent.ACTION_VIEW);
                String URL = data2.getText().toString();

                out.setData(Uri.parse("https://" + URL));
                startActivity(out);
            }
        });
    }
}
