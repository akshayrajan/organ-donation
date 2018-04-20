package com.example.akshayrajan.angdaan;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class witnessDetails extends Activity {

    private Button mbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.witnessdetails);

        mbutton = (Button) findViewById(R.id.Register);
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Main2Activity.class);
                Toast.makeText(getApplicationContext(), "Witness Details has been updated",
                        Toast.LENGTH_LONG).show();
                startActivity(i);
            }
        });

    }
}


