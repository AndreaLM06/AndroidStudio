package andrealm.example.td5_exercice2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListPers maListe = new ListPers();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listview = findViewById(R.id.ListView);
        maListe.construireListe();

        ArrayList<Personne> liste = maListe.getList();
        ArrayList<String> listListView = new ArrayList<String>();

        for (int i = 0; i < liste.size(); i++)
            listListView.add(((maListe.getPers(i)).getNom()));

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listListView);
        listview.setAdapter(dataAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                onClickNom(i);

            }
        });




    }


    private ArrayList<PersonneAdapterListener> mListListener = new ArrayList<PersonneAdapterListener>();
    public void addListener(PersonneAdapterListener aListener) {
        mListListener.add(aListener);
    }
    private void sendListener(Personne item, int position) {
        for(int i = mListListener.size()-1; i >= 0; i--) {
            mListListener.get(i).onClickNom(item, position);
        }
    }

    public interface PersonneAdapterListener {
        public void onClickNom(Personne item, int position);
    }

    public void onClickNom(int position){
        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        intent.putExtra("personne", maListe.getPers(position));
        startActivity(intent);
    }

}