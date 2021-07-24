package com.hasangurgur.firstretrofitexample;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AnimeApi {

    @GET("quotes")
    Call<List<AnimeModel>> getAnime();
}
