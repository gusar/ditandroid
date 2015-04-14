package ie.dit.android.dit;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.Log;


public class TimetablesIntent extends Activity {
    public static final String LOG_TAG = TimetablesActivity.class.getSimpleName();


    public void execute(Context context, String packageName) {
        PackageManager manager = context.getPackageManager();
        Intent intent = manager.getLaunchIntentForPackage(packageName);

        try {
            if (intent != null) {
                // Activity found.
                Log.v(LOG_TAG, "Activity Found");
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            } else {
                // Bring user to Play or choose an application.
                Log.v(LOG_TAG, "Activity Not Found");
                intent = new Intent(Intent.ACTION_VIEW);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setData(Uri.parse("market://details?id=" + packageName));
                startActivity(intent);
            }
        } catch (Exception e) {
            Log.e(LOG_TAG, "Failed to launch: " + e);
        }
    }
}