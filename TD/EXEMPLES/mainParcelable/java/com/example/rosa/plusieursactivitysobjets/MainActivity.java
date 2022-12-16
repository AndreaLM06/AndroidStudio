package com.example.rosa.plusieursactivitysobjets;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button connectBtn = (Button) findViewById(R.id.connect);
        connectBtn.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                User user = new User("LECAT", "Rosa");
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("user", user);
                startActivity(intent);
            }
        });
    }

}