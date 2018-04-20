package com.example.akshayrajan.angdaan;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class ArticleFragment extends Fragment {

    final static String ARG_POSITION = "postiton";
    private int currentPostion = -1;

    private Button mbutton = null;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        if (savedInstanceState != null) {
            currentPostion = savedInstanceState.getInt(ARG_POSITION);
        }
        final View myFragmentView = inflater.inflate(R.layout.article_fragment, container, false);
        mbutton = (Button) myFragmentView.findViewById(R.id.bookAppointment);
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),Main2Activity.class);
                startActivity(i);
                Toast.makeText(getActivity(), "check your email for appointment!",
                        Toast.LENGTH_SHORT).show();
                return;

            }
        });

        return myFragmentView;

    }


    public void updateArticleView(int position) {
        View v = getView();
        TextView article = (TextView) v.findViewById(R.id.article);
        String[] data = Ipsum.Articles;
        article.setText(data[position]);
        currentPostion = position;
    }

    @Override
    public void onStart() {

        super.onStart();

        Bundle args = getArguments();
        if (args != null) {
            updateArticleView(args.getInt(ARG_POSITION));
        } else if (currentPostion != -1) {
            updateArticleView(currentPostion);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(ARG_POSITION, currentPostion);


    }
}
