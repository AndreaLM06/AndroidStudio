package andrealm.td6_exercice1;


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class PizzaAdapter extends BaseAdapter {

    private ListPizza mListP;

    //Le contexte dans lequel est présent notre adapter
    private Context mContext;

    //Un mécanisme pour gérer l'affichage graphique depuis un layout XML
    private LayoutInflater mInflater;


    public PizzaAdapter(Context context, ListPizza aListP) {
        mContext = context;
        mListP = aListP;
        mInflater = LayoutInflater.from(mContext);
    }

    public double bonus=0;

    public int getCount() {return mListP.size();}

    public Object getItem(int position) {
        return mListP.get(position);
    }

    public long getItemId(int position) {
        return position;
    }


    @SuppressLint("ResourceAsColor")
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout layoutItem;
        //(1) : Réutilisation des layouts
        if (convertView == null) {
            //Initialisation de notre item à partir du  layout XML "personne_layout.xml"
            layoutItem = (LinearLayout) mInflater.inflate(R.layout.adapter_pizza, parent, false);
        } else {
            layoutItem = (LinearLayout) convertView;
        }

        //(2) : Récupération des TextView de notre layout
        TextView nom = (TextView)layoutItem.findViewById(R.id.nom);
        TextView prix = (TextView)layoutItem.findViewById(R.id.prix);
        ImageView img = (ImageView) layoutItem.findViewById(R.id.imgP);






        //(3) : Renseignement des valeurs
        nom.setText(mListP.get(position).getNom());

        double doublePrix = Double.valueOf(mListP.get(position).getPrix()).doubleValue();
        prix.setText(doublePrix+"€");
        img.setImageResource(mListP.get(position).getImgP());




        // On change la couleur du prix ssi le prix > 10€
        if (doublePrix>10)
            prix.setTextColor(Color.BLUE);
        else
            prix.setTextColor(Color.BLACK);





        nom.setTag(position);
        nom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer position = (Integer)v.getTag();
                sendListener(mListP.get(position), position);
                // On augmente la taille du nom de la pizza selectionné
                nom.setTextSize(20);
            }


        });
        //On retourne l'item créé.
        return layoutItem;
    }


    //abonnement pour click sur le nom...
    private ArrayList<PizzaAdapterListener> mListListener = new ArrayList<PizzaAdapterListener>();
    public void addListener(PizzaAdapterListener aListener) {
        mListListener.add(aListener);
    }
    private void sendListener(Pizza item, int position) {
        for(int i = mListListener.size()-1; i >= 0; i--) {
            mListListener.get(i).onClickNom(item, position);
        }
    }


}
