package ie.dit.android.dit;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class ParseCoursesJsonData extends GetRawData {

    private static final String LOG_TAG = ParseCoursesJsonData.class.getSimpleName();
    public static final String SERVER_URL = "http://collegboi.me/api/parseCourses.php?courseCode=dt101&course=Architecture";
    List<Courses> courses;

    // Constructor
    public ParseCoursesJsonData() {
        super(null);
        courses = new ArrayList<Courses>();
    }

    public void execute() {
        super.setJsonURL(SERVER_URL);
        DownloadJsonData downloadJsonData = new DownloadJsonData();
        downloadJsonData.execute(SERVER_URL);
    }

    public class DownloadJsonData extends DownloadRawJsonData {
        protected void onPostExecute(String webData) {
            super.onPostExecute(webData);
            processResult();
        }

        protected String doInBackground(String... params) {
            String[] par = { SERVER_URL };
            return super.doInBackground(par);
        }
    }

    // Create a list of Courses objects.
    public void processResult() {
        if (getJsonDownloadStatus() != DownloadStatus.OK) {
            Log.e(LOG_TAG, "Error downloading raw file");
            return;
        }


        final String COURSE_ITEMS = "Courses";
        final String COURSE_PROGRAM_CODE = "programCode";
        final String COURSE_QUALIFICATION = "qualification";
        final String COURSE_DURATION = "duration";
        final String COURSE_NUM_PLACES = "noOfPlaces";
        final String COURSE_LOCATION = "location";
        final String COURSE_DESCRIPTION = "desc";
        final String COURSE_DEPART = "courseDepart";
        final String COURSE_FO_NAME_NUM = "furtherInfo_Name_No";
        final String COURSE_FO_EMAIL = "furtherInfo_Email";


        try {
            JSONObject jsonData = new JSONObject(getJsonData());
            JSONArray itemsArray = jsonData.getJSONArray(COURSE_ITEMS);

            for (int i = 0; i < itemsArray.length(); i++) {
                JSONObject jsonCoursesItem = itemsArray.getJSONObject(i);
                String code = jsonCoursesItem.getString(COURSE_PROGRAM_CODE);
                String qual = jsonCoursesItem.getString(COURSE_QUALIFICATION);
                String duration = jsonCoursesItem.getString(COURSE_DURATION);
                String places = jsonCoursesItem.getString(COURSE_NUM_PLACES);
                String location = jsonCoursesItem.getString(COURSE_LOCATION);
                String desc = jsonCoursesItem.getString(COURSE_DESCRIPTION);
                String depart = jsonCoursesItem.getString(COURSE_DEPART);
                String fo_name_num = jsonCoursesItem.getString(COURSE_FO_NAME_NUM);
                String fo_email = jsonCoursesItem.getString(COURSE_FO_EMAIL);
//

                Courses coursesObject = new Courses(code, qual, duration, places, location, desc, depart, fo_name_num, fo_email);
                this.courses.add(coursesObject);
            }

            // Print contacts objects' data
            for (Courses c : courses) {
                Log.v(LOG_TAG, c.toString());
            }

        } catch (Exception e) {
            Log.e(LOG_TAG, "Failed to parse JSON: " + e);
        }
    }

    public List<Courses> getCourses() {
        return courses;
    }
}

