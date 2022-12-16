package andrealm.td8_exercice1;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

/**
 * this demo is just for exercice! Pattern is
 * never forget
 *  - all fragments dispose a default builder
 *  - all fragments are independents
 *
 *  TODO: better idea ==> fragmentGetValue don't call fragmentDisplayValue directelly
 */
public class MainActivity extends AppCompatActivity {
    private final String TAG = "Andrea " + getClass().getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.frame_input, new FragmentGetValue()) .commit();
        }
    }
}