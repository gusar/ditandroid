package ie.dit.android.dit;


import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ParseNewsJsonData extends GetRawData {

    private static final String LOG_TAG = ParseNewsJsonData.class.getSimpleName();
    public static final String SERVER_URL = "http://collegboi.me/api/returnNewsAndroid.php";
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


    // Create a list of News objects.
    public void processResult() {
        if (getJsonDownloadStatus() != DownloadStatus.OK) {
            Log.e(LOG_TAG, "Error downloading raw file");
            return;
        }

        final String NEWS_ITEMS = "";
        final String NEWS_ID = "id";
        final String NEWS_NAME = "newsTitle";
        final String NEWS_DATE = "newsDate";
        final String NEWS_IMAGE = "newsImageURL";
        final String NEWS_DESC = "newsDesc";

        try {
//            JSONObject jsonData = new JSONObject(getJsonData());
//            JSONArray itemsArray = jsonData.getJSONArray();
            JSONArray itemsArray = new JSONArray(getJsonData());

            for (int i = 0; i < itemsArray.length(); i++) {
                JSONObject jsonNewsItem = itemsArray.getJSONObject(i);
                String id = jsonNewsItem.getString(NEWS_ID);
                String title = jsonNewsItem.getString(NEWS_NAME);
                String date = jsonNewsItem.getString(NEWS_DATE);
                String imageUrl = jsonNewsItem.getString(NEWS_IMAGE);
//                JSONObject image = jsonNewsItem.getJSONObject(NEWS_IMAGE);
//                String desc = jsonNewsItem.getString(NEWS_DESC);

                News newsObject = new News(id, title, date, imageUrl/*, desc*/);
                this.news.add(newsObject);
            }

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
