package com.example.rosa.plusieursactivitysobjets;

/**
 * Created by Rosa
 */
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends Activity
{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        User user = getIntent().getExtras().getParcelable("user");
        TextView displayUser = (TextView) findViewById(R.id.displayUser);
        displayUser.setText("User : " + "\n" + " NOM : " + user.getNom());

    }
}
