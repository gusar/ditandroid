package ie.dit.android.dit;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Slide;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;


@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class ContactsActivity extends BaseActivity {

    private static final String LOG_TAG = ContactsActivity.class.getSimpleName();
    private List<Contacts> contacts = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private ContactsAdapter mContactsRecyclerViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        activateToolbarWithHomeEnabled();
        setupWindowAnimations();



        //RECYCLERVIEW
        // Setup RecyclerView
        mRecyclerView = (RecyclerView) findViewById(R.id.contactRecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mContactsRecyclerViewAdapter = new ContactsAdapter(ContactsActivity.this, new ArrayList<Contacts>());
        mRecyclerView.setAdapter(mContactsRecyclerViewAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        String query = getSavedPreferenceData(USER_QUERY);
        if (query.length() > 0) {
            ProcessContacts processContacts = new ProcessContacts(query);
            processContacts.execute();
        }

    }


    private String getSavedPreferenceData(String key) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        return sharedPreferences.getString(key, "");
    }


    public class ProcessContacts extends ParseContactsJsonData{
        public ProcessContacts(String searchCriteria/*, boolean matchAll*/){
            super(searchCriteria);
        }

        public void execute(){
            ProcessData processData = new ProcessData();
            processData.execute();

        }

        public class ProcessData extends DownloadJsonData {
            protected void onPostExecute(String webData){
                super.onPostExecute(webData);
                mContactsRecyclerViewAdapter.loadNewData(getContacts());
            }
        }
    }



    private void setupWindowAnimations() {
        Slide slide = new Slide(5);
        getWindow().setExitTransition(slide);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        if (id == R.id.menu_search) {
            Intent intent = new Intent(this, SearchActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
