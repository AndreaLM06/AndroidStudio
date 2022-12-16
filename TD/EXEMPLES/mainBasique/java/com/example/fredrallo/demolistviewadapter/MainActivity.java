package com.example.fredrallo.demolistviewadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView maListeView;
    int tabImages[] = {R.mipmap.c3po, R.mipmap.leia, R.mipmap.sol, R.mipmap.vador, R.mipmap.yoda};
    String tabNoms[] = {"C3PO" , "Leila" , "Sol", "Vador" , "Yoda"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        maListeView = findViewById(R.id.maListView);

        maListeView.setAdapter( new CustomAdapter(MainActivity.this, tabImages, tabNoms));
    }
}
