package ie.dit.android.dit;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;


public class TimetablesIntent extends Activity {
    public static final String LOG_TAG = TimetablesIntent.class.getSimpleName();

    // Constructor
    public TimetablesIntent() {
    }

    public void execute() {
        Intent intent = getPackageManager().getLaunchIntentForPackage("ie.dit.android.dit");

        try {
            if (intent != null) {
                // Activity found.
                Log.v(LOG_TAG, "Activity Found");
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            } else {
                // Bring user to Play or choose an application.
                Log.v(LOG_TAG, "Activity Not Found");
                intent = new Intent(Intent.ACTION_VIEW);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setData(Uri.parse("market://details?id=" + "ie.dit.android.dit"));
                startActivity(intent);
            }
        } catch (Exception e) {
            Log.e(LOG_TAG, "Failed to launch: " + e);
        }
    }
}
