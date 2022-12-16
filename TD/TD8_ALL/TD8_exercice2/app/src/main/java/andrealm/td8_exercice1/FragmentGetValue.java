package andrealm.td8_exercice1;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class FragmentGetValue extends Fragment {
    private final String TAG = "frallo " + getClass().getSimpleName();
    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_input_value, container, false);
        EditText inputValue = (EditText)rootView.findViewById(R.id.inputValue);

        rootView.findViewById(R.id.ok).setOnClickListener( clic -> {
            Fragment fragment;
            FragmentTransaction fragmentTransaction;
            int longueur = inputValue.getText().length();
            if (longueur != 0) {
                String saisie = inputValue.getText().toString();
                int valeurSaisie = Integer.parseInt(saisie);
                fragment = new FragmentDisplayValue();
                Bundle args = new Bundle();
                args.putInt(getString(R.string.value), valeurSaisie);
                fragment.setArguments(args);
                Log.d(TAG,"args="+args);
                //close keyboard
                InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(inputValue.getWindowToken(), 0);
                inputValue.setText("");
                try {
                    fragmentTransaction = getParentFragmentManager().beginTransaction().replace(R.id.frame_display_value, fragment);
                    fragmentTransaction.commit();
                } catch (Exception e) {
                    e.printStackTrace();    //erreur fragment non créé
                }
            }
        });

        return rootView;
    } //end onCreate
}