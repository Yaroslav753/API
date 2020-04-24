package com.example.abba1.githubapi;

import retrofit2.Call;
import retrofit2.http.GET;

public class Service {

    public interface Java {
        @GET("/search/users?q=type:org+language:java+sort:repositories")
        Call<ItemList> getItems();
    }

    public interface Cpp {
        @GET("/search/users?q=type:org+language:cpp+sort:repositories")
        Call<ItemList> getItems();
    }

    public interface C {
        @GET("/search/users?q=type:org+language:c+sort:repositories")
        Call<ItemList> getItems();
    }

    public interface Csharp {
        @GET("/search/users?q=type:org+language:csharp+sort:repositories")
        Call<ItemList> getItems();
    }

    public interface HTML {
        @GET("/search/users?q=type:org+language:html+sort:repositories")
        Call<ItemList> getItems();
    }

    public interface PHP {
        @GET("/search/users?q=type:org+language:php+sort:repositories")
        Call<ItemList> getItems();
    }

    public interface Python {
        @GET("/search/users?q=type:org+language:python+sort:repositories")
        Call<ItemList> getItems();
    }

    public interface Ruby {
        @GET("/search/users?q=type:org+language:ruby+sort:repositories")
        Call<ItemList> getItems();
    }
}
