package com.example.rosa.plusieursactivitysobjets;

/**
 * Created by Rosa
 */
import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable
{
    private String nom;
    private String prenom;

    public User(String nom, String prenom)
    {

        this.nom = nom;
        this.prenom = prenom;

    }

    public User(Parcel in) {
        this.nom = in.readString();
        this.prenom = in.readString();

    }
    @Override
    public int describeContents()
    {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeString(nom);
        dest.writeString(prenom);

    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>()
    {
        @Override
        public User createFromParcel(Parcel source)
        {
            return new User(source);
        }

        @Override
        public User[] newArray(int size)
        {
            return new User[size];
        }
    };

    public String getNom()
    {
        return nom;
    }

    public String getPrenom()
    {
        return prenom;
    }


    public static Parcelable.Creator<User> getCreator()
    {
        return CREATOR;
    }

}
