package com.example.abba1.githubapi;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Service_User {
    @GET("/users/{name}")
    Call<User> getList(
            @Path("name") String name
    );
}
