package ie.dit.android.dit;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;


public class CoursesAdapter extends RecyclerView.Adapter<CoursesViewHolder> {
    private List<Courses> courses;
    private Context mContext;
    private final String LOG_TAG = CoursesAdapter.class.getSimpleName();


    public CoursesAdapter(Context context, List<Courses> courses){
        super();

        mContext = context;
        this.courses = courses;

    }

    @Override
    public CoursesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_courses_layout, null);
        return new CoursesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CoursesViewHolder holder, int position) {
        Courses singleCourse = courses.get(position);
        Log.d(LOG_TAG, "Processing: " + singleCourse.getCode() + " --> " + Integer.toString(position));

        holder.courseCode.setText(singleCourse.getCode());
        holder.courseQual.setText(singleCourse.getQual());
        holder.courseDuration.setText(singleCourse.getDuration());
        holder.coursePlaces.setText(singleCourse.getPlaces());
        holder.courseLocation.setText(singleCourse.getLocation());
        holder.courseDesc.setText(singleCourse.getDesc());
        holder.courseDepart.setText(singleCourse.getDepart());
        holder.courseFONameNum.setText(singleCourse.getFo_name_num());
        holder.courseFOEmail.setText(singleCourse.getFo_email());

        Log.d("DATA","Code: " + singleCourse.getCode());
        Log.d("DATA","Qualification: " + singleCourse.getQual());
        Log.d("DATA","Duration: " + singleCourse.getDuration());
        Log.d("DATA","Places: " + singleCourse.getPlaces());
        Log.d("DATA","Location: " + singleCourse.getLocation());
        Log.d("DATA","Description: " + singleCourse.getDesc());
        Log.d("DATA","Department: " + singleCourse.getDepart());
        Log.d("DATA","FO Name Num: " + singleCourse.getFo_name_num());
        Log.d("DATA","FO Email: " + singleCourse.getFo_email());
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    public void loadNewData(List<Courses> newCourses){
        courses = newCourses;
        notifyDataSetChanged();
    }

    public Courses getCourses(int position){
        return(null != courses ? courses.get(position) : null);
    }


}
