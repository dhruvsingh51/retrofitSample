package ApiVolley;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.*;
import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;


/**
 * Created by techjini on 24/2/16.
 */
public class RequestQueue {

    private final Context mContext;
    public final String VOLLEY_BASE_URL = "https://api.pipelinedeals.com/api/v3/people/1027567602.json?app_key=1f7e4b38d0ff521ff8115d86fb012322&api_key=gYM1HfbPAH8y7qOc6gT";

    public RequestQueue(Context mContext) {
        this.mContext = mContext;

    }

    public void executeVolley() {
        com.android.volley.RequestQueue queue = Volley.newRequestQueue(mContext);
        JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.GET, VOLLEY_BASE_URL, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                // TODO Auto-generated method stub
                Toast.makeText(mContext, "Volley Response recieved", Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub
                Toast.makeText(mContext, "Error occured in volley Response", Toast.LENGTH_LONG).show();
            }
        });
        queue.add(jsObjRequest);
    }

}
