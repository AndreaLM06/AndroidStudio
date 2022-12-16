package andrealm.example.td5_exercice2;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



    public class ResultActivity extends AppCompatActivity {

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_result);


            Personne pers = getIntent().getParcelableExtra("personne");


            TextView txtNom = findViewById(R.id.textViewPers);
            ImageView Imgphoto = findViewById(R.id.imageViewPers);
            TextView txtRemarque = findViewById(R.id.textViewPers2);

            txtNom.setText("Personnage : "+pers.getNom());
            txtRemarque.setText(pers.getRemarques());
            Imgphoto.setImageResource(pers.getPhoto());





        }


    }




