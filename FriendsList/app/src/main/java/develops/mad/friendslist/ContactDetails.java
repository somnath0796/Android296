package develops.mad.friendslist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


public class ContactDetails extends AppCompatActivity {

    SeekBar s;
    String MyFriends[] = {"Robert", "Becca", "Robin", "Bruce", "Peter", "Jean"};
    String Mails[] = {"robert@abc.com", "becca23@gmail.com", "batrobin@gomail.com", "wayneforeva@bat.com", "spidey2001@dbugle.com", "j.smith@tuin.com"};
    String Mobiles[] = {"1234567890","6413567890","8673217890","1234534315","4243157859","12164645687"};
    Integer[] mThumbIds = {
            R.drawable.geek, R.drawable.cont, R.drawable.robin,
            R.drawable.batman, R.drawable.spidey, R.drawable.xmen
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_details);

        int pos=0;
        Bundle maindata = getIntent().getExtras();
        if(maindata==null){
            Toast.makeText(this,"Data passed is null", Toast.LENGTH_LONG).show();
        }
        else{
            pos = maindata.getInt("Position");
        }



        TextView name = (TextView)findViewById(R.id.nameView);
        TextView mail = (TextView)findViewById(R.id.mailView);
        TextView mobile = (TextView)findViewById(R.id.mobileView);
        ImageView contact = (ImageView)findViewById(R.id.contactImage);

        name.setText(MyFriends[pos]);
        mail.setText(Mails[pos]);
        mobile.setText(Mobiles[pos]);
        contact.setImageResource(mThumbIds[pos]);


    }
}
