package andrealm.td6_exercice1;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Pizza implements Parcelable {
    private String nom;
    private int prix;
    private int imgP;
    ArrayList<Ingredient> listIngredient;

    public static final Creator<Pizza> CREATOR = new Creator<Pizza>() {
        @Override
        public Pizza createFromParcel(Parcel in) {
            return new Pizza(in);
        }

        @Override
        public Pizza[] newArray(int size) {
            return new Pizza[size];
        }
    };




    public Pizza (String aNom, int aPrix,  int aImgP,ArrayList<Ingredient> listIngredient) {
        nom = aNom;
        prix = aPrix;
        imgP = aImgP;
       // this.listIngredient=listIngredient;
    }

    public Pizza (Parcel in){
        this.nom=in.readString();
        this.prix=in.readInt();
        this.imgP=in.readInt();
       this.listIngredient=in.readParcelable(ListPizza.class.getClassLoader());

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nom);
        parcel.writeInt(prix);
        parcel.writeInt(imgP);
        parcel.writeParcelable((Parcelable) this.listIngredient, i);

    }

    public String getNom() {
        return nom;
    }
    public int getPrix() {
        return prix;
    }
    public int getImgP() {
        return imgP;
    }
    public ArrayList<Ingredient> getListIngredient() {return listIngredient;}
}
