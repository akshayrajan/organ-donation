package com.example.akshayrajan.angdaan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**a
 * Created by akshay rajan on 09-03-2018.
 */

public class screen3 extends Activity{
    private Button mbutton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen3);

        mbutton = (Button) findViewById(R.id.donor);
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),HospitalFragment.class);
                startActivity(i);
            }
        });
    }
}
