package edu.fredrallo.td4ex0_pizzaameliorees;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements PizzaAdapterListner{
    public static final float ALPHA = 0.5f;
    private ListPizza listPizza;
    private PizzasAdapter adapter;
    private Button button;
    private Pizza currentPizza;
    SeekBar seekBarFromage;
    SeekBar seekBarOlive;
    SeekBar seekBarChampignon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // On recupère les éléments graphiques
        button=findViewById(R.id.button);
        ListView listView=findViewById(R.id.listView);
        seekBarFromage = findViewById(R.id.seekBarFromage);
        seekBarOlive = findViewById(R.id.seekBarOlive);
        seekBarChampignon = findViewById(R.id.seekBarChampignon);

        button.setAlpha(ALPHA);
        button.setEnabled(false);
        listPizza = new ListPizza();
        adapter = new PizzasAdapter(getApplicationContext(), listPizza);
        adapter.addListener(this);
        listView.setAdapter(adapter);

        updateQte(seekBarFromage, seekBarOlive, seekBarChampignon);
        button.setOnClickListener(button->submit());  //c'est beau avec une écriture fonctionnelle !
    }


    private void updateQte(SeekBar seekBarFromage, SeekBar seekBarOlive, SeekBar seekBarChampignon) {
        seekBarFromage.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateExtraPrices();
                ((TextView)findViewById(R.id.qteFromage)).setText(progress+"g");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });
        seekBarOlive.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateExtraPrices();
                ((TextView)findViewById(R.id.qteOlive)).setText(progress+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });
        seekBarChampignon.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateExtraPrices();
                ((TextView)findViewById(R.id.qteChampignon)).setText(progress+"g");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });
    }

    private void updateExtraPrices(){
        int position=0;
        for (Pizza pizza : listPizza) {
            pizza.setExtraChampignon(seekBarChampignon.getProgress() > Ingredient.CHAMPIGNON.getQte() ? 0.02f * (seekBarChampignon.getProgress() - Ingredient.CHAMPIGNON.getQte()) : 0.0f);
            pizza.setExtraOlive(seekBarOlive.getProgress() > Ingredient.OLIVE.getQte() ? 0.2f * (seekBarOlive.getProgress() - Ingredient.OLIVE.getQte()) : 0.0f);
            pizza.setExtraFromage(seekBarFromage.getProgress() > Ingredient.FROMAGE.getQte() ? 0.05f * (seekBarFromage.getProgress() - Ingredient.FROMAGE.getQte()) : 0.0f);
            adapter.getItem(position);
            adapter.notifyDataSetChanged();
            position++;
        }
    }

    private void submit() {
        Log.d("Main_submitted","pizza submitted");
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("c'est partie ! " + currentPizza.getName() + (currentPizza.isExtra() ? " spéciale" : "") );
        builder.setMessage("prix : " + currentPizza.getPrice());
        builder.setPositiveButton("OK", null);
        builder.setNegativeButton("Annuler", null);
        builder.show();
    }

    @Override
    public void onClickName(int position) {
        adapter.getItem(position);   // necessary to prepare notification
        adapter.notifyDataSetChanged();
        if ( currentPizza == listPizza.get(position)){
            currentPizza=null;
            button.setAlpha(ALPHA);
            button.setEnabled(false);
        }
        else {
            currentPizza = listPizza.get(position);
            button.setAlpha(1);
            button.setEnabled(true);
        }
    }
}
