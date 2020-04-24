package com.example.abba1.githubapi;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UsersActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    ProgressDialog pd;

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        initViews();

    }

    private void initViews(){
        pd = new ProgressDialog(this);
        pd.setMessage("Fetching Github Users...");
        pd.setCancelable(false);
        pd.show();
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        loadJSON();
    }

    private void loadJSON(){
        try{
            String language = getIntent().getExtras().getString("language");
            Client Client = new Client();
            Call<ItemList> call = null;
            if(language.equals("cpp")) {

                Service.Cpp apiService =
                        Client.getClient().create(Service.Cpp.class);
                call = apiService.getItems();
            }
            if(language.equals("java")) {
                Service.Java apiService =
                        Client.getClient().create(Service.Java.class);
                call = apiService.getItems();
            }
            if(language.equals("c")) {
                Service.C apiService =
                        Client.getClient().create(Service.C.class);
                call = apiService.getItems();
            }
            if(language.equals("csharp")) {
                Service.Csharp apiService =
                        Client.getClient().create(Service.Csharp.class);
                call = apiService.getItems();
            }
            if(language.equals("html")) {
                Service.HTML apiService =
                        Client.getClient().create(Service.HTML.class);
                call = apiService.getItems();
            }
            if(language.equals("php")) {
                Service.PHP apiService =
                        Client.getClient().create(Service.PHP.class);
                call = apiService.getItems();
            }
            if(language.equals("python")) {
                Service.Python apiService =
                        Client.getClient().create(Service.Python.class);
                call = apiService.getItems();
            }
            if(language.equals("ruby")) {
                Service.Ruby apiService =
                        Client.getClient().create(Service.Ruby.class);
                call = apiService.getItems();
            }

            call.enqueue(new Callback<ItemList>() {
                @Override
                public void onResponse(Call<ItemList> call, Response<ItemList> response) {
                    List<Item> items = response.body().getItems();
                    recyclerView.setAdapter(new Adapter(MainActivity.Instance, items));

                    pd.hide();
                }

                @Override
                public void onFailure(Call<ItemList> call, Throwable t) {
                    Log.d("Error", t.getMessage());
                    Toast.makeText(UsersActivity.this, "Error Fetching Data!", Toast.LENGTH_SHORT).show();
                    pd.hide();

                }
            });

        }catch (Exception e){
            Log.d("Error", e.getMessage());
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
