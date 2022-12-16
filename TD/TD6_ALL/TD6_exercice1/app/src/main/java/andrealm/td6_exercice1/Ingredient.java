package andrealm.td6_exercice1;

public class Ingredient {

    String nom;
    int quantite;
    String unite;

    public Ingredient (String nom, int quantite, String unite){
        this.nom=nom;
        this.quantite=quantite;
        this.unite=unite;
    }


    public String toString(){
        return this.nom + this.quantite + this.unite;
    }


}
