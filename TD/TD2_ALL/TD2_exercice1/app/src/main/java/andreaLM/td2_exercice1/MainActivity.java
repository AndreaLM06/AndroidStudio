package andreaLM.td2_exercice1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView pts;
    private Button btn_plus;
    private Button btn_moins;
    private int clics=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.clics = savedInstanceState.getInt("points");
        this.pts = (TextView) findViewById(R.id.textView);
        pts.setText("Points : "+clics);
        this.btn_moins=(Button) findViewById(R.id.button);
        this.btn_plus=(Button) findViewById(R.id.button2);

        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clics++;
                pts.setText("Points : "+clics);
            }
        });

        btn_moins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clics--;
                pts.setText("Points : "+clics);
            }
        });
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("points", clics);

    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        int clics = savedInstanceState.getInt("points");
    }
}