package com.example.rlecat.personne;


/**
 * Created by Rosa on 01/02/2019.
 */
public class Personne {

    private String nom;
    private int photo;
    private String remarques;

    public Personne(String nom, int photo,String remarques) {
        this.nom = nom;
        this.photo=photo;
        this.remarques=remarques;

    }

    public Personne(){}

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }


    public int getPhoto() {
        return photo;
    }
    public void setPhoto(int nom) {
        this.photo = photo;
    }


    public String getRemarques() {
        return remarques;
    }
    public void setRemarques(String remarques) {
        this.remarques = remarques;
    }






    @Override
    public String toString(){
        return
                "nom='" + nom + '\'' +
                ", remarques=" + remarques  ;


    }
}
