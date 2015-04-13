package ie.dit.android.dit;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
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
        ProcessContacts processContacts = new ProcessContacts();
        processContacts.execute();

    }

    public class ProcessContacts extends ParseContactsJsonData{
        public ProcessContacts(){
            super();
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
