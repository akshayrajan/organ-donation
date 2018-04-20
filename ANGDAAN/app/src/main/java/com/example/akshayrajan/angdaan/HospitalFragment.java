package com.example.akshayrajan.angdaan;
import android.content.Intent;
import android.os.Bundle;
        import android.app.Activity;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HospitalFragment extends Activity implements HeadlinesFragment.OnHeadlineSelectedListener{

    private Button mbutton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.container)!=null){
            if(savedInstanceState != null){
                return;
            }

            HeadlinesFragment headlinesFragment = new HeadlinesFragment();

            headlinesFragment.setArguments(getIntent().getExtras());

            getFragmentManager().beginTransaction()
                    .add(R.id.container,headlinesFragment)
                    .commit();


        }

    }

    @Override
    public void onArticleSelected(int position) {
        ArticleFragment articleFragment = (ArticleFragment) getFragmentManager().findFragmentById(R.id.article_fragment);


        if(articleFragment != null){
            articleFragment.updateArticleView(position);
        }else {
            ArticleFragment swapFragment = new ArticleFragment();
            Bundle args = new Bundle();
            args.putInt(ArticleFragment.ARG_POSITION,position);
            swapFragment.setArguments(args);

            getFragmentManager().beginTransaction()
                    .replace(R.id.container,swapFragment)
                    .addToBackStack(null)
                    .commit();
        }
    }
}

