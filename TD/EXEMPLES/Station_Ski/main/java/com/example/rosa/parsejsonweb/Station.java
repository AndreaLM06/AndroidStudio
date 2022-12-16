package com.example.rosa.parsejsonweb;

/**
 * Created by Rosa on 02/03/2017.
 */

public class Station {


    private String nom;
    private String statut;
    private String type;
    private String geo;

    String getNom(){ return nom;}

    void setNom(String nom){ this.nom=nom;}

    String getGeo(){ return geo;}

    void setGeo(String geo){ this.geo=geo;}

    String getType(){ return type;}

    void setType(String type){ this.type=type;}

    String getStatut(){ return statut;}

    void setStatut(String statut){ this.statut=statut;}

    public Station(String nom,String statut, String type,String geo){this.nom=nom; this.type=type;this.statut=statut; this.geo=geo;}



    public String toSTring() { return "Station :" + nom + ".\n"+ "Statut : " +  statut + ".\n "  + "GPS : " +geo;}



}