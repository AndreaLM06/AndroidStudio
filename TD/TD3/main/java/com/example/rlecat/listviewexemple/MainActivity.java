package com.example.rlecat.listviewexemple;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.*;
import android.view.MenuItem;
import android.view.inputmethod.CursorAnchorInfo;
import android.widget.*;
import java.util.*;


public class MainActivity extends AppCompatActivity implements PersonneAdapter.PersonneAdapterListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //addItemsListView();
        //Recuperation de la liste des personnes
        ListPers listP = new ListPers();
        listP.construireListe();

        //Creation et initialisation de l'Adapter pour les personnes
        PersonneAdapter adapter = new PersonneAdapter(this, listP);

        //Recuperation du composant ListView
        ListView list = (ListView) findViewById(R.id.listView);

        //Initialisation de la liste avec les donnees
        list.setAdapter(adapter);

        //Ecoute des enements sur la liste

        adapter.addListener(this);

    }


    public void onClickNom(Personne item, int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Personne");

        builder.setMessage("Vous avez clique sur : " + item.getNom());
        builder.setPositiveButton("Oui", null);
        builder.setNegativeButton("Non", null);
        builder.show();
    }
}


