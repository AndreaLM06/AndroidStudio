package andrealm.example.td5_exercice2;

import java.util.ArrayList;

public class ListPers {


        public ArrayList<Personne> list;

        public ListPers(){
            list = new ArrayList<Personne>();
        }

        public int size(){
            return list.size();
        }

        public Personne getPers(int pos){
            return list.get(pos);
        }

        public ArrayList<Personne> getList(){
            return list;
        }

        public ArrayList<Personne> setList(){
            return list;
        }
        public void construireListe(){


            list.add(new Personne("amidala", R.drawable.amidala,"blabla pour Amidala "));
            list.add(new Personne("blue", R.drawable.blue,"blabla pour Blue "));
            list.add(new Personne("c3po", R.drawable.c3po,"Droïde protocolaire de série 3PO en armature dorée  "));
            list.add(new Personne("calrissian", R.drawable.calrissian,"blabla pour Calrissian "));

        }



}
