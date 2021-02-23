package com.example.kingdle;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kingdle.Adapter.SearchBookAdapter;
import com.example.kingdle.ApiService.GoogleBookApiService;
import com.example.kingdle.response.BookItem;
import com.example.kingdle.response.IndustryInfo;
import com.example.kingdle.response.SearchBook;
import com.example.kingdle.response.Volumeinfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchFragment extends Fragment {
    static final String API_KEY = "AIzaSyAaNkuJkJGeLWd3ez4_r4lpfyLaxxk-wXE";
    static final String BASE_URL = "https://www.googleapis.com/books/";
    static final String TAG = MainActivity.class.getSimpleName();
    static Retrofit retrofit = null;
    private RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        Button mButton = view.findViewById(R.id.mButton);
        EditText mtitle = (EditText) view.findViewById(R.id.title);
        EditText mauthor = (EditText) view.findViewById(R.id.author);
        recyclerView = view.findViewById(R.id.rvBookSearchList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        mButton.setOnClickListener(v -> {
            String title = mtitle.getText().toString();
            String author = mauthor.getText().toString();
            connect(title, author);
            });

        return view;
    }

    private void connect(String title, String author) {
        String query = "";
        if(title != null) query += title;
        if(author != null) query += "+inauthor:" + author;
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        GoogleBookApiService bookApiService = retrofit.create(GoogleBookApiService.class);


        Call<SearchBook> call = bookApiService.getSearchBook(query ,API_KEY);
        call.enqueue(new Callback<SearchBook>() {
            @Override
            public void onResponse(Call<SearchBook> call, Response<SearchBook> response) {
//                int[] ids = {R.id.txtTitle, R.id.txtReleaseDate, R.id.txtPoster,
//                        R.id.txtVote, R.id.txtOverview};
                List<BookItem> m = response.body().getItems();
                List<HashMap<String, List<String>>> books = new ArrayList<>();
                for(BookItem t: m){
                    Volumeinfo vf = t.getVolumeinfo();
                    HashMap<String, List<String>> book = new HashMap<>();
                    book.put("Title", Arrays.asList(vf.getTitle() + vf.getSubtitle()));
                    book.put("Authors", vf.getAuthors());
                    for(IndustryInfo ii: vf.getInduinfo()){
                        book.put(ii.getType(), Arrays.asList(ii.getIdentifier()));
                    }
                    book.put("Image", Arrays.asList(vf.getImageLinks().getPath()));
                    book.put("Description", Arrays.asList(vf.getDescription()));
                    books.add(book);
                }
                recyclerView.setAdapter(new SearchBookAdapter(books));
            }

            @Override
            public void onFailure(Call<SearchBook> call, Throwable throwable) {
                Log.e(TAG, throwable.toString());
            }
        });
    }
}
