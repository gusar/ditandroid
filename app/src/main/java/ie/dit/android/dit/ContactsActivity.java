package ie.dit.android.dit;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Slide;
import android.widget.Toast;

import java.util.List;


@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class ContactsActivity extends BaseActivity {

    private List<Contacts> contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        setupWindowAnimations();

       ProcessContacts processContacts = new ProcessContacts();
        processContacts.execute();


        //RECYCLERVIEW
        //Tutorial: icetea09.com/blog/2014/12/19/android-cardview-and-recyclerview-in-material-design/
        RecyclerView contactsRecyclerView = (RecyclerView) findViewById(R.id.contactRecyclerView);
        contactsRecyclerView.setHasFixedSize(true);

        //layout manager
        LinearLayoutManager contactLayoutManager = new LinearLayoutManager(this);
        contactsRecyclerView.setLayoutManager(contactLayoutManager);

        //create adapter with the contacts data as parameters
        RecyclerView.Adapter contactAdapter = new ContactsAdapter();  //this, processContacts.getContacts()
        contactsRecyclerView.setAdapter(contactAdapter);
    }

    private void handleContactsList(List<Contacts> contacts){
        this.contacts = contacts;

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                for(Contacts contacts : ContactsActivity.this.contacts){
                    Toast.makeText(ContactsActivity.this, contacts.getName(), Toast.LENGTH_LONG).show();
                }
            }
        });
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
                contacts = getContacts();
            }
        }
    }



    private void setupWindowAnimations() {
        Slide slide = new Slide(5);
        getWindow().setExitTransition(slide);
    }
}
