package com.example.listviewexample;

/**
 * Created by Rosa on 03/02/2020.
 */
import java.util.*;

public class ListPers  {
    ArrayList<Personne> listPers;

    public ListPers(){
        listPers = new ArrayList<Personne>();
    }

    public int size(){
     return listPers.size();
    }

    public Personne get(int pos){
        return listPers.get(pos);
    }

    public void construireListe(){

        listPers.add(new Personne("Nom1", "Prenom1", 2));
        listPers.add(new Personne("Nom2", "Prenom2", 1));
        listPers.add(new Personne("Nom3", "Prenom3", 1));
        listPers.add(new Personne("Nom4", "Prenom4", 2));
        listPers.add(new Personne("Nom5", "Prenom5", 2));
        listPers.add(new Personne("Nom6", "Prenom6", 1));
        listPers.add(new Personne("Nom7", "Prenom7", 1));
        listPers.add(new Personne("Nom8", "Prenom8", 1));
        listPers.add(new Personne("Nom9", "Prenom9", 1));
        listPers.add(new Personne("Nom10", "Prenom10", 1));
        listPers.add(new Personne("Nom11", "Prenom11", 1));
        listPers.add(new Personne("Nom12", "Prenom12", 1));
        listPers.add(new Personne("Nom13", "Prenom13", 2));
        listPers.add(new Personne("Nom14", "Prenom14", 1));


    }
}
