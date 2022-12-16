package andrealm.td7_exercice1;

public class Musee {


    private String nom;

    private String geo;


    public Musee(String nom, String geo) {
        this.nom = nom;

        this.geo = geo;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getGeo() {
        return geo;
    }

    public void setGeo(String geo) {
        this.geo = geo;
    }

    public String toSTring() {
        return getNom() + ".\n"  + "GPS : " +getGeo();
    }
}