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

public class SavedFragment extends Fragment {

    private RecyclerView recyclerView;
    public TopbookDB topbook_db;
    public TopbookDao topbook_dao;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        //saved books
        List<Topbook> books = new ArrayList<>();

        topbook_db = TopbookDB.getDatabase(this.getContext());
        topbook_dao = topbook_db.TopbookDao();

        List<TopbookTable> bookTable = topbook_dao.getAll();


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_saved, container, false);
        // Add the following lines to create RecyclerView
        recyclerView = view.findViewById(R.id.rvSavedBookList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new SavebookListAdapter(bookTable, topbook_dao));

        return view;
    }
}
