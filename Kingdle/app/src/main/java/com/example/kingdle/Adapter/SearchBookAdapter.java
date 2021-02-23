package com.example.kingdle.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kingdle.R;

import java.util.*;

public class SearchBookAdapter extends RecyclerView.Adapter<SearchBookAdapter.ViewHolder>{
    private List<List<String>> mData;

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        ImageView tvImage;
        TextView tvAuthor;
        TextView ivInduID;
        ViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvImage = itemView.findViewById(R.id.ivBook);
            tvAuthor = itemView.findViewById(R.id.tvAuthor);
            ivInduID = itemView.findViewById(R.id.tvInduID);
        }
    }
    @Override
    public SearchBookAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.response_row, parent, false);
        return new SearchBookAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SearchBookAdapter.ViewHolder holder, int position) {
        List<String> book = mData.get(position);
        holder.tvTitle.setText(book.get(0));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
