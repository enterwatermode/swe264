package com.example.kingdle;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class SearchFragment extends Fragment {
    final String ApiKey = "AIzaSyAaNkuJkJGeLWd3ez4_r4lpfyLaxxk-wXE";

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
        mButton.setOnClickListener(v -> {
            String title = mtitle.getText().toString();
            String author = mauthor.getText().toString();
            });

        return view;
    }
}
