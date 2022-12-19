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

import Modelos.Revista;
import Modelos.Volumen;

public class AdaptadorVolumen extends ArrayAdapter<Volumen> {

    public AdaptadorVolumen(Context context, ArrayList<Volumen> datos) {
        super(context, R.layout.lyitemvolumen, datos);
    }


    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.lyitemvolumen, null);

        TextView lblTitulo = (TextView)item.findViewById(R.id.lblTitulo);
        lblTitulo.setText(getItem(position).title);

        TextView lblDoi = (TextView)item.findViewById(R.id.lblDoi);
        lblDoi.setText(getItem(position).doi);

        TextView lblFecha = (TextView)item.findViewById(R.id.lblFecha);
        lblFecha.setText(getItem(position).fecha);

        ImageView imageView = (ImageView)item.findViewById(R.id.imgCover);
        Glide.with(this.getContext())
                .load(getItem(position).cover)
                .into(imageView);


        return(item);
    }
}