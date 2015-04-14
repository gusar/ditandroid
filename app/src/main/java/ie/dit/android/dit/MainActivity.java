package ie.dit.android.dit;

import android.annotation.TargetApi;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.transition.Slide;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class MainActivity extends BaseActivity {

    protected ViewGroup menuSceneRoot;
    protected View news;
    protected View contacts;
    protected View courses;
    protected View maps;
    protected View library;
    protected View timetables;
    protected RelativeLayout locationContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        // Fix statusbar margin due to windowTranslucentNavigation
        locationContainer = (RelativeLayout) findViewById(R.id.locationContainer);
        ((RelativeLayout.LayoutParams) locationContainer.getLayoutParams()).setMargins(0, getStatusBarHeight(this), 0, 0);

        setupCustomFonts();
        setupWindowAnimations();
        setupLayout();
    }


    // CUSTOM FONTS
    private void setupCustomFonts() {
        Typeface robotoThin = Typeface.createFromAsset(getAssets(), "fonts/roboto_thin.ttf");
        TextView menuLocation = (TextView) findViewById(R.id.menuLocationText);
        menuLocation.setTypeface(robotoThin);
    }


    // TRANSITION ANIMATIONS
    private void setupWindowAnimations() {
        Slide slideOut = new Slide(3);
        getWindow().setExitTransition(slideOut);
    }


    // SET UP ONCLICKLISTENERS
    private void setupLayout () {
        menuSceneRoot = (RelativeLayout) findViewById(R.id.menu_scene_root);

        maps = findViewById(R.id.mapsLayout);
        maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                ActivityOptions transitionActivityOptions =
                        ActivityOptions.makeSceneTransitionAnimation(MainActivity.this);
                startActivity(intent, transitionActivityOptions.toBundle());
            }
        });


        library = findViewById(R.id.libraryLayout);
        library.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LibraryActivity.class);
                ActivityOptions transitionActivityOptions =
                        ActivityOptions.makeSceneTransitionAnimation(MainActivity.this);
                startActivity(intent, transitionActivityOptions.toBundle());
            }
        });


        news = findViewById(R.id.newsLayout);
        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewsActivity.class);
                ActivityOptions transitionActivityOptions =
                        ActivityOptions.makeSceneTransitionAnimation(MainActivity.this);
                startActivity(intent, transitionActivityOptions.toBundle());
            }
        });


        courses = findViewById(R.id.coursesLayout);
        courses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CoursesActivity.class);
                ActivityOptions transitionActivityOptions =
                        ActivityOptions.makeSceneTransitionAnimation(MainActivity.this);
                startActivity(intent, transitionActivityOptions.toBundle());
            }
        });


        contacts = findViewById(R.id.contactsLayout);
        contacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ContactsActivity.class);
                ActivityOptions transitionActivityOptions =
                        ActivityOptions.makeSceneTransitionAnimation(MainActivity.this);
                startActivity(intent, transitionActivityOptions.toBundle());
            }
        });


        timetables = findViewById(R.id.timetablesLayout);
        timetables.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String packageName = "com.android.calculator2";
                final String packageActivityName = "com.android.calculator2.Calculator";
                final String LOG_TAG = MainActivity.class.getSimpleName();
                Intent intent = new Intent();
               //intent.setClassName("com.android.calculator2","com.android.calculator2.Calculator");
                intent.setClassName(packageName,packageActivityName);
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
               //startActivity(intent);
          }
        });
    }




}
