package ie.dit.android.dit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class MapAdapter extends ArrayAdapter<Campus>{

    public MapAdapter(Context context, ArrayList<Campus> c ) {
        super(context, R.layout.map_fragment, c);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Campus campus = getItem(position);

        LayoutInflater mapInflater = LayoutInflater.from(getContext());
        View customView = mapInflater.inflate(R.layout.map_fragment, parent, false);

        TextView mapText = (TextView) customView.findViewById(R.id.mapFragmentText);
        ImageView mapImage = (ImageView) customView.findViewById(R.id.mapFragmentImage);

        //NEED TO FIX ON HOW TO ADD IMAGE

        mapText.setText(campus.campusName);
        //mapImage.setImageResource(campus.campusImage);
        return customView;
    }

}
