package ie.dit.android.dit;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class CoursesViewHolder extends RecyclerView.ViewHolder{

    protected TextView courseCode;
    protected TextView courseQual;
    protected TextView courseDuration;
    protected TextView coursePlaces;
    protected TextView courseLocation;
    protected TextView courseDesc;
    protected TextView courseDepart;
    protected TextView courseFONameNum;
    protected TextView courseFOEmail;

    public CoursesViewHolder(View itemView) {
        super(itemView);
        this.courseCode = (TextView)itemView.findViewById(R.id.courseCodeText);
        this.courseQual = (TextView)itemView.findViewById(R.id.courseQualText);
        this.courseDuration = (TextView)itemView.findViewById(R.id.courseDurationText);
        this.coursePlaces = (TextView)itemView.findViewById(R.id.coursePlacesText);
        this.courseLocation = (TextView)itemView.findViewById(R.id.courseLocationText);
        this.courseDesc = (TextView)itemView.findViewById(R.id.courseDescText);
        this.courseDepart = (TextView)itemView.findViewById(R.id.courseDepartText);
        this.courseFONameNum = (TextView)itemView.findViewById(R.id.courseFONameNumText);
        this.courseFOEmail = (TextView)itemView.findViewById(R.id.courseFOEmailText);

    }

}