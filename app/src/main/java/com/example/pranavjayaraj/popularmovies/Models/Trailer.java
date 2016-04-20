package com.example.pranavjayaraj.popularmovies.Models;

import org.json.JSONObject;

/**
 * Created by pranavj7 on 4/15/2016.
 */
public class Trailer {
    private String id;
    private String key;
    private String name;
    private String type;
    private String site;
    public Trailer(){}
    public Trailer(JSONObject trailer)throws Exception
    {
        this.id=trailer.getString("id");
        this.key=trailer.getString("key");
        this.name=trailer.getString("name");
        this.type=trailer.getString("type");
        this.site=trailer.getString("site");
    }
    public String getId()
    { return id;}

    public String getKey()
    {return key;}

    public String getName()
    {return name;}
    public String getType()
    {return type;}
    public String getSite()
    {return site;}

}

