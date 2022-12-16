package andrealm.td6_exercice2;

import android.content.Context;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;



public class ListRecettes {

    List<Recette> list;
    public ListRecettes(){
        list = new ArrayList<Recette>();
    }

    public int size(){
        return list.size();
    }

    public Recette get(int pos){
        return list.get(pos);
    }

    public void construireListe(Context context){


        // Création de la liste des recettes


        try {
            // Récupération du fichier json

            JSONArray jsonArray = new JSONArray(getJSONFromAsset(context));

            // Récupération des recettes
            for(int i = 0; i < jsonArray.length(); i++) {
                list.add(getRecetteFromJSONObject(jsonArray.getJSONObject(i),context));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    private   Recette getRecetteFromJSONObject(JSONObject jsonObject, Context context) throws JSONException {

        //nom recette
        String nom = jsonObject.getString("nom");



        // duree
        int duree = jsonObject.getInt("duree");


        //recupération du nom de la photo
        String rphoto=(jsonObject.getString("photo"));


        //conversion du nom de la photo en une ressource int
        int photo= context.getResources().getIdentifier(rphoto, "mipmap",  context.getPackageName());


        // ingredients
        ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();

        for(int i = 0; i < jsonObject.getJSONArray("ingredients").length(); i++) {

            Ingredient ing = new Ingredient(
                    jsonObject.getJSONArray("ingredients").getJSONObject(i).getString("nom"),
                    jsonObject.getJSONArray("ingredients").getJSONObject(i).getInt("prix"));



            ingredients.add(ing);
        }
        Recette r= new Recette(nom, duree,ingredients);



        return r;
    }


    //lecture du fichier en string
    private  String getJSONFromAsset(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open("Recettes.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        return json;

    }


}