package com.example.pranavjayaraj.popularmovies;

import android.content.Context;
import android.database.Cursor;

import com.example.pranavjayaraj.popularmovies.Data.MoviesContract;

/**
 * Created by pranavj7 on 4/16/2016.
 */


    public class Utility {

        public static int isFavorited(Context context, int id) {
            Cursor cursor = context.getContentResolver().query(
                    MoviesContract.MoviesEntry.CONTENT_URI,
                    null,   // projection
                    MoviesContract.MoviesEntry.COLUMN_MOVIE_ID + " = ?", // selection
                    new String[] { Integer.toString(id) },   // selectionArgs
                    null    // sort order
            );
            int numRows = cursor.getCount();
            cursor.close();
            return numRows;
        }

        public static String buildImageUrl(int width, String fileName) {
            return "http://image.tmdb.org/t/p/w" + Integer.toString(width) + fileName;
        }
    }

