package develops.mad.notiftest;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button mbutton;
    NotificationCompat.Builder notification;
    private static final int uniqueID = 23123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notification  = new NotificationCompat.Builder(this);
        notification.setAutoCancel(true);

        mbutton = (Button)findViewById(R.id.mbutton);
        mbutton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        notification.setSmallIcon(R.mipmap.ic_launcher);
        notification.setTicker("Hi! I'm Alive");
        notification.setWhen(System.currentTimeMillis());
        notification.setContentTitle("Notification System");
        notification.setContentText("Hello!! How are you doing??");
        notification.setColor(getResources().getColor(R.color.colorAccent));

        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pI = PendingIntent.getActivity(this, 0, intent,PendingIntent.FLAG_UPDATE_CURRENT );

        notification.setContentIntent(pI);

        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(uniqueID, notification.build());
    }
}
