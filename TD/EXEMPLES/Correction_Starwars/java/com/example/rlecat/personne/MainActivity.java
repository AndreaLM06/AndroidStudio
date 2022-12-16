package com.example.rlecat.personne;

import android.app.AlertDialog;

import android.os.Bundle;
import android.view.*;

import android.widget.*;

import android.support.v7.app.AppCompatActivity;


import java.util.*;



import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListPers maListe= new ListPers();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        maListe.construireListe();
        addItemsOnSpinner();
        addListernerSpinner();


    }


    public void addListernerSpinner() {
        final Spinner sp = (Spinner) findViewById(R.id.spinner);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int n= sp.getSelectedItemPosition();
                Personne p= maListe.getPers(n);
                int photo=p.getPhoto();
                ImageView image = (ImageView) findViewById(R.id.imageView);
                image.setImageResource(photo);

                TextView t=(TextView) findViewById(R.id.textView);
                t.setText(p.getRemarques());

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(MainActivity.this, "Vous n'avez rien sélectionné", Toast.LENGTH_SHORT).show();

            }
        });
    }

        public void addItemsOnSpinner() {


            final Spinner sp = (Spinner) findViewById(R.id.spinner);
            ArrayList<Personne> liste= maListe.getList();
            ArrayList<String> listSp= new ArrayList<String>();
            for(int i=0;i<liste.size();i++)
                listSp.add(((maListe.getPers(i)).getNom()));
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, listSp);

            sp.setAdapter(dataAdapter);
        }


    }



