package com.example.fredrallo.td1ex4;
    import android.app.Activity;
    import android.os.Bundle;
    import android.view.*;
    import android.widget.*;

    /**
     * activité forcée en mode paysage dans le manifest
     */
    public class MainActivity extends Activity {
        Personne personne = new Personne();
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            final Button bouton = findViewById(R.id.button);

            bouton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    afficherResultat(bouton);
                }
            });
        }

    private void recupererNom(){
        EditText e = findViewById(R.id.editText);
        String nom=e.getText().toString();
        personne.setNom(nom);
    }

    private void recupererSexe(){
        RadioButton radionButtonSexe= findViewById(R.id.radioButton1);
        personne.setSexe( radionButtonSexe.isChecked()?1:2);
     }

     private void recupererLangage(){
        CheckBox langageC= findViewById(R.id.checkBoxC);
        CheckBox langageCpp= findViewById(R.id.checkBoxCpp);
        CheckBox langageJava= findViewById(R.id.checkBoxJava);
        personne.setLangC(langageC.isChecked());
        personne.setLangCPP(langageCpp.isChecked());
        personne.setLangJava(langageJava.isChecked());
    }

    /**
     * méthode appelée lorsqu'on appuie sur le bouton
     * @param v : obligatoire....
     */
    private void afficherResultat(View v){
        TextView txtReponse= findViewById(R.id.textView);
        recupererNom();
        recupererSexe();
        recupererLangage();
        txtReponse.setText(personne +"");
    }
}
