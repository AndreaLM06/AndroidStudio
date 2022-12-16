package andrealm.td6_exercice3;

public class Personne {
    private String nom;
    private int sexe;
    private  boolean langC;
    private  boolean langCPP;
    private boolean langJava;

//----------------- constructeurs ---------------------

    /**
     * constructeur par défaut
     * une personne par défaut est une femme nommée "Grande Prêtresse"
     */
    public Personne(){
        nom="Grande Prêtresse";
        sexe=2;
        langC=true;
        langCPP=true;
        langJava=true;
    }

    /**
     * constructeur normal
     * @param n le nom
     * @param s le sexe
     * @param c connait le C
     * @param cpp connait le C++
     * @param java connait le java
     */
    public Personne(String n,int s,boolean c,boolean cpp,boolean java){
        nom=n;
        langC=c;
        langCPP=cpp;
        langJava=java;
        sexe=s;
    }
    String connaissance="";
    //----------- accesseurs -----------------------------
    public String getNom() {return nom;}
    public void setNom(String nom) {
        this.nom = nom;
    }
    public int getSexe() {


        return sexe;
    }
    public void setSexe(int sexe) {  this.sexe = sexe; }
    public String isLangC() {
        if(langC)
            return connaissance+="le langage C ";
        return null;
    }
    public void setLangC(boolean langC) {
        this.langC = langC;
    }
    public boolean isLangCPP() {
        return langCPP;
    }
    public void setLangCPP(boolean langCPP) {
        this.langCPP = langCPP;
    }
    public boolean isLangJava() {
        return langJava;
    }
    public void setLangJava(boolean langJava) {
        this.langJava = langJava;
    }

    @Override
    public  String toString(){
        String leSexe;
        if (getSexe()==1) leSexe="un homme"; else leSexe="une femme";

        if(langCPP) connaissance+="le langage C++ ";
        if(langJava) connaissance+="le langage Java ";

        String txtA = R.string.txt_toString1;

        return getNom() +txtA + leSexe;
    }

}

