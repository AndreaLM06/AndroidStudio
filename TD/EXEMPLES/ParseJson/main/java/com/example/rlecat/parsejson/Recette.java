package com.example.rlecat.parsejson;

import java.util.ArrayList;

/**
 * Created by rlecat .
 */

public class Recette {
    public Recette(String nom, int duree, ArrayList<Ingredient> ingredients) {
            this.nom = nom;
            this.duree = duree;
            this.ingredients=ingredients;

        }



        private ArrayList<Ingredient> ingredients;
        public Recette(){}

        public String getNom() {
            return nom;
        }
        public void setNom(String nom) {
            this.nom = nom;
        }
        private String nom;

        public int getDuree() {
            return duree;
        }
        public void setDuree(int duree) {
            this.duree = duree;
        }
        private int duree;



        public ArrayList<Ingredient> getIngredients() {
            return ingredients;
        }

        public void setIngredients(ArrayList<Ingredient> ingredients) {
            this.ingredients = ingredients;
        }

        @Override
        public String toString() {

            String s="";
            s+= "Recette : " +
                    "nom: '" + nom + '\'' +
                    ", duree : " + duree  + '\n';

            for(int i = 0;i<ingredients.size();i++)
                s+=  ingredients.get(i).toString() + '\n' ;

            return s;
        }


}
