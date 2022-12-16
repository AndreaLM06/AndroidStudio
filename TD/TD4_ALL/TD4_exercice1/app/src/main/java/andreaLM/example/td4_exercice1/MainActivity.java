package andreaLM.example.td4_exercice1;

import android.app.AlertDialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements PizzaAdapter.PizzaAdapterListener {

public SeekBar pFromage;
public SeekBar pOlives;
public SeekBar pChampignons;

private TextView poidsFromages;
private TextView poidsOlives;
private TextView poidsChampignons;

private Button bCommander;

private double FromagesBonus;
private double OlivesBonus;
private double ChampignonsBonus;

public double bonus=0;

    //Creation et initialisation de l'Adapter pour les pizzas
    private PizzaAdapter adapter ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Recuperation de la liste des personnes
        ListPizza listP = new ListPizza();
        listP.construireListe();

//Recuperation du composant ListView
        ListView list = (ListView) findViewById(R.id.listView);

        adapter = new PizzaAdapter(this, listP);
        //Initialisation de la liste avec les donnees
        list.setAdapter(adapter);

        //Ecoute des evenements sur la liste

        adapter.addListener(this);

        //Creation et initialisation de l'Adapter pour les pizzas




        pFromage = (SeekBar)findViewById(R.id.seekBar1);
        pFromage.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //TODO Auto-generated method stub
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                //TODO Auto-generated method stub
                poidsFromages = (TextView)findViewById(R.id.poidsFromage);
                poidsFromages.setText(progress+" g");
                seekBar.setMax(100);
                if (progress>50)
                    FromagesBonus=progress;
                adapter.setBonus(Bonus());
                adapter.notifyDataSetChanged();
            }
        });


        pOlives = (SeekBar)findViewById(R.id.seekBar2);
        pOlives.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //TODO Auto-generated method stub
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                //TODO Auto-generated method stub
                poidsOlives = (TextView)findViewById(R.id.poidsOlives);
                poidsOlives.setText(progress+" ");
                seekBar.setMax(10);

                if (progress>3)
                    OlivesBonus=progress;
                adapter.setBonus(Bonus());
                adapter.notifyDataSetChanged();

            }
        });

        pChampignons = (SeekBar)findViewById(R.id.seekBar3);
        pChampignons.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //TODO Auto-generated method stub
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                //TODO Auto-generated method stub
                poidsChampignons = (TextView)findViewById(R.id.poidsChampignons);
                poidsChampignons.setText(progress+" g");
                seekBar.setMax(250);
                if (progress>80)
                    ChampignonsBonus=progress;

                adapter.setBonus(Bonus());
                adapter.notifyDataSetChanged();

            }
        });

        }



        public double Bonus(){
            return 0.02*(ChampignonsBonus-80) + 0.2*(OlivesBonus-3) + 0.05*(FromagesBonus-50);
        }





    public void onClickNom(Pizza item, int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("PIZZA spéciale");
        builder.setMessage("Vous avez clique sur : " + item.getNom()+"avec un bonus de : "+bonus);
        builder.setNeutralButton("OK", null);
        builder.show();
        bonus=0;

        bCommander = (Button) findViewById(R.id.Commander);
        bCommander.setEnabled(Boolean.parseBoolean("true"));


        bCommander.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.setTitle("C'est partie ! "+item.getNom());
                builder.setMessage("Prix : "+item.getPrix()+" €");
                builder.setNeutralButton("", null);
                builder.setPositiveButton("OK", null);
                builder.setNegativeButton("ANNULER", null);
                builder.show();
            }
        });

    }


}


