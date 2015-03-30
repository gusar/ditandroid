package ie.dit.android.dit;


import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NewsJsonData extends GetRawJsonData {

    private static final String LOG_TAG = NewsJsonData.class.getSimpleName();
    public static final String SERVER_URL = "http://collegboi.me/Parse/returnNews.php";
    List<News> news;

    // Constructor
    public NewsJsonData() {
        super(null);
        news = new ArrayList<News>();
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

    private String newsString;
    //
    public void processResult() {

        if (getJsonDownloadStatus() != DownloadStatus.OK) {
            Log.e(LOG_TAG, "Error downloading raw file");
            return;
        }

        try {
            GsonBuilder gsonBuilder = new GsonBuilder();
            Gson gson = gsonBuilder.create();
            newsString = getJsonData();
            news = Arrays.asList(gson.fromJson(getJsonData(), News[].class));
        } catch (Exception e) {
            Log.e(LOG_TAG, "Failed to parse JSON: " + e);
        }
    }

    public List<News> getNews() {
        return news;
    }

    public String getNewsString() {
        return newsString;
    }
}
