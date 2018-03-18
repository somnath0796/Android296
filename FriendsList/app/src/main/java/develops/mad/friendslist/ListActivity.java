package develops.mad.friendslist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class ListActivity extends AppCompatActivity {
    String MyFriends[] = {"Robert", "Becca", "Robin", "Bruce", "Peter", "Jean"};
    String Mails[] = {"robert@abc.com", "becca23@gmail.com", "batrobin@gomail.com", "wayneforeva@bat.com", "spidey2001@dbugle.com", "j.smith@tuin.com"};
    String Mobiles[] = {"1234567890","1234567890","1234567890","1234567890","1234567890","1234567890"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Button switch1 = (Button)findViewById(R.id.switch1);

        ListView friends = (ListView)findViewById(R.id.listView);

        ArrayAdapter<CharSequence> adapt = new ArrayAdapter<CharSequence>(this,android.R.layout.simple_list_item_1,MyFriends);

        friends.setAdapter(adapt);

        friends.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent out = new Intent(getApplicationContext(), ContactDetails.class);
                out.putExtra("Position", position);

                startActivity(out);
            }
        });

        switch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent out = new Intent(getApplicationContext(), GridShow.class);
                startActivity(out);
            }
        });

    }
}
