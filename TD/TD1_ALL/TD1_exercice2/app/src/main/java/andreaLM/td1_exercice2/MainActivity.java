package andreaLM.td1_exercice2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    public ImageView imgV;
    public Button bChange;
    public int i=0;
    public int[] images = {R.drawable.android, R.drawable.android3d};


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgV= (ImageView) findViewById(R.id.imageView2);
        bChange= (Button)findViewById(R.id.button2);


        bChange.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        imgV.setImageResource(images[i]);
                        i++;
                        if (i==2)
                            i=0;

                    }
                }
        );


    }

}