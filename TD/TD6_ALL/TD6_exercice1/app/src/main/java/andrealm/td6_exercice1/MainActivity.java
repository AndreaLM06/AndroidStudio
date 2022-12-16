package andrealm.td6_exercice1;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import andrealm.td6_exercice1.PizzaAdapter;
import andrealm.td6_exercice1.PizzaAdapterListener;


public class MainActivity extends AppCompatActivity implements PizzaAdapterListener{


    //Creation et initialisation de l'Adapter pour les pizzas
    private PizzaAdapter adapter;
    private ListPizza listP = new ListPizza();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listP.construireListe();

        ListView list = (ListView) findViewById(R.id.listView);

        adapter = new PizzaAdapter(this, listP);

        list.setAdapter(adapter);

        adapter.addListener(this);

       list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                onClickNom(i);
           }
       });
    }

    public void onClickNom (int i){
        Intent intent = new Intent(MainActivity.this, PizzaActivity.class);
        intent.putExtra("pizza", listP.get(i));
        startActivity(intent);
    }

    private ArrayList<PizzaAdapterListener> mListListener = new ArrayList<PizzaAdapterListener>();

    @Override
    public void onClickNom(Pizza item, int position) {

    }
}


