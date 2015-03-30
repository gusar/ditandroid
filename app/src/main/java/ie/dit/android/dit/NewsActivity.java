package ie.dit.android.dit;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Slide;
import android.widget.Toast;

import java.util.List;


@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class NewsActivity extends BaseActivity {

    private List<News> news;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        // Activate toolbar from BaseActivity
        activateToolbar();
        setupWindowAnimations();

        ProcessNews processNews = new ProcessNews();
        processNews.execute();
        handleNewsList(processNews.getNews());

        // RECYCLERVIEW
        // Tutorial: binpress.com/tutorial/android-l-recyclerview-and-cardview-tutorial/156
        RecyclerView newsList = (RecyclerView) findViewById(R.id.cardList);
        newsList.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        newsList.setLayoutManager(linearLayoutManager);

        //TODO: finish recyclerview
    }


    // Show news titles as toasts
    private void handleNewsList(List<News> news) {
        this.news = news;

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                for(News news : NewsActivity.this.news) {
                    Toast.makeText(NewsActivity.this, news.getNewsName(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }


/*    @Override
    protected void onResume() {
        super.onResume();
        ProcessNews processNews = new ProcessNews();
        processNews.execute();
    }*/


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
                news = getNews();
            }
        }
    }


    private void setupWindowAnimations() {
        Slide slide = new Slide(5);
        getWindow().setExitTransition(slide);
    }
}
