 package com.example.pranavjayaraj.popularmovies.adapters;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.pranavjayaraj.popularmovies.R;
import com.example.pranavjayaraj.popularmovies.Movie;

        public class AsyncAdapter extends ArrayAdapter<Movie> {

            public static class ViewHolder {
                public final ImageView imageView;
                public final TextView titleView;

                        public ViewHolder(View view) {
                        imageView = (ImageView) view.findViewById(R.id.grid_item_image);
                        titleView = (TextView) view.findViewById(R.id.grid_item_title);
                    }
            }

                public AsyncAdapter(Context context) {
                super(context, 0);
            }

                @Override
        public View getView(int position, View convertView, ViewGroup parent) {
                View view = convertView;
                ViewHolder viewHolder;

                        if (view == null) {
                        view = LayoutInflater.from(getContext()).inflate(R.layout.grid_items, parent, false);
                        viewHolder = new ViewHolder(view);
                        view.setTag(viewHolder);
                    }

                        final Movie movie = getItem(position);
                String image_url = "http://image.tmdb.org/t/p/w185" + movie.getImage();

                        viewHolder = (ViewHolder) view.getTag();

                Glide.with(getContext())
                                .load(image_url)
                                .into(viewHolder.imageView);

                        viewHolder.titleView.setText(movie.getTitle());

                        return view;
            }
    }