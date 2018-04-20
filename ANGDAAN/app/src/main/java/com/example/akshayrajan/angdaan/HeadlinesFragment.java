package com.example.akshayrajan.angdaan;

import android.app.Activity;
import android.app.Fragment;
import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;



public class HeadlinesFragment extends ListFragment {

    OnHeadlineSelectedListener callback;

    public interface OnHeadlineSelectedListener{
        public void onArticleSelected(int position);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try{
            callback = (OnHeadlineSelectedListener) activity;
        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString() + "must implement OnHeadlineSelectedListener");
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        int layout = android.R.layout.simple_list_item_1;
        String[] data = Ipsum.Headlines;

        setListAdapter(new ArrayAdapter<String>(getActivity(),layout,data));

    }

    @Override
    public void onStart() {
        super.onStart();

        Fragment f = getFragmentManager().findFragmentById(R.id.article_fragment);
        ListView v = getListView();
        if(f != null && v!= null){
            v.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        callback.onArticleSelected(position);

        l.setItemChecked(position,true);
    }
}
