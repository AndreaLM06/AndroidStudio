package com.example.listviewexample;
import android.widget.*;
import java.util.*;
import android.content.*;
import android.view.*;
import android.graphics.*;
import android.view.View.*;

/**
 * Created by Rosa on 03/02/2020.
 */
public class PersonneAdapter extends BaseAdapter {

    private ListPers mListP;

    //Le contexte dans lequel est présent notre adapter
    private Context mContext;

    //Un mécanisme pour gérer l'affichage graphique depuis un layout XML
    private LayoutInflater mInflater;


    public PersonneAdapter(Context context, ListPers aListP) {
        mContext = context;
        mListP = aListP;
        mInflater = LayoutInflater.from(mContext);
    }

    public int getCount() {
        return mListP.size();
    }

    public Object getItem(int position) {
        return mListP.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout layoutItem;
        //(1) : Réutilisation des layouts
        if (convertView == null) {
            //Initialisation de notre item à partir du  layout XML "personne_layout.xml"
            layoutItem = (LinearLayout) mInflater.inflate(R.layout.persone_layout, parent, false);
        } else {
            layoutItem = (LinearLayout) convertView;
        }

        //(2) : Récupération des TextView de notre layout
        TextView tv_Nom = (TextView)layoutItem.findViewById(R.id.TV_Nom);
        TextView tv_Prenom = (TextView)layoutItem.findViewById(R.id.TV_Prenom);

        //(3) : Renseignement des valeurs
        tv_Nom.setText(mListP.get(position).getNom());
        tv_Prenom.setText(mListP.get(position).getPrenom());

        //(4) Changement de la couleur du fond de notre item
        if (mListP.get(position).getGenre() == 1) {
            layoutItem.setBackgroundColor(Color.BLUE);
        } else {
            layoutItem.setBackgroundColor(Color.MAGENTA);
        }
        tv_Nom.setTag(position);
        tv_Nom.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Integer position = (Integer)v.getTag();
                sendListener(mListP.get(position), position);

            }

        });
        //On retourne l'item créé.
        return layoutItem;
    }

    //abonnement pour click sur le nom...
    private ArrayList<PersonneAdapterListener> mListListener = new ArrayList<PersonneAdapterListener>();
    public void addListener(PersonneAdapterListener aListener) {
        mListListener.add(aListener);
    }
    private void sendListener(Personne item, int position) {
        for(int i = mListListener.size()-1; i >= 0; i--) {
            mListListener.get(i).onClickNom(item, position);
        }
    }

    /**
     * Interface pour écouter les évènements sur le nom d'une personne
     */
    public interface PersonneAdapterListener {
        public void onClickNom(Personne item, int position);
    }

}


