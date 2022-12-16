package andreaLM.td1_exercice4;

public class Personne {
    private String nom;
    private String sexe;
    private String[] langages;

    public Personne(String nom, String sexe, String[] langages){
        this.nom=nom;
        this.sexe=sexe;
        this.langages=langages;
    }

    public String getNom() {
        return nom;
    }

    public String getSexe() {
        return sexe;
    }

    public String[] getLangages() {
        return langages;
    }

    public String toString(){
        return nom+" vous êtes de sexe "+sexe", vous connaissez le language" +langages;
    }

}
