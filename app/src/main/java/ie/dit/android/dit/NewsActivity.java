package ie.dit.android.dit;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Slide;

import java.util.ArrayList;
import java.util.List;


@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class NewsActivity extends BaseActivity {

    private static final String LOG_TAG = NewsActivity.class.getSimpleName();
    private List<News> news = new ArrayList<News>();
    private RecyclerView mRecyclerView;
    private NewsRecyclerViewAdapter mNewsRecyclerViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        // Activate toolbar from BaseActivity
        activateToolbar();
        setupWindowAnimations();

        // Setup RecyclerView
        mRecyclerView = (RecyclerView) findViewById(R.id.news_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mNewsRecyclerViewAdapter = new NewsRecyclerViewAdapter(NewsActivity.this, new ArrayList<News>());
        mRecyclerView.setAdapter(mNewsRecyclerViewAdapter);

//        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickLi);


    }


    // On activity resume download and parse data
    @Override
    protected void onResume() {
        super.onResume();
        ProcessNews processNews = new ProcessNews();
        processNews.execute();
    }


    // Download and parse data; create news objects
    public class ProcessNews extends ParseNewsJsonData {
        public ProcessNews() {
            super();
        }

        public void execute() {
//            super.execute();
            ProcessData processData = new ProcessData();
            processData.execute();
        }

        public class ProcessData extends DownloadJsonData {
            protected void onPostExecute(String webData) {
                super.onPostExecute(webData);
                mNewsRecyclerViewAdapter.loadNewData(getNews());
            }
        }
    }


    private void setupWindowAnimations() {
        Slide slide = new Slide(5);
        getWindow().setExitTransition(slide);
    }
}
