package andrealm.td7_exercice2;


import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.*;

public class MainActivity extends AppCompatActivity {

    private String TAG = MainActivity.class.getSimpleName();

    private ProgressDialog pDialog;
    private String url = "https://www.prevision-meteo.ch/services/json/";
    Button bConnexion;
    EditText inputVille;

    EditText txtPays;
    EditText txtTemp;
    EditText txtLever;
    EditText txtCoucher;
    EditText txtCondition;









    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bConnexion = findViewById(R.id.buttonConnexion);




        bConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new GetMeteo().execute();
            }
        });



    }

    /**
     * Tache asynchrone
     */
    private class GetMeteo extends AsyncTask<Void, Void, Void> {
        Meteo meteo;


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
            inputVille = findViewById(R.id.InputVille);

            String ville = inputVille.getText().toString();
            url += ville;

            HttpHandler sh = new HttpHandler();
            String jsonStr = sh.makeServiceCall(url);


            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    JSONObject meteoInfoCity = jsonObj.getJSONObject("city_info");
                    JSONObject meteoCurrentCondition = jsonObj.getJSONObject("current_condition");
                    String pays = meteoInfoCity.getString("country");
                    String leverSoleil = meteoInfoCity.getString("sunrise");
                    String coucherSoleil = meteoInfoCity.getString("sunset");
                    String temperature = meteoCurrentCondition.getString("tmp");
                    String condition = meteoCurrentCondition.getString("condition");

                    meteo = new Meteo(pays, temperature, leverSoleil, coucherSoleil, condition);

                } catch (JSONException e) {
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

            if (pDialog.isShowing()) {pDialog.dismiss();}

            txtPays = findViewById(R.id.editTextPays);
            txtTemp = findViewById(R.id.editTextTMP);
            txtLever = findViewById(R.id.editTextLeverSoleil);
            txtCoucher = findViewById(R.id.editTextCoucherSoleil);
            txtCondition = findViewById(R.id.editTextCondition);

            txtPays.setText(meteo.getPays());
            txtTemp.setText(meteo.getTemperature());
            txtLever.setText(meteo.getLeverSoleil());
            txtCoucher.setText(meteo.getCoucherSoleil());
            txtCondition.setText(meteo.getCondition());




        }

    }
}