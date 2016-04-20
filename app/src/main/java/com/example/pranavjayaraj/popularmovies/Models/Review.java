package com.example.pranavjayaraj.popularmovies.Models;

import org.json.JSONObject;

/**
 * Created by pranavj7 on 4/15/2016.
 */
public class Review {
    private String id;
    private String author;
    private String content;
public Review(){}
public Review(JSONObject trailer)throws Exception
{
    this.id=trailer.getString("id");
    this.author=trailer.getString("author");
    this.content=trailer.getString("content");

}
    public String getId()
    { return id;}

    public String getAuthor()
    {return author;}

    public String getContent()
    {return content;}

}
