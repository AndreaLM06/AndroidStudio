package edu.fredrallo.td4ex0_pizzaameliorees;


import java.util.ArrayList;
import java.util.List;

/**
 * Modify by Fred on 09/02/2021.
 */
public class ListPizza extends ArrayList<Pizza>{
    public  ListPizza(){
        List<Ingredient> ingredients;
        ingredients = new ArrayList<Ingredient>();ingredients.add(Ingredient.FROMAGE);ingredients.add(Ingredient.CHAMPIGNON);ingredients.add(Ingredient.OLIVE);
        add(new Pizza("Fromage", 4, R.drawable.pizza3, ingredients));

        ingredients = new ArrayList<Ingredient>();ingredients.add(Ingredient.FROMAGE);ingredients.add(Ingredient.OLIVE);
        add(new Pizza("Chorizo", 9, R.drawable.pizza2, ingredients));

        ingredients = new ArrayList<Ingredient>();ingredients.add(Ingredient.FROMAGE);ingredients.add(Ingredient.CHAMPIGNON);ingredients.add(Ingredient.OLIVE);
        add(new Pizza("Royale", 7, R.drawable.pizza7, ingredients));

        ingredients = new ArrayList<Ingredient>();ingredients.add(Ingredient.FROMAGE);ingredients.add(Ingredient.CHAMPIGNON);
        add(new Pizza("Calzone", 2, R.drawable.pizza4, ingredients));

        ingredients = new ArrayList<Ingredient>();ingredients.add(Ingredient.FROMAGE);ingredients.add(Ingredient.OLIVE);
        add(new Pizza("Regina", 8, R.drawable.pizza5, ingredients));

        ingredients = new ArrayList<Ingredient>();ingredients.add(Ingredient.OLIVE);
        add(new Pizza("indienne", 2, R.drawable.pizza6, ingredients));

        ingredients = new ArrayList<Ingredient>();ingredients.add(Ingredient.CHAMPIGNON);
        add(new Pizza("Speciale", 2, R.drawable.pizza8, ingredients));

        ingredients = new ArrayList<Ingredient>();ingredients.add(Ingredient.CHAMPIGNON);ingredients.add(Ingredient.OLIVE);
        add(new Pizza("Végetarienne",7, R.drawable.pizza9, ingredients));
    }
}

