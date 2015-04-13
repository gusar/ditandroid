package ie.dit.android.dit;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;


public class ContactsAdapter extends RecyclerView.Adapter<ContactsViewHolder> {
    private List<Contacts> contacts;
    private Context mContext;
    private final String LOG_TAG = ContactsAdapter.class.getSimpleName();


    public ContactsAdapter(Context context, List<Contacts> contacts){
        super();

        mContext = context;
        this.contacts = contacts;

    }

    @Override
    public ContactsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_contacts_layout, null);
        return new ContactsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactsViewHolder holder, int position) {
        Contacts singleContacts = contacts.get(position);
        Log.d(LOG_TAG, "Processing: " + singleContacts.getName() + " --> " + Integer.toString(position));

        holder.contactName.setText(singleContacts.getName());
        holder.contactDepartment.setText(singleContacts.getDepartment());
        holder.contactEmail.setText(singleContacts.getEmail());
        holder.contactPhoneNo.setText(singleContacts.getPhoneNo());

        Log.d("DATA","Name: " + singleContacts.getName());
        Log.d("DATA","Department: " + singleContacts.getDepartment());
        Log.d("DATA","Email: " + singleContacts.getEmail());
        Log.d("DATA","Phone: " + singleContacts.getPhoneNo());
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public void loadNewData(List<Contacts> newContacts){
        contacts = newContacts;
        notifyDataSetChanged();
    }

    public Contacts getContacts(int position){
        return(null != contacts ? contacts.get(position) : null);
    }


}
