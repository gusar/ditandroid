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
public class CoursesActivity extends BaseActivity {

    private static final String LOG_TAG = CoursesActivity.class.getSimpleName();
    private List<Courses> courses = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private CoursesAdapter mCoursesRecyclerViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);

        mRecyclerView = (RecyclerView) findViewById(R.id.courseRecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mCoursesRecyclerViewAdapter = new CoursesAdapter(CoursesActivity.this, new ArrayList<Courses>());
        mRecyclerView.setAdapter(mCoursesRecyclerViewAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ProcessCourses processCourses = new ProcessCourses();
        processCourses.execute();

    }

    public class ProcessCourses extends ParseCoursesJsonData{
        public ProcessCourses(){
            super();
        }

        public void execute(){
            //   super.execute();
            ProcessData processData = new ProcessData();
            processData.execute();

        }

        public class ProcessData extends DownloadJsonData {
            protected void onPostExecute(String webData){
                super.onPostExecute(webData);
                mCoursesRecyclerViewAdapter.loadNewData(getCourses());
            }
        }
    }



    private void setupWindowAnimations() {
        Slide slide = new Slide(5);
        getWindow().setExitTransition(slide);
    }
}