package ie.dit.android.dit;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.widget.LinearLayout;


public class BaseActivity extends ActionBarActivity {

    android.support.v7.widget.Toolbar toolbar;

    protected android.support.v7.widget.Toolbar activateToolbar() {
        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        ((LinearLayout.LayoutParams) toolbar.getLayoutParams()).setMargins(0, getStatusBarHeight(this), 0, 0);
        return toolbar;
    }

    protected android.support.v7.widget.Toolbar activateToolbarWithHomeEnabled() {
        activateToolbar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        return toolbar;
    }

    public static int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}
