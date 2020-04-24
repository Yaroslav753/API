package com.example.abba1.githubapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {
    @SerializedName("login")
    @Expose
    private String login;
    @SerializedName("avatar_url")
    @Expose
    private String avatarUrl;
    @SerializedName("html_url")
    @Expose
    private String htmlUrl;

    public String getLogin(){
        return login;
    }

    public String getAvatarUrl(){
        return avatarUrl;
    }

    public String getHtmlUrl(){
        return htmlUrl;
    }

}
