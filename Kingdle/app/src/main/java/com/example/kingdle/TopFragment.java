package com.example.kingdle;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class TopFragment extends Fragment {

    private RecyclerView recyclerView;
    public TopbookDB topbook_db;
    public TopbookDao topbook_dao;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        //dummy books:
        List<Book> books = new ArrayList<>();
        books.add(new Book("The Four Winds", "Kristin Hannah", (float) 9.5, "Perfect for fans of Where the Crawdads Sing, Kristin Hannah’s stunningly beautiful and heart-wrenching dustbowl drama traces the conflicts and challenges faced by Elsa and her family, who journey west in search of a better life. ", "9781250178602", "/"));
        books.add(new Book("Faithless in Death: An Eve Dallas Novel ", "J. D. Robb", (float) 9.4, "In the new Eve Dallas police thriller from #1 New York Times-bestselling author J. D. Robb, what looked like a lover’s quarrel turned fatal has larger—and more terrifying—motives behind it… ", "9781250178602", "/"));
        books.add(new Book("The Midnight Library", "Matt Haig", (float) 9.3, "A feel-good book guaranteed to lift your spirits.", "9781250178602", "/"));
        books.add(new Book("The Sanatorium", "Sarah Pearse", (float) 9.2, "What could possibly go wrong at an abandoned sanatorium turned hotel? Throw in the Swiss Alps setting AND an off-duty detective and you know you are going to be in for some winter weather chills. And, NOT from the low temperatures. This book stopped us in our tracks. Well, at least we THINK they are our tracks.", "9781250178602", "/"));

        topbook_db = TopbookDB.getDatabase(this.getContext());
        topbook_dao = topbook_db.TopbookDao();

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_top, container, false);
        // Add the following lines to create RecyclerView
        recyclerView = view.findViewById(R.id.rvBookList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new BookListAdapter(books, topbook_dao));

        return view;
    }


}