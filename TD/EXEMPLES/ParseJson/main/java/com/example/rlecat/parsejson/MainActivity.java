package com.example.rlecat.parsejson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListRecettes list= new ListRecettes();
        list.construireListe(this);
        ListView listV = (ListView) findViewById(R.id.listView);

        //On passe nos données au composant ListView






        ArrayList<String> liste=new ArrayList<String>();
        for(int i=0;i<list.size();i++)
            liste.add(list.get(i).toString());



        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, liste);

        listV.setAdapter(adapter);




    }
}
