package ie.dit.android.dit;


import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParseNewsJsonData extends GetRawData {

    private static final String LOG_TAG = ParseNewsJsonData.class.getSimpleName();
    public static final String SERVER_URL = "http://collegboi.me/Parse/returnNews.php";
    List<News> news;

    // Constructor
    public ParseNewsJsonData() {
        super(null);
        news = new ArrayList<News>();
    }

    public void execute() {
        super.setJsonURL(SERVER_URL);
        DownloadJsonData downloadJsonData = new DownloadJsonData();
        downloadJsonData.execute(SERVER_URL);
    }


    // Modify AsyncTask methods to make sure data can download before processing starts
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


    // Create a list of News objects
    public void processResult() {

        if (getJsonDownloadStatus() != DownloadStatus.OK) {
            Log.e(LOG_TAG, "Error downloading raw file");
            return;
        }

        try {
            GsonBuilder gsonBuilder = new GsonBuilder();
            Gson gson = gsonBuilder.create();
            news = Arrays.asList(gson.fromJson(getJsonData(), News[].class));

            // Print news objects' data
            for (News singleNews : news) {
                Log.v(LOG_TAG, singleNews.toString());
            }

        } catch (Exception e) {
            Log.e(LOG_TAG, "Failed to parse JSON: " + e);
        }
    }

    public List<News> getNews() {
        return news;
    }
}
