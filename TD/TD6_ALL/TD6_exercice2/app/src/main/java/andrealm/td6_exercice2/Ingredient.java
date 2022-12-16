package andrealm.td6_exercice2;

public class Ingredient {
    private String nom;
    private int prix;

    public Ingredient(String nom,int prix){
        this.setNom(nom);
        this.setPrix(prix);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    @Override
    public String toString(){
        return "Ingredient= " + nom +"  prix= " + prix ;
    }
}
