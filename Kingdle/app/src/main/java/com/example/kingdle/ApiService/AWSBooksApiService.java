package com.example.kingdle.ApiService;

import com.example.kingdle.response.BookeTitle;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;


public interface AWSBooksApiService {
    @GET("data/content")
    Call<List<BookeTitle>> getBook();
}
