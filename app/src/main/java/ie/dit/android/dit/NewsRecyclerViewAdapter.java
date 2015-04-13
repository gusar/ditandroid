package ie.dit.android.dit;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsRecyclerViewAdapter extends RecyclerView.Adapter<ImageViewHolder> {

    private List<News> mNewsList;
    private Context mContext;
    private static final String LOG_TAG = NewsRecyclerViewAdapter.class.getSimpleName();

    public NewsRecyclerViewAdapter(Context context, List<News> newsList) {
        mContext = context;
        this.mNewsList = newsList;
    }


    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_card, null);
        ImageViewHolder imageViewHolder = new ImageViewHolder(view);
        return imageViewHolder;
    }


    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        News news = mNewsList.get(position);
        Log.d(LOG_TAG, "Processing: " + news.getNewsTitle() + " --> " + Integer.toString(position));

        Picasso.with(mContext)
                .load(news.getNewsImageURL())
                .error(R.drawable.placeholder)
                .placeholder(R.drawable.placeholder)
                .into(holder.thumbnail);
        holder.title.setText(news.getNewsTitle());
    }


    @Override
    public int getItemCount() {
        return (null != mNewsList ? mNewsList.size() : 0);
    }


    public void loadNewData(List<News> newNews) {
        mNewsList = newNews;
        notifyDataSetChanged();
    }


    public News getNews(int position) {
        return (null != mNewsList ? mNewsList.get(position) : null);
    }
}
