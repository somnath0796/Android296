package develops.mad.digiplanner;

/**
 * Adapter Class for Custom ListView Adapter for Rows
 *
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

class ListViewAdapter1 extends ArrayAdapter<Notes> {

    public ListViewAdapter1(Context context, ArrayList<Notes> notesT) {
        super(context, R.layout.listview_row, notesT);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater listInflater  = LayoutInflater.from(getContext());
        View listCustomView = listInflater.inflate(R.layout.listview_row, parent, false);

        Notes noteItem = getItem(position);
        TextView noteTitle = (TextView) listCustomView.findViewById(R.id.listNote);
        ImageView noteIcon = (ImageView)listCustomView.findViewById(R.id.noteViewIcon);

        noteTitle.setText(noteItem.toString());
        noteIcon.setImageResource(R.drawable.pushpin);

        return listCustomView;
    }
}
