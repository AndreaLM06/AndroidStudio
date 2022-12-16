package andreaLM.example.td4_exercice1;


import java.util.ArrayList;

public class ListPizza {

    ArrayList<Pizza> listPizza;

    public ListPizza(){
        listPizza = new ArrayList<Pizza>();
    }

    public int size(){
        return listPizza.size();
    }

    public Pizza get(int pos){
        return listPizza.get(pos);
    }

    public void construireListe(){

        listPizza.add(new Pizza(R.drawable.pizza1, "Fromage", "13"));
        listPizza.add(new Pizza(R.drawable.pizza2,"Chorizo", "6"));
        listPizza.add(new Pizza(R.drawable.pizza3,"Royale", "10"));
        listPizza.add(new Pizza(R.drawable.pizza4,"Calzone", "8"));
        listPizza.add(new Pizza(R.drawable.pizza5,"Regina", "11"));




    }
}
