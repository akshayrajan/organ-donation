package com.example.akshayrajan.angdaan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

public class screen4 extends Activity {

    String[] myHospitalArray = new String[]{
            "Regal's Hospital",
            "Apollo Hospital",
            "Government Hospital",
            "Narayan Hospital",
            "ASR Hospital",
            "Fortis",
            "Good Will Hospital",
            "St.John's hospital",
            "Peter Hospital",
            "Nice Health Hospital",
            "Divine Hospital",
            "Akshay Hospital"
    };


    private ListView mListView;
    private ArrayAdapter mArrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen4);

        mListView = (ListView) findViewById(R.id.listofHospitals);

        mArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_selectable_list_item, myHospitalArray);

        if (mListView != null) {
            mListView.setAdapter(mArrayAdapter);

        }


    }
}
