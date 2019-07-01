package sg.edu.rp.c346.c302_p06_sakila;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SummaryAdapter extends ArrayAdapter<Summary> {
    private ArrayList<Summary> summary;

    private Context context;
    private TextView tvcate;
    private TextView tvnumer;


    public SummaryAdapter(Context context, int resource, ArrayList<Summary> objects) {
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        summary = objects;

        // Store Context object as we would need to use it later
        this.context = context;
    }


    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row2, parent, false);

        // Get the TextView object
        tvcate = rowView.findViewById(R.id.textViewcate);
        // Get the ImageView object
        tvnumer = rowView.findViewById(R.id.textViewnumber);




        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        Summary currensum = summary.get(position);
        // Set the TextView to show the food


        tvnumer.setText(currensum.getNumber());
        tvcate.setText(currensum.getCategory());



        // Set the image to star or nostar accordingly

        // Return the nicely done up View to the ListView
        return rowView;
    }
}