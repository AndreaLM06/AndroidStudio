package com.example.fredrallo.demolistviewadapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by fred on 19/02/2018.
 */

public class CustomAdapter extends BaseAdapter {
    private static LayoutInflater mInflater = null; //Un mécanisme pour gérer l'affichage graphique depuis un layout XML
    Context contexte;
    int images[];
    String nom[];

    public CustomAdapter(Context contexte, int[] images, String[] nom) {
        this.contexte = contexte;
        this.images = images;
        this.nom = nom;
    }

    @Override
    public int getCount( ) {
        return nom.length;
    }

    @Override
    public Object getItem(int position) {
        return getItemId(position);

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View maVue=convertView;


        //(1) : Réutilisation des layouts
        if (maVue == null) {
            //Initialisation de notre item à partir du  layout XML ""
            mInflater = (LayoutInflater) contexte.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            maVue = mInflater.inflate(R.layout.un_element_layout, null);
        }

        ImageView imgPers = maVue.findViewById(R.id.imagePersonnage);
        TextView textPers = maVue.findViewById(R.id.textViewPersonnage);


        imgPers.setImageResource(images[position]);
        textPers.setText(nom[position]);

        return maVue;
    }
}
