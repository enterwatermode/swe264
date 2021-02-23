package com.example.kingdle.ApiService;

import com.example.kingdle.responseClass.SearchBook;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GoogleBookApiService {
    @GET("v1/volumes")
    Call<SearchBook> getSearchBook(@Query("q") String q, @Query("api_key") String apiKey);
}
