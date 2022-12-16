package andreaLM.example.td4_exercice1;

public class Pizza {
    private String nom;
    private String prix;
    private int imgP;


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrix() {return prix;}

    public void setPrix(String prix) {this.prix = prix;}

    public int getImgP(){return imgP;}

    public void setImgP(int imgP) {this.imgP = imgP;}

    public Pizza(int aImgP, String aNom, String aPrix) {
        nom = aNom;
        prix= aPrix;
        imgP = aImgP;
    }


}