package com.example.pranavjayaraj.popularmovies;
import android.support.v4.app.Fragment;
import android.widget.ImageView;
import android.widget.TextView;

    import android.os.Bundle;
    import android.text.format.DateUtils;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import com.bumptech.glide.Glide;
    import java.text.ParseException;
    import java.text.SimpleDateFormat;



            public class DetailsFragment extends Fragment {

                static final String DETAIL_MOVIE = "DETAIL_MOVIE";

                private Movie mMovie;

                private ImageView mImageView;
                private TextView  mTitleView;
                private TextView  mOverviewView;
                private TextView mDateView;
                private TextView mVoteAverageView;
                private TextView mVoteCountView;
                private TextView mPopularityView;
                public DetailsFragment() {
                }

                @Override
                public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                         Bundle savedInstanceState) {
                    Bundle arguments = getArguments();
                    if (arguments != null) {
                        mMovie = arguments.getParcelable(DetailsFragment.DETAIL_MOVIE);
                    }

                    View rootView = inflater.inflate(R.layout.fragment_details, container, false);

                    mImageView = (ImageView) rootView.findViewById(R.id.detail_image);
                    mTitleView = (TextView) rootView.findViewById(R.id.detail_title);
                    mOverviewView = (TextView) rootView.findViewById(R.id.detail_overview);
                    mDateView = (TextView) rootView.findViewById(R.id.detail_date);
                    mVoteAverageView = (TextView) rootView.findViewById(R.id.detail_vote_average);
                    mVoteCountView =(TextView)rootView.findViewById(R.id.detail_vote_count);
                    mPopularityView=(TextView)rootView.findViewById(R.id.detail_popularity);
                    String image_url = "http://image.tmdb.org/t/p/w185" + mMovie.getImage2();
                    Glide.with(this).load(image_url).into(mImageView);

                    mTitleView.setText(mMovie.getTitle());
                    mOverviewView.setText(mMovie.getOverview());
                    String movie_date = mMovie.getDate();

                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    try {
                        String date = DateUtils.formatDateTime(getActivity(),
                                formatter.parse(movie_date).getTime(), DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR);
                        mDateView.setText(date);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    mPopularityView.setText(Double.toString(mMovie.getPop()));
                    mVoteCountView.setText(Integer.toString(mMovie.getCount()));
                    mVoteAverageView.setText(Integer.toString(mMovie.getRating()));
                    return rootView;
                }
            }



