package andrealm.td7_exercice1;


import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.*;

public class MainActivity extends AppCompatActivity {

    private String TAG = MainActivity.class.getSimpleName();

    private ProgressDialog pDialog;
    private ListView lv;


    private static String url = "http://opendata.nicecotedazur.org/data/storage/f/2014-06-24T17%3A26%3A11.347Z/export-musees-galeries.json";

    List<Musee> stationList;
    ArrayList<String> maListe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stationList = new ArrayList<Musee>();

        lv = (ListView) findViewById(R.id.list);

        new GetStations().execute();
    }

    /**
     * Tache asynchrone
     */
    private class GetStations extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Connexion en cours...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override

        // appelee automatiquement après onPreExecute
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();


            String jsonStr = sh.makeServiceCall(url);



            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);


                    JSONArray stations = jsonObj.getJSONArray("docs");


                    for (int i = 0; i < stations.length(); i++) {
                        JSONObject c = stations.getJSONObject(i);

                        String nom = c.getString("NOM");

                        // récupération  geometry objet
                        JSONObject geometry = c.getJSONObject("geometry");

                        String geo = geometry.getString("coordinates");

                        Musee st = new Musee(nom, geo);
                        //Musee st= new Musee(nom,statut);


                        stationList.add(st);
                    }

                } catch (final JSONException e) {
                    Log.e(TAG, "Erreur JSON " + e.getMessage());

                }
            } else {
                Log.e(TAG, "Probleme connexion ");
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            if (pDialog.isShowing())
                pDialog.dismiss();
            ArrayList<String> list = new ArrayList<String>();
            for(int i=0;i<stationList.size();i++)
                list.add(stationList.get(i).toSTring());


            // UTILER UN ADAPTER PLUS JOLI!!!
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1, list);

            lv.setAdapter(adapter);
        }

    }
}