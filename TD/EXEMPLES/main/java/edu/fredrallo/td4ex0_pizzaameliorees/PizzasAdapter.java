package edu.fredrallo.td4ex0_pizzaameliorees;
import android.util.Log;
import android.widget.*;
import android.content.*;
import android.view.*;
import android.graphics.*;
import android.view.View.*;
/**
 * Modify by Fred on 01/02/2021.
 */

public class PizzasAdapter<on> extends BaseAdapter {
    private PizzaAdapterListner pizzaListner;
    private ListPizza pizzas;
    private Pizza choosenPizza;

    //Le contexte dans lequel est présent notre adapter
    private Context context;

    //Un mécanisme pour gérer l'affichage graphique depuis un layout XML
    private LayoutInflater mInflater;


    public PizzasAdapter(Context context, ListPizza pizzas) {
        this.context = context;
        this.pizzas = pizzas;
        mInflater = LayoutInflater.from(this.context);
    }

    public int getCount() {
        return pizzas.size();
    }

    public Object getItem(int position) { return pizzas.get(position);  }

    public long getItemId(int position) {
        return position;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout layoutItem;

        //(1) : Réutilisation des layouts
        if (convertView == null) {
            //Initialisation de notre item à partir du  layout XML ""
            layoutItem = (LinearLayout) mInflater.inflate(R.layout.pizza_layout, parent, false);
        } else {
            layoutItem = (LinearLayout) convertView;
        }

        //(2) : Récupération des TextView de notre layout
        TextView tvName = layoutItem.findViewById(R.id.pizzaName);
        TextView tvPrice = layoutItem.findViewById(R.id.pizzaPrice);
        ImageView pizzaPicture = layoutItem.findViewById(R.id.pizzaPicture);

        //(3) : Renseignement des valeurs
        tvName.setText(pizzas.get(position).getName());
        if (pizzas.get(position)==choosenPizza) {
            tvName.setTextSize(30); tvName.setTypeface(null, Typeface.BOLD_ITALIC);
        }
        else {
            tvName.setTextSize(22); tvName.setTypeface(null, Typeface.NORMAL);
        }
        tvName.setText(pizzas.get(position).getName());
        tvPrice.setText(  Float.toString(pizzas.get(position).getPrice()) +
                          (((int)(pizzas.get(position).getPrice()*100))%10 == 0 ? "0" : "") +
                          "€");  //TODO change uggly text format
        pizzaPicture.setImageResource(pizzas.get(position).getPicture());

        //(4) Changement de la couleur du fond de notre item
        tvPrice.setTextColor( pizzas.get(position).getPrice() >= 5 ? Color.RED : Color.BLACK);


        layoutItem.setOnClickListener( view -> {   //c'est beau avec une écriture fonctionnelle !
                choosenPizza = (pizzas.get(position) == choosenPizza ? null : pizzas.get(position));
                pizzaListner.onClickName(position);
            });

        //On retourne l'item créé.
        return layoutItem;
    }

    //abonnement pour click sur le nom...
    public void addListener(PizzaAdapterListner aListener) {
        pizzaListner = aListener;
    }

}




