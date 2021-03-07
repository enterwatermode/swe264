package com.example.kingdle;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kingdle.ApiService.GoogleBookApiService;
import com.example.kingdle.response.SearchBook;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class TopFragment extends Fragment {
    static final String TAG = TopFragment.class.getSimpleName();
    private RecyclerView recyclerView;
    public TopbookDB topbook_db;
    public TopbookDao topbook_dao;

    //https://www.googleapis.com/books/v1/users/114632686002671658716/bookshelves/0/volumes?key=AIzaSyApal0Ji1o42yjQD8KHVAcL8RzuR0HlBdo
    private static final String BASE_URL = "https://www.googleapis.com/books/";
    private static final String API_KEY = "AIzaSyApal0Ji1o42yjQD8KHVAcL8RzuR0HlBdo";
    static Retrofit retrofit = null;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        //dummy books:
        List<Topbook> books = new ArrayList<>();
        books.add(new Topbook("The Four Winds", "Kristin Hannah", (float) 9.5, "Perfect for fans of Where the Crawdads Sing, Kristin Hannah’s stunningly beautiful and heart-wrenching dustbowl drama traces the conflicts and challenges faced by Elsa and her family, who journey west in search of a better life. ", "9781250178602", "/"));
        books.add(new Topbook("Faithless in Death: An Eve Dallas Novel ", "J. D. Robb", (float) 9.4, "In the new Eve Dallas police thriller from #1 New York Times-bestselling author J. D. Robb, what looked like a lover’s quarrel turned fatal has larger—and more terrifying—motives behind it… ", "9781250178602", "/"));
        books.add(new Topbook("The Midnight Library", "Matt Haig", (float) 9.3, "A feel-good book guaranteed to lift your spirits.", "9781250178602", "/"));
        books.add(new Topbook("The Sanatorium", "Sarah Pearse", (float) 9.2, "What could possibly go wrong at an abandoned sanatorium turned hotel? Throw in the Swiss Alps setting AND an off-duty detective and you know you are going to be in for some winter weather chills. And, NOT from the low temperatures. This book stopped us in our tracks. Well, at least we THINK they are our tracks.", "9781250178602", "/"));

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        GoogleBookApiService bookApiService = retrofit.create(GoogleBookApiService.class);
        Call<JsonElement> call = bookApiService.getTopBooks(API_KEY);

        call.enqueue(new Callback<JsonElement>() {
                         @Override
                         public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {

                             JsonElement booksJE = response.body();
                             JsonArray booksArr = ((JsonObject) booksJE).get("items").getAsJsonArray();
                             int sz = booksArr.size();
                             Gson gson = new Gson();

                             for (int i = 0; i < sz; i++) {
                                 //books.add(gson.fromJson(booksArr.get(i), Topbook.class));
                                 JsonObject b  = booksArr.get(i).getAsJsonObject();
                                 JsonObject info = b.getAsJsonObject("volumeInfo");
                                 //books.add(gson.fromJson(info, Topbook.class));

                             }

                         }
                         @Override
                         public void onFailure(Call<JsonElement> call, Throwable throwable) {
                             Log.e(TAG, throwable.toString());
                         }
                     });



        topbook_db = TopbookDB.getDatabase(this.getContext());
        topbook_dao = topbook_db.TopbookDao();

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_top, container, false);
        // Add the following lines to create RecyclerView
        recyclerView = view.findViewById(R.id.rvBookList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new TopbookListAdapter(books, topbook_dao));

        return view;
    }


}