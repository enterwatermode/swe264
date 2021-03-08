package com.example.kingdle.ApiService;

import com.example.kingdle.response.SearchBook;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GoogleBookApiService {
    @GET("v1/volumes")
    Call<SearchBook> getSearchBook(@Query("q") String q, @Query("api_key") String apiKey);
    @GET("v1/users/114632686002671658716/bookshelves/0/volumes")
    Call<SearchBook> getTopBooks( @Query("api_key") String apiKey);
}
