package ie.dit.android.dit;

import android.annotation.TargetApi;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.transition.Slide;
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
               TimetablesIntent timetablesIntent = new TimetablesIntent();
               timetablesIntent.execute();
          }
        });
    }




}
