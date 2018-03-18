package develops.mad.intentsapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class StateIntent1 extends AppCompatActivity {
    TextView data1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_intent1);

        data1 = (TextView) findViewById(R.id.iData1);

        Bundle MainData = this.getIntent().getExtras();

        data1.setText("My message is: "+MainData.getString("Intent Data"));
    }
}
