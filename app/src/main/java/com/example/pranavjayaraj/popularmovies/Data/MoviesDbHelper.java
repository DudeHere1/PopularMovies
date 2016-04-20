package com.example.pranavjayaraj.popularmovies.Data;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by pranavj7 on 3/30/2016.
 */
    public class MoviesDbHelper extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION=1;
    static final String DATABASE_NAME = "movie.db";

    public MoviesDbHelper(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        final String SQL_CREATE_MOVIE_TABLE =" CREATE TABLE "+ MoviesContract.MoviesEntry.TABLE_NAME + " (" +
 MoviesContract.MoviesEntry._ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                MoviesContract.MoviesEntry.COLUMN_MOVIE_ID + " INTEGER NOT NULL, " +
                MoviesContract.MoviesEntry.COLUMN_IMAGE +" TEXT, "+
 MoviesContract.MoviesEntry.COLUMN_IMAGE2 +" TEXT, "+
 MoviesContract.MoviesEntry.COLUMN_TITLE +" TEXT NOT NULL, "+
 MoviesContract.MoviesEntry.COLUMN_DATE +" TEXT, "+
 MoviesContract.MoviesEntry.COLUMN_RATING +" INTEGER, "+
 MoviesContract.MoviesEntry.COLUMN_OVERVIEW +" TEXT, " +
 MoviesContract.MoviesEntry.COLUMN_POP +" INTEGER ,"+
 MoviesContract.MoviesEntry.COLUMN_COUNT +" INTEGER);";

        db.execSQL(SQL_CREATE_MOVIE_TABLE);
    }
@Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
    db.execSQL("DROP TABLE IF EXISTS "+ MoviesContract.MoviesEntry.TABLE_NAME);
    onCreate(db);
}
}
