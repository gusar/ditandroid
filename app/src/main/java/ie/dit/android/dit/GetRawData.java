package ie.dit.android.dit;


import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

enum DownloadStatus { IDLE, PROCESSING, NOT_INITIALISED, FAILED_OR_EMPTY, OK }

public class GetRawData {

    private String LOG_TAG = GetRawData.class.getSimpleName();
    private String jsonURL;
    private String jsonData;
    private DownloadStatus jsonDownloadStatus;


    // Constructor
    public GetRawData(String jsonRawUrl) {
        this.jsonURL = jsonRawUrl;
        this.jsonDownloadStatus = DownloadStatus.IDLE;
    }


    // ASYNCHRONOUSLY DOWNLOAD JSON DATA
    public class DownloadRawJsonData extends AsyncTask<String, Void, String> {

        // Feedback after a download attempt
        protected void onPostExecute(String downloadedData) {
            jsonData = downloadedData;
            Log.v(LOG_TAG, "Downloaded data: " + jsonData);
            if (jsonData == null) {
                // Error passing URL
                if (jsonURL == null) {
                    jsonDownloadStatus = DownloadStatus.NOT_INITIALISED;
                // No data returned
                } else {
                    jsonDownloadStatus = DownloadStatus.FAILED_OR_EMPTY;
                }
            // Download successfull
            } else {
                jsonDownloadStatus = DownloadStatus.OK;
            }
        }

        // Abstract AsyncTask method for downloading data
        protected String doInBackground(String... params) {
            Log.v(LOG_TAG, "URL: " + params[0]);
            HttpURLConnection urlConnection = null;
            BufferedReader bufferReader = null;

            // Abort if no URL received
            if (params == null) {
                Log.v(LOG_TAG, "doInBackground: No URL Received");
                return null;
            }

            // Try dowloading
            try {
                URL url = new URL(params[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();
                InputStream inputStream = urlConnection.getInputStream();

                // Abort if no data returned
                if (inputStream == null) {
                    Log.v(LOG_TAG, "doInBackground: No Data Returned From Given URL");
                    return null;
                }
                // Load data into buffer
                StringBuffer stringBuffer = new StringBuffer();
                bufferReader = new BufferedReader(new InputStreamReader(inputStream));

                // Separate string data into lines
                String line;
                while((line = bufferReader.readLine()) != null) {
                    stringBuffer.append(line + "\n");
                }
                // Return downloaded data
                return stringBuffer.toString();

            } catch (IOException e) {
                Log.e(LOG_TAG, "Error", e);
                return null;

            } finally {
                // Gracefully disconnect
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                // Stop reading into buffer
                if (bufferReader != null) {
                    try {
                        bufferReader.close();
                    } catch (final IOException e) {
                        Log.e(LOG_TAG, "Error closing stream", e);
                    }
                }
            } // End of download try block
        } // End of doInBackground
    } // End of class


    // SETTERS AND GETTERS
    public void setJsonURL(String jsonURL) {
        this.jsonURL = jsonURL;
    }

    public DownloadStatus getJsonDownloadStatus() {
        return jsonDownloadStatus;
    }

    public String getJsonData() {
        return jsonData;
    }
}