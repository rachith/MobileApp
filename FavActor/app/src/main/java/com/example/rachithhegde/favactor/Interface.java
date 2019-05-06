package com.example.rachithhegde.favactor;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Interface {

    @GET("bins/dg32h")
    Call<List<ModelClass>> getFavMovies();
}
