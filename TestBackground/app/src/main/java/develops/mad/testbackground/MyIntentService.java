package develops.mad.testbackground;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import java.sql.Time;
import java.util.Calendar;

/**
 * Created by Somnath on 03-07-2016.
 */
public class MyIntentService extends IntentService {


    private static final String TAG = "develops.mad.testbackground";
    private static final String uniqueID="232405";
    public MyIntentService()
    {
        super("MyIntentService");



    }

    @Override
    protected void onHandleIntent(Intent intent) {
     Log.i(TAG,"SERVICE HAS STARTED");



        Calendar cal = Calendar.getInstance();
        DBManager db = new DBManager(this, null, null, 1);
        String Time ;
        String time = "19:55";
        while(true) {

            Time = db.getNowTime();


            Log.i(TAG,"Time is here:"+Time);
            //Log.i(TAG,Time);
            if (time.equals(Time)){

                //notifyfunc("TASK","DO it or Die");
                break;
            }
        }
}

    @Override
    public void onDestroy() {
       Log.i(TAG,"on destroy");
        Toast.makeText(this.getApplicationContext(),"destroyed",Toast.LENGTH_SHORT).show();
    }



        public void notifyfunc( String Title, String Text)
        {  NotificationCompat.Builder notification;
            notification = new NotificationCompat.Builder(this);
            notification.setSmallIcon(R.drawable.icon,50);
            notification.setTicker("This is a Ticker");
            notification.setContentTitle(Title);
            notification.setContentText(Text);

            Intent i = new Intent(this,MainActivity.class);
            PendingIntent pi= PendingIntent.getActivity(this,0,i,PendingIntent.FLAG_UPDATE_CURRENT);
            notification.setContentIntent(pi);
            notification.setAutoCancel(false);
            NotificationManager nm =(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
            nm.notify(Integer.parseInt(uniqueID),notification.build());



        }
}
