package com.example.pranavjayaraj.popularmovies;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;


        public class Details extends AppCompatActivity {

               @Override
       protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_detail);

                        if (savedInstanceState == null) {
                        Bundle arguments = new Bundle();
                        arguments.putParcelable(DetailsFragment.DETAIL_MOVIE,
                                        getIntent().getParcelableExtra(DetailsFragment.DETAIL_MOVIE));

                                DetailsFragment fragment = new DetailsFragment();
                        fragment.setArguments(arguments);

                                getSupportFragmentManager().beginTransaction()
                                        .add(R.id.movie_detail_container, fragment)
                                        .commit();
                    }
            }
    }