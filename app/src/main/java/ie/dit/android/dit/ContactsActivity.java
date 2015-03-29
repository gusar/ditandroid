package ie.dit.android.dit;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.transition.Slide;


@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class ContactsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        setupWindowAnimations();
    }


    private void setupWindowAnimations() {
        Slide slide = new Slide(5);
        getWindow().setExitTransition(slide);
    }
}
