package com.example.abba1.githubapi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.util.Linkify;;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.bumptech.glide.Glide;


public class Profile extends AppCompatActivity {
    TextView Link, Username;
    ImageView imageView;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imageView = findViewById(R.id.user_image_header);
        Username = findViewById(R.id.username);

        Link = findViewById(R.id.link);

        String username = getIntent().getExtras().getString("login");
        String avatarUrl = getIntent().getExtras().getString("avatar_url");
        String link = getIntent().getExtras().getString("html_url");

        Service_User apiService = Client.getClient().create(Service_User.class);
        Call<User> call = apiService.getList(username);

        Username.setText(username);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                String name = response.body().getName();
                if(name != null)
                    Username.setText(name);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.d("Error", t.getMessage());

            }
        });

        Link.setText(link);

        Linkify.addLinks(Link, Linkify.WEB_URLS);

        Glide.with(this)
                .load(avatarUrl)
                .placeholder(R.drawable.github)
                .into(imageView);

        getSupportActionBar().setTitle("Profile");
    }



}