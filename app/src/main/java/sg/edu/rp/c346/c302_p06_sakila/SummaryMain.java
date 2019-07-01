package sg.edu.rp.c346.c302_p06_sakila;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class SummaryMain extends AppCompatActivity {
    ListView lv;


    ArrayAdapter<Summary> aa;
    ArrayList<Summary> al = new ArrayList<Summary>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary_main);

        Intent i = getIntent();


            lv = (ListView) findViewById(R.id.lvsummary);
            aa = new SummaryAdapter(this, android.R.layout.simple_list_item_1, al);
            lv.setAdapter(aa);


            RequestParams params = new RequestParams();

            AsyncHttpClient client = new AsyncHttpClient();
            client.get("http://10.0.2.2/C302_P05_Sakila/getCategorySummary.php",params, new JsonHttpResponseHandler(){

                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                    // called when response HTTP status is "200 OK"
                    try {
                        for (int i = 0; i < response.length(); i++) {
                            JSONObject summary = (JSONObject)response.get(i);
                            Summary s =  new Summary(summary.getString("name"),summary.getString("number_flims"));
//                        String title = (String) c.get
                            al.add(s);

                        }
                        aa.notifyDataSetChanged();

                    }catch (JSONException e){
                        e.printStackTrace();
                    }
                }


            });




        }
}
