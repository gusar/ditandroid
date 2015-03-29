package ie.dit.android.dit;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.transition.Slide;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;


@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class MapsActivity extends Activity {

    ArrayList<Campus> campus = new ArrayList<Campus>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setupWindowAnimations();

        campus.add(new Campus("Title 1", R.drawable.aungier));
        campus.add(new Campus("Title 2", R.drawable.bolton));
        campus.add(new Campus("Title 3", R.drawable.cathal_brugha));
        campus.add(new Campus("Title 4", R.drawable.grangegorman));
        campus.add(new Campus("Title 5", R.drawable.kevin));


        ListAdapter adapter = new MapAdapter(this, campus);
        ListView listView = (ListView)findViewById(R.id.mapListView);
        listView.setAdapter(adapter);





    }


    private void setupWindowAnimations() {
        Slide slide = new Slide(5);
        getWindow().setExitTransition(slide);
    }
}
