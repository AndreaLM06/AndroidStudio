package edu.fredrallo.td4ex0_pizzaameliorees;

public enum Ingredient {
    FROMAGE(50),
    OLIVE(3) ,
    CHAMPIGNON(80);

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    int qte;
    Ingredient(int qte) {
        this.qte = qte;
    }


}
