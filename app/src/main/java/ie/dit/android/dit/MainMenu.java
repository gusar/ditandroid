package ie.dit.android.dit;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;



public class MainMenu extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }


    //Method to go to Maps page
    public void mapClicked(View view){
        //Tempo code just to move between main menu to this page

    }

    //Method to go to Course page
    public void courseClicked(View view){
        //Tempo code just to move between main menu to this page

    }

    //Method to go to News page
    public void newsClicked(View view){
        //Tempo code just to move between main menu to this page

    }

    //Method to go to Library page
    public void libraryClicked(View view){
        //Tempo code just to move between main menu to this page

    }

    //Method to go to Contacts page
    public void contactsClicked(View view){
        //Tempo code just to move between main menu to this page

    }

    //Method to go to Timetables page
    public void timetableClicked(View view){
        //Tempo code just to move between main menu to this page

    }















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
