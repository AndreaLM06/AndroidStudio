package andreaLM.td2_exercice3;



import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private static final String ANIM_LENGTH_PREF = "speed for button reapearition";
    private static final String LIST_BUTTON = "list Of Button";

    private final Map<Button, Integer> buttonAnim = new HashMap(); //Liste des boutons et leur animation associée (sauf bouton "Réapparition")
    private final Set<Button> buttons = new HashSet<>();   //(ce sont les mêmes que les entrées du HashMap)

    private SeekBar sBar;
    private TextView tView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sBar = (SeekBar) findViewById(R.id.seekBar);
        tView = (TextView) findViewById(R.id.textView);
        tView.setText(sBar.getProgress() + "/" + sBar.getMax());
        sBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tView.setText(progress + "/" + seekBar.getMax());

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //write custom code to on start progress
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //tView.setText(valeur + "/" + seekBar.getMax());
            }
        });


        buttonAnim.put(findViewById(R.id.fondu), R.anim.fondu_anim);
        buttonAnim.put(findViewById(R.id.retrecissement), R.anim.retrecissement_anim);
        buttonAnim.put(findViewById(R.id.sortie), R.anim.sortie_anim);
        buttonAnim.put(findViewById(R.id.fondu_agrandissement), R.anim.fondu_agrandissement_anim);
        buttonAnim.put(findViewById(R.id.tv_off), R.anim.tv_off_anim);


        for (Map.Entry map : buttonAnim.entrySet()) {
            Button btn = (Button) map.getKey();
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    v.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, (Integer) map.getValue()));
                    v.setVisibility(View.INVISIBLE);
                    buttons.add((Button) v);
                }
            });

        }

        findViewById(R.id.reapparition).setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (Button b : buttons) {
                    b.setVisibility(b.VISIBLE);
                    b.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.reapparition));
                }
                buttons.clear();
            }

        });



    }

}



