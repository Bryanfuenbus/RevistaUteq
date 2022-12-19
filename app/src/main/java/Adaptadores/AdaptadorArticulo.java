package Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.deber_revista.R;

import java.util.ArrayList;

import Modelos.Articulo;
import Modelos.Volumen;

public class AdaptadorArticulo extends ArrayAdapter<Articulo> {

    public AdaptadorArticulo(Context context, ArrayList<Articulo> datos) {
        super(context, R.layout.lyitemarticulo, datos);
    }


    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.lyitemarticulo, null);

        TextView lblCategoria= (TextView)item.findViewById(R.id.lblCategoria);
        lblCategoria.setText(getItem(position).seccion);

        TextView lblTituloArticulo= (TextView)item.findViewById(R.id.lblTituloArticulo);
        lblTituloArticulo.setText(getItem(position).title);

        TextView lblFecha = (TextView)item.findViewById(R.id.lblFechaArticulo);
        lblFecha.setText(getItem(position).fecha);

        ImageView imgpdf= (ImageView)item.findViewById(R.id.imgPdf);
        imgpdf.setImageResource(R.drawable.img);

        return(item);
    }
}