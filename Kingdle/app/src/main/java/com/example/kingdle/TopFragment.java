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

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        //dummy books:
        List<Book> books = new ArrayList<>();
        books.add(new Book("Book One", "Kristin Hannah", (float) 9.5, "Perfect for fans of Where the Crawdads Sing, Kristin Hannah’s stunningly beautiful and heart-wrenching dustbowl drama traces the conflicts and challenges faced by Elsa and her family, who journey west in search of a better life. ", "9781250178602", "/"));
        books.add(new Book("Book Two", "Kristin Hannah", (float) 9.5, "Perfect for fans of Where the Crawdads Sing, Kristin Hannah’s stunningly beautiful and heart-wrenching dustbowl drama traces the conflicts and challenges faced by Elsa and her family, who journey west in search of a better life. ", "9781250178602", "/"));
        books.add(new Book("Book Three", "Kristin Hannah", (float) 9.5, "Perfect for fans of Where the Crawdads Sing, Kristin Hannah’s stunningly beautiful and heart-wrenching dustbowl drama traces the conflicts and challenges faced by Elsa and her family, who journey west in search of a better life. ", "9781250178602", "/"));
        books.add(new Book("Book Four", "Kristin Hannah", (float) 9.5, "Perfect for fans of Where the Crawdads Sing, Kristin Hannah’s stunningly beautiful and heart-wrenching dustbowl drama traces the conflicts and challenges faced by Elsa and her family, who journey west in search of a better life. ", "9781250178602", "/"));
        books.add(new Book("Book Five", "Kristin Hannah", (float) 9.5, "Perfect for fans of Where the Crawdads Sing, Kristin Hannah’s stunningly beautiful and heart-wrenching dustbowl drama traces the conflicts and challenges faced by Elsa and her family, who journey west in search of a better life. ", "9781250178602", "/"));

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_top, container, false);
        // Add the following lines to create RecyclerView
        recyclerView = view.findViewById(R.id.rvBookList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new BookListAdapter(books));

        return view;
    }
}