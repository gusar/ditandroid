package ie.dit.android.dit;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.Slide;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class MainActivity extends Activity {

    private ViewGroup menuSceneRoot;
    private View news;
    private View contacts;
    private View courses;
    private View maps;
    private View library;
    private View timetables;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        setupWindowAnimations();
        setupLayout();
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
                Intent intent = new Intent(MainActivity.this, Maps.class);
                ActivityOptions transitionActivityOptions =
                        ActivityOptions.makeSceneTransitionAnimation(MainActivity.this);
                startActivity(intent, transitionActivityOptions.toBundle());
            }
        });


        library = findViewById(R.id.libraryLayout);
        library.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Library.class);
                ActivityOptions transitionActivityOptions =
                        ActivityOptions.makeSceneTransitionAnimation(MainActivity.this);
                startActivity(intent, transitionActivityOptions.toBundle());
            }
        });


        news = findViewById(R.id.newsLayout);
        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, News.class);
                ActivityOptions transitionActivityOptions =
                        ActivityOptions.makeSceneTransitionAnimation(MainActivity.this);
                startActivity(intent, transitionActivityOptions.toBundle());
            }
        });


        courses = findViewById(R.id.coursesLayout);
        courses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Courses.class);
                ActivityOptions transitionActivityOptions =
                        ActivityOptions.makeSceneTransitionAnimation(MainActivity.this);
                startActivity(intent, transitionActivityOptions.toBundle());
            }
        });


        contacts = findViewById(R.id.contactsLayout);
        contacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Contacts.class);
                ActivityOptions transitionActivityOptions =
                        ActivityOptions.makeSceneTransitionAnimation(MainActivity.this);
                startActivity(intent, transitionActivityOptions.toBundle());
            }
        });


        timetables = findViewById(R.id.timetablesLayout);
        timetables.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: open the timetables app
            }
        });
    }



    // OPTIONS MENU
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
