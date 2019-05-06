package com.example.rachithhegde.favactor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "error";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        Interface apiService = BaseClass.getClient().create(Interface.class);

        Call<List<ModelClass>> call = apiService.getFavMovies();
        call.enqueue(new Callback<List<ModelClass>> () {
            @Override
            public void onResponse(Call<List<ModelClass>> call, Response<List<ModelClass>>  response) {


                ArrayList<ModelClass> fav = new ArrayList<ModelClass>();



                fav = (ArrayList<ModelClass>) response.body();

                AdapterClass adapter = new AdapterClass(fav,getApplicationContext());

                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

                recyclerView.setAdapter(adapter);



           //    Log.d("ActorName: ","" + fav.get(0).getActorName());
            }

            @Override
            public void onFailure(Call<List<ModelClass>> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });
    }
}
