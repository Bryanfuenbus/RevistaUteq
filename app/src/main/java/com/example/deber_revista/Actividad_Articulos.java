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

import Adaptadores.AdaptadorArticulo;
import Adaptadores.AdaptadorVolumen;
import Modelos.Articulo;
import Modelos.Volumen;

public class Actividad_Articulos extends AppCompatActivity {
    public ListView lstarticulos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_articulos);

        lstarticulos = (ListView)findViewById(R.id.lstarticulo);

        Bundle bundle = this.getIntent().getExtras();
        String IDVolumen=bundle.getString("id");
        RequestQueue queue= Volley.newRequestQueue(this);
        String url="https://revistas.uteq.edu.ec/ws/pubs.php?i_id="+IDVolumen;


        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        JSONObject JSONlista = null;
                        try {
                            JSONArray JSONArticulo= new JSONArray(response);

                            ArrayList<Articulo> lstArticuloA = Articulo.JsonObjectsBuild(JSONArticulo);

                            AdaptadorArticulo adaptadorArticulo = new AdaptadorArticulo(getApplicationContext(),lstArticuloA);

                            lstarticulos.setAdapter(adaptadorArticulo);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Actividad_Articulos.this, "No Valió", Toast.LENGTH_SHORT).show();
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);


    }
}