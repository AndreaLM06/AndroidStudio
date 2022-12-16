package andrealm.example.td5_exercice2;

import android.os.Parcel;
import android.os.Parcelable;

public class Personne implements Parcelable {

    public String nom;
    public int photo;
    public String remarques;

    public Personne(String nom, int photo,String remarques) {
        this.nom = nom;
        this.photo=photo;
        this.remarques=remarques;

    }



    public Personne(Parcel in) {
        this.nom = in.readString();
        this.photo = in.readInt();
        this.remarques = in.readString();
    }

    public static final Creator<Personne> CREATOR = new Creator<Personne>() {
        @Override
        public Personne createFromParcel(Parcel in) {
            return new Personne(in);
        }

        @Override
        public Personne[] newArray(int size) {
            return new Personne[size];
        }
    };



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nom);
        parcel.writeInt(photo);
        parcel.writeString(remarques);
    }

    public String getNom() {
        return nom;
    }

    public int getPhoto() {
        return photo;
    }

    public String getRemarques() {
        return remarques;
    }
}
