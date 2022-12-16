package com.example.listviewexample;

/**
 * Created by Rosa on 03/02/2020.
 */
public class Personne {
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

   private String nom;

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    private String prenom;

    public int getGenre() {
        return genre;
    }

    public void setGenre(int genre) {
        this.genre = genre;
    }

    private int genre;

        public Personne(String aNom, String aPrenom, int aGenre) {
            nom = aNom;
            prenom = aPrenom;
            genre = aGenre;
        }
}
