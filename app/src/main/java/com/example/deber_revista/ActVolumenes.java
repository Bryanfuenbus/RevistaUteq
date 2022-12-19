package com.example.deber_revista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import Adaptadores.AdaptadorRevista;
import Adaptadores.AdaptadorVolumen;
import Modelos.Revista;
import Modelos.Volumen;

public class ActVolumenes extends AppCompatActivity {
    public ListView lstvolumen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_volumenes);

        lstvolumen = (ListView)findViewById(R.id.lstvolumenes);

        Bundle bundle = this.getIntent().getExtras();
        String IDRevista= bundle.getString("id");
        RequestQueue queue=Volley.newRequestQueue(this);
        String url="https://revistas.uteq.edu.ec/ws/issues.php?j_id="+IDRevista;


        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        JSONObject JSONlista = null;
                        try {
                            JSONArray JSONVolumen= new JSONArray(response);

                            ArrayList<Volumen> lstVolumenA = Volumen.JsonObjectsBuild(JSONVolumen);

                            AdaptadorVolumen adaptadorVolumen = new AdaptadorVolumen(getApplicationContext(),lstVolumenA);

                            lstvolumen.setAdapter(adaptadorVolumen);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ActVolumenes.this, "No Valió", Toast.LENGTH_SHORT).show();
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);


    }
}