package ie.dit.android.dit;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.transition.Slide;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class MapsActivity extends Activity {

    ArrayList<Campus> campus = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setupWindowAnimations();

        //add campus data.
        campus.add(new Campus("Aungier Street", R.drawable.aungier, 53.338505, -6.266364));
        campus.add(new Campus("Bolton Street", R.drawable.bolton, 53.351435, -6.269049));
        campus.add(new Campus("Cathal Brugha Street", R.drawable.cathal_brugha, 53.352226, -6.259616));
        campus.add(new Campus("Grangegorman", R.drawable.grangegorman, 53.355410, -6.283686));
        campus.add(new Campus("Kevin Street", R.drawable.kevin, 53.337089, -6.267848));


        ListAdapter adapter = new MapAdapter(this, campus);
        ListView listView = (ListView)findViewById(R.id.mapListView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Campus c = campus.get(position);

                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        String format = "geo:0,0?q=" + c.getCampusLatitude() + "," + c.getCamspusLongitude() + "('" + c.getCampusName() + "')";
                        intent.setData((Uri.parse(format)));

                        if(intent.resolveActivity(getPackageManager()) != null){
                            startActivity(intent);
                        }else{
                            Toast.makeText(MapsActivity.this,"Not Available.", Toast.LENGTH_LONG).show();

                        }
                    }
                }
        );
    }

    private void setupWindowAnimations() {
        Slide slide = new Slide(5);
        getWindow().setExitTransition(slide);
    }
}
