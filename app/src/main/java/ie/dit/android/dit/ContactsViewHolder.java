package ie.dit.android.dit;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class ContactsViewHolder extends RecyclerView.ViewHolder{

        protected TextView contactName;
        protected TextView contactDepartment;
        protected TextView contactEmail;
        protected TextView contactPhoneNo;

        public ContactsViewHolder(View itemView) {
            super(itemView);
            this.contactName = (TextView)itemView.findViewById(R.id.contactNameText);
            this.contactDepartment = (TextView)itemView.findViewById(R.id.contactDepartmentText);
            this.contactEmail = (TextView)itemView.findViewById(R.id.contactEmailText);
            this.contactPhoneNo = (TextView)itemView.findViewById(R.id.courseFONameNumText);

        }

}
