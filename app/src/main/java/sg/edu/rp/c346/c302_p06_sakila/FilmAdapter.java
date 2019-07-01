package sg.edu.rp.c346.c302_p06_sakila;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FilmAdapter extends ArrayAdapter<Film> {
    private ArrayList<Film> film;

    private Context context;
    private TextView tvtitle;
    private TextView tvyear;
    private TextView tvRating;

    public FilmAdapter(Context context, int resource, ArrayList<Film> objects) {
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        film = objects;

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
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object
        tvtitle = rowView.findViewById(R.id.textViewTitle);
        // Get the ImageView object
        tvyear = rowView.findViewById(R.id.textViewYear);

        tvRating = rowView.findViewById(R.id.textViewrating);


        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        Film currenfilm = getItem(position);
        // Set the TextView to show the food


        tvtitle.setText(currenfilm.getTitle());
        tvyear.setText(String.valueOf(currenfilm.getYear()));
        tvRating.setText(currenfilm.getRating());


        // Set the image to star or nostar accordingly

        // Return the nicely done up View to the ListView
        return rowView;
    }
}