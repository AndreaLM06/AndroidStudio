package andrealm.td8_exercice1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class FragmentDisplayValue extends Fragment {
    private final String TAG = "Andrea " + getClass().getSimpleName();
    private int resultValue;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //récupération de la valeur de la table
        Bundle arguments = getArguments();
        if(arguments!=null)  {
            resultValue = getArguments().getInt(getString(R.string.value));
        }
        Log.d(TAG,"resultValue="+ resultValue);
    }



    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_display, null);
        final ListView listview = (ListView) rootView.findViewById(R.id.listView);

        final ArrayList<String> ListStringMul= new ArrayList<String>();

        for (int i=0; i<=10; i++) {
            int mul = i * resultValue;
            String resu = i + " * " + resultValue + " = " + mul;
            ListStringMul.add(resu);
        }


        ArrayAdapter adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, ListStringMul);
        listview.setAdapter(adapter);

        return rootView;
    }


}