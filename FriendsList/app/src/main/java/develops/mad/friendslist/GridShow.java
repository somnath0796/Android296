package develops.mad.friendslist;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

public class GridShow extends AppCompatActivity {

    String MyFriends[] = {"Robert", "Becca", "Robin", "Bruce", "Peter", "Jean"};
    String Mails[] = {"robert@abc.com", "becca23@gmail.com", "batrobin@gomail.com", "wayneforeva@bat.com", "spidey2001@dbugle.com", "j.smith@tuin.com"};
    String Mobiles[] = {"1234567890","1234567890","1234567890","1234567890","1234567890","1234567890"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_show);

        Button switch2 = (Button) findViewById(R.id.switch2);

        GridView grid = (GridView)findViewById(R.id.gridView);

        ImageAdapter adapt = new ImageAdapter(this);

        grid.setAdapter(adapt);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent out = new Intent(getApplicationContext(), ContactDetails.class);
                out.putExtra("Position", position);

                startActivity(out);
            }
        });

        switch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent out = new Intent(getApplicationContext(), ListActivity.class);
                startActivity(out);
            }
        });
    }

}
class ImageAdapter extends BaseAdapter{
    private Context mContext;

    // Constructor
    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        }
        else
        {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    // Keep all Images in array
    public Integer[] mThumbIds = {
            R.drawable.geek, R.drawable.cont, R.drawable.robin,
            R.drawable.batman, R.drawable.spidey, R.drawable.xmen
    };
}