package andrealm.td6_exercice1;

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

    public ArrayList<Pizza> getListPizza(){return listPizza;}

    public void construireListe(){

        //creat some list of ingredients
        ArrayList<Ingredient> listIngredient1 = new ArrayList<>();
        listIngredient1.add(new Ingredient("tomate",20,"dl"));
        listIngredient1.add(new Ingredient("poivron",1,""));
        listIngredient1.add(new Ingredient("Chorizo",50,"g"));
        listIngredient1.add(new Ingredient("mozarella",50,"g"));

        ArrayList<Ingredient> listIngredient2 = new ArrayList<>();
        listIngredient2.add(new Ingredient("tomate",20,"dl"));
        listIngredient2.add(new Ingredient("oignon",2,""));
        listIngredient2.add(new Ingredient("poulet",200,"g"));
        listIngredient2.add(new Ingredient("emmental",150,"g"));

        ArrayList<Ingredient> listIngredient3 = new ArrayList<>();
        listIngredient3.add(new Ingredient("tomate",25,"dl"));
        listIngredient3.add(new Ingredient("emmental",100,"g"));

        ArrayList<Ingredient> listIngredient4 = new ArrayList<>();
        listIngredient4.add(new Ingredient("tomate",20,"dl"));
        listIngredient4.add(new Ingredient("champignon",100,"g"));
        listIngredient4.add(new Ingredient("jambon",150,"g"));
        listIngredient4.add(new Ingredient("emmental",150,"g"));

        ArrayList<Ingredient> listIngredient5 = new ArrayList<>();
        listIngredient5.add(new Ingredient("tomate",20,"dl"));
        listIngredient5.add(new Ingredient("champignon",100,"g"));
        listIngredient5.add(new Ingredient("jambon",150,"g"));
        listIngredient5.add(new Ingredient("emmental",150,"g"));

        ArrayList<Ingredient> listIngredient6 = new ArrayList<>();
        listIngredient6.add(new Ingredient("tomate",20,"dl"));
        listIngredient6.add(new Ingredient("bleu",50,"g"));
        listIngredient6.add(new Ingredient("gouda",50,"g"));
        listIngredient6.add(new Ingredient("emmental",100,"g"));


        listPizza.add(new Pizza("Fromage", 4, R.drawable.pizza3, listIngredient4));
        listPizza.add(new Pizza("Chorizo", 9, R.drawable.pizza2, listIngredient1));
        listPizza.add(new Pizza("Poulet", 5, R.drawable.pizza1, listIngredient2));
        listPizza.add(new Pizza("Royale", 7, R.drawable.pizza7, listIngredient6));
        listPizza.add(new Pizza("Calzone", 2, R.drawable.pizza4, listIngredient4));
        listPizza.add(new Pizza("Regina", 8, R.drawable.pizza5, listIngredient6));
        listPizza.add(new Pizza("indienne", 2, R.drawable.pizza6, listIngredient5));
        listPizza.add(new Pizza("Végetarienne",7, R.drawable.pizza9, listIngredient3));




    }


}