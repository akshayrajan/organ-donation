package com.example.akshayrajan.angdaan;

/**
 * Created by akshay rajan on 10-04-2018.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;

public class immediateSearch extends Activity {


    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_immediate_searchfor_organ);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.exp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        // Listview Group click listener
        expListView.setOnGroupClickListener(new OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
//        expListView.setOnGroupExpandListener(new OnGroupExpandListener() {
//
//            @Override
//            public void onGroupExpand(int groupPosition) {
//                Toast.makeText(getApplicationContext(),
//                        listDataHeader.get(groupPosition) + " Expanded",
//                        Toast.LENGTH_SHORT).show();
//            }
//        });

//        // Listview Group collasped listener
//        expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {
//
//            @Override
//            public void onGroupCollapse(int groupPosition) {
//                Toast.makeText(getApplicationContext(),
//                        listDataHeader.get(groupPosition) + " Collapsed",
//                        Toast.LENGTH_SHORT).show();
//
//            }
//        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Columbia Asia");
        listDataHeader.add("St Johns Hospital");
        listDataHeader.add("Narayana Hospital");
        listDataHeader.add("Jyoti Hospital");
        listDataHeader.add("Bowring Hospital");
        // Adding child data
        List<String> top250 = new ArrayList<String>();
        top250.add("Hearts replacements available");


        List<String> nowShowing = new ArrayList<String>();
        nowShowing.add("Hearts replacements available");
        nowShowing.add("Lungs replacements available");
        nowShowing.add("Kidneys replacements available");


        List<String> comingSoon = new ArrayList<String>();
        comingSoon.add("Liver replacements available");

        List<String> jyotiHospital = new ArrayList<String>();
        jyotiHospital.add("Hearts replacements available");
        jyotiHospital.add("Bone Marrow replacements available");

        List<String> BowringHospital = new ArrayList<String>();
        BowringHospital.add("Hearts replacements available");
        BowringHospital.add("Bone Marrow replacements available");

        listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
        listDataChild.put(listDataHeader.get(1), nowShowing);
        listDataChild.put(listDataHeader.get(2), comingSoon);
        listDataChild.put(listDataHeader.get(3), jyotiHospital);
        listDataChild.put(listDataHeader.get(4),BowringHospital);

    }
}