package ie.dit.android.dit;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Slide;


@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class NewsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        // Activate toolbar from BaseActivity
        activateToolbar();

        setupWindowAnimations();

        // RECYCLERVIEW
        // Tutorial: binpress.com/tutorial/android-l-recyclerview-and-cardview-tutorial/156
        RecyclerView newsList = (RecyclerView) findViewById(R.id.cardList);
        newsList.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        newsList.setLayoutManager(linearLayoutManager);

        //TODO: finish recyclerview
    }


    private void setupWindowAnimations() {
        Slide slide = new Slide(5);
        getWindow().setExitTransition(slide);
    }
}
