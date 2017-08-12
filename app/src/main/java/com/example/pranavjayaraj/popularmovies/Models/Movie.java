package com.example.pranavjayaraj.popularmovies.Models;

import android.database.Cursor;
import android.os.Parcelable;
    import android.os.Parcel;

import com.example.pranavjayaraj.popularmovies.MainActivity;
import com.example.pranavjayaraj.popularmovies.MainActivityFragment;

import org.json.JSONException;
import org.json.JSONObject;

public class Movie implements Parcelable {

                    private int id;
            private String title; // original_title
           private String image; // poster_path
           private String image2; // backdrop_path
           private String overview;//overview
            private double rating; // vote_average
          private String date; // release_date
            private int count;//votecount
            private double pop;//popularity
                public Movie() {

                }

                public Movie(JSONObject movie) throws JSONException {
                    this.id = movie.getInt("id");
                    this.title = movie.getString("original_title");
                    this.image = movie.getString("poster_path");
                    this.image2 = movie.getString("backdrop_path");
                    this.overview = movie.getString("overview");
                    this.rating = movie.getDouble("vote_average");
                    this.date = movie.getString("release_date");
                    this.count=movie.getInt("vote_count");
                    this.pop=movie.getDouble("popularity");
                }

    public Movie(Cursor cursor) {
        this.id=cursor.getInt(MainActivityFragment.COL_ID);
        this.id = cursor.getInt(MainActivityFragment.COL_MOVIE_ID);
        this.title = cursor.getString(MainActivityFragment.COL_TITLE);
        this.image = cursor.getString(MainActivityFragment.COL_IMAGE);
        this.image2 = cursor.getString(MainActivityFragment.COL_IMAGE2);
        this.overview = cursor.getString(MainActivityFragment.COL_OVERVIEW);
        this.rating = cursor.getInt(MainActivityFragment.COL_RATING);
        this.date = cursor.getString(MainActivityFragment.COL_DATE);
        this.count=cursor.getInt(MainActivityFragment.COL_COUNT);
        this.pop=cursor.getLong(MainActivityFragment.COL_POP);
    }



    public int getId() {
                 return id;
               }

                   public String getTitle() {
                   return title;
               }

                   public String getImage() {
                  return image;
             }

                   public String getImage2() {
                    return image2;
               }

                    public String getOverview() {
                    return overview;
               }
                  public double getRating() {return rating;}

          public int getCount() { return count;}

    public String getDate() { return date;}
    public Double getPop() { return pop;}



                 @Override
            public int describeContents() {
                   return 0;
               }
             @Override
         public void writeToParcel(Parcel dest, int flags) {
                 dest.writeInt(id);
                    dest.writeString(title);
                  dest.writeString(image);
                   dest.writeString(image2);
                 dest.writeString(overview);
                 dest.writeDouble(rating);
                  dest.writeString(date);
                 dest.writeInt(count);
                 dest.writeDouble(pop);
             }
            public static final Parcelable.Creator<Movie> CREATOR
                  = new Parcelable.Creator<Movie>() {
             public Movie createFromParcel(Parcel in) {
                       return new Movie(in);
                      }

                           public Movie[] newArray(int size) {
                         return new Movie[size];
                    }
                };

                private Movie(Parcel in) {
                    id = in.readInt();
                   title = in.readString();
                    image = in.readString();
                   image2 = in.readString();
                    overview = in.readString();
                  rating = in.readDouble();
                    date = in.readString();
                    count =in.readInt();
                    pop =in.readDouble();
              }
        }

