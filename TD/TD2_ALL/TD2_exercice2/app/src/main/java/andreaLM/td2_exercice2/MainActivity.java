package andreaLM.td2_exercice2;
import android.graphics.drawable.AnimationDrawable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView img = (ImageView)findViewById(R.id.imageView);
        img.setBackgroundResource(R.drawable.monanimation);
        AnimationDrawable anim= (AnimationDrawable)img.getBackground();
        anim.start();
    }
}