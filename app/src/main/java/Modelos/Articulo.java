package Modelos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Articulo {public String cover;
    public String title;
    public String fecha;
    public String seccion;


    public Articulo(JSONObject a) throws JSONException {
        title =  a.getString("title").toString() ;
        fecha=a.getString("date_published").toString();
        seccion=a.getString("section").toString();


    }

    public static ArrayList<Articulo> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Articulo> articulos = new ArrayList<>();

        for (int i = 0; i < datos.length() && i<20; i++) {
            articulos.add(new Articulo(datos.getJSONObject(i)));
        }
        return articulos;
    }
}