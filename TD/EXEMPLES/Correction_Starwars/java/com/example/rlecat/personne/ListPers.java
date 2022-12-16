package com.example.rlecat.personne;

import android.media.Image;
import java.util.ArrayList;


    public class ListPers {

        ArrayList<Personne> list;

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


            list.add(new Personne("amidala", R.mipmap.amidala,"blabla pour Amidala "));
            list.add(new Personne("blue", R.mipmap.blue,"blabla pour Blue "));
            list.add(new Personne("c3po", R.mipmap.c3po,"Droïde protocolaire de série 3PO en armature dorée  "));
            list.add(new Personne("calrissian", R.mipmap.calrissian,"blabla pour Calrissian "));

        }


    }


