package develops.mad.testbackground;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import static develops.mad.testbackground.R.drawable.icon;

public class MainActivity extends AppCompatActivity {
    int p =1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


         Intent i = new Intent(this,MyIntentService.class);
         //startService(i);
        NotificationCompat.Builder notification = new NotificationCompat.Builder(this);
        notification.setSmallIcon(R.drawable.icon);
        notification.setTicker("This is a Ticker");
        notification.setContentTitle("Task");
        notification.setContentText("fuck u");

        Intent in = new Intent(this,MainActivity.class);
        PendingIntent pi= PendingIntent.getActivity(this,0,in,PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pi);
        notification.setAutoCancel(true);


        if(p==1) {
            p++;
            NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            nm.notify(2324, notification.build());
        }



    }

}
