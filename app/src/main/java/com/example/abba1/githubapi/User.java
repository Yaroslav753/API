package com.example.abba1.githubapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("name")
    @Expose
    private String name;

    public String getName(){
        return name;
    }

}
