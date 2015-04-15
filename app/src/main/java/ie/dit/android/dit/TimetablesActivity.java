package ie.dit.android.dit;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

public class TimetablesActivity extends Activity {


    protected void execute() {


        final String packageName = "com.android.calculator2";
        final String packageActivityName = "com.android.calculator2.Calculator";
        final String LOG_TAG = MainActivity.class.getSimpleName();


        Intent intent = new Intent();
        //intent.setClassName("com.android.calculator2","com.android.calculator2.Calculator");
        intent.setClassName(packageName, packageActivityName);
        intent.setAction("foo");
        try {
            if (intent != null && intent.getAction() != null) {
                // Activity found.
                Log.v(LOG_TAG, "Activity Found");
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
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
