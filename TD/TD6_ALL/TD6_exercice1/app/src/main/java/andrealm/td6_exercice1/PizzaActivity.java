package andrealm.td6_exercice1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class PizzaActivity extends AppCompatActivity  {

Intent intent;

ListPizza listP = new ListPizza();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza);



       Pizza pizza = getIntent().getParcelableExtra("pizza");

        TextView txtprix = findViewById(R.id.textViewprix);
        TextView txtnom = findViewById(R.id.textViewnom);
        ImageView imgViewPizza = findViewById(R.id.imageViewpizza);
        ListView ListViewIngredient = findViewById(R.id.listViewIngredient);

        txtnom.setText("Nom de la pizza : "+pizza.getNom());
        txtprix.setText("Prix de la pizza : "+pizza.getPrix());
        imgViewPizza.setImageResource(pizza.getImgP());


        ListViewIngredient.setAdapter((ListAdapter) pizza.getListIngredient());




        /*List<Ingredient> lIngredient = new ArrayList<>();
        List<String> list = new ArrayList<>();

        for(Ingredient i : lIngredient){
            list.add(i.toString());
        }

        ListViewIngredient.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, list));*/

        //txtprix.setText(pizza.getPrix());

        //txtnom.setText(pizza.getNom());

        //imgViewPizza.setImageResource(pizza.getImgP());






    }

}

