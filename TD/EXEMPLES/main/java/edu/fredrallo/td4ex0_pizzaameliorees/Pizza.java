package edu.fredrallo.td4ex0_pizzaameliorees;


import java.util.ArrayList;
import java.util.List;

/**
 * modify by Fred on 09/02/2021.
 */
public class Pizza {
    private static float EPSILON = 0.0001f;
    private List<Ingredient> ingredients = new ArrayList();
    private String name;
    private float price;
    private int picture;
    private float extraFromage=0f;
    private float extraChampignon=0f;
    private float extraOlive=0f;


    public Pizza(String name, float price,  int picture, List ingredients) {
        this.name = name;
        this.price = price;
        this.picture =picture;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }
    public float getPrice() { return Math.round((price+extraFromage+extraChampignon+extraOlive)*100) /100.0f; }
    public int getPicture(){ return picture; }
    public List<Ingredient> getIngredients(){ return ingredients; }
    public void setExtraFromage(float extraFromage) {  this.extraFromage = extraFromage; }
    public void setExtraChampignon(float extraChampignon) {  this.extraChampignon = extraChampignon; }
    public void setExtraOlive(float extraOlive) {  this.extraOlive = extraOlive; }
    public boolean isExtra() { return (extraFromage+extraChampignon+extraOlive)>EPSILON; }

    @Override
    public String toString(){
        return "nom='" + name + '\'' + ", prix=" + price+extraFromage+extraChampignon+extraOlive;
    }
}
