package ie.dit.android.dit;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.widget.RecyclerView;

public class ImageViewHolder extends RecyclerView.ViewHolder{

    protected ImageView thumbnail;
    protected TextView title;

    public ImageViewHolder(View view) {
        super(view);
        this.thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
        this.title = (TextView) view.findViewById(R.id.title);
    }

}
