package ie.dit.android.dit;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;


public class BaseActivity extends ActionBarActivity {

    private Toolbar toolbar;


    // Display toolbar and set top margin as status bar height
    protected Toolbar activateToolbar() {
        if (toolbar == null) {
            toolbar = (Toolbar) findViewById(R.id.app_bar);
            if (toolbar != null) {
                setSupportActionBar(toolbar);
                getSupportActionBar().setDisplayShowTitleEnabled(false);
                ((LinearLayout.LayoutParams) toolbar.getLayoutParams()).setMargins(0, getStatusBarHeight(this), 0, 0);
            }
        }
        return toolbar;
    }

    protected android.support.v7.widget.Toolbar activateToolbarWithHomeEnabled() {
        activateToolbar();
        if(toolbar != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        return toolbar;
    }


    // Calculate status bar height
    public static int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}
