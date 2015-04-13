package ie.dit.android.dit;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Slide;

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

        activateToolbar();
        setupWindowAnimations();



        //RECYCLERVIEW
        //Tutorial: icetea09.com/blog/2014/12/19/android-cardview-and-recyclerview-in-material-design/
        // Setup RecyclerView
        mRecyclerView = (RecyclerView) findViewById(R.id.contactRecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mContactsRecyclerViewAdapter = new ContactsAdapter(ContactsActivity.this, new ArrayList<Contacts>());
        mRecyclerView.setAdapter(mContactsRecyclerViewAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // TODO: Replace bla with query variable when search code finished
        String query = getSavedPreferenceData("bla"/*CONTACTS_QUERY*/);
        if (query.length() < 0) {
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
            //   super.execute();
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
}
