package ie.dit.android.dit;


import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;

import java.util.List;

public class TimetablesActivity extends Activity {

    public void execute() {
        Intent timeIntent = new Intent(Intent.ACTION_VIEW);

        PackageManager packageManager = context. getPackageManager().getInstalledPackages(0);
        List<ResolveInfo> activities = packageManager.queryIntentActivities(timeIntent, 0);
        boolean isIntentSafe = activities.size() > 0;

        if (isIntentSafe) {
            startActivity(timeIntent);
        }
    }

}
