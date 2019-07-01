package sg.edu.rp.c346.c302_p06_sakila;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class ViewFilmsActivity extends AppCompatActivity {
    ListView lv;

    ArrayAdapter <Film>aa;
    ArrayList<Film> alfilm = new ArrayList<Film>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_films);

        Intent i = getIntent();
        Category c = (Category)i.getSerializableExtra("category") ;
        TextView tvcat = findViewById(R.id.tvcategory);
        tvcat.setText(c.getName());
        lv = (ListView) findViewById(R.id.lvfilm);
        aa = new FilmAdapter(this, android.R.layout.simple_list_item_1, alfilm);
        lv.setAdapter(aa);


        RequestParams params = new RequestParams();
        params.add("id", String.valueOf(c.getId()));
        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://10.0.2.2/C302_P05_Sakila/getFilmsByCategoryId.php",params, new JsonHttpResponseHandler(){

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                // called when response HTTP status is "200 OK"
                try {
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject film = (JSONObject)response.get(i);
                        Film f =  new Film(film.getInt("film_id"),film.getString("title"),film.getInt("release_year"),film.getString("rating"));
//                        String title = (String) c.get
                    alfilm.add(f);

                    }
                    aa.notifyDataSetChanged();

                }catch (JSONException e){
                    e.printStackTrace();
                }
            }


        });


        aa = new FilmAdapter(this, R.layout.row, alfilm);

        lv.setAdapter(aa);





    }
}
