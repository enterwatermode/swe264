package com.example.kingdle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TopbookListAdapter extends RecyclerView.Adapter<TopbookListAdapter.ViewHolder> {



    private List<Topbook> bookList;
    TopbookDao topbook_dao;

    TopbookListAdapter(List<Topbook> list, TopbookDao topbook_dao) {
        this.bookList = list;
        this.topbook_dao = topbook_dao;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivBook;
        TextView tvTitle;
        TextView tvAuthor;
        TextView tvRating;
        TextView tvDescription;
        TextView tvIsbn;
        Button buttonSave;

        ViewHolder(View bookRow) {
            super(bookRow);
            ivBook = bookRow.findViewById(R.id.ivBook);
            tvTitle = bookRow.findViewById(R.id.tvTitle);
            tvAuthor = bookRow.findViewById(R.id.tvAuthor);
            tvRating = bookRow.findViewById(R.id.tvRating);
            tvDescription = bookRow.findViewById(R.id.tvDescription);
            tvIsbn =  bookRow.findViewById(R.id.tvIsbn);
            buttonSave = bookRow.findViewById(R.id.buttonSave);
        }
    }

    @NonNull
    @Override
    public TopbookListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Topbook book = bookList.get(position);
        //Picasso.get().load("https://image.tmdb.org/t/p/w500" + movie.getPosterPath()).into(holder.ivMovie);
        holder.ivBook.setImageResource(R.drawable.ic_book_foreground);
        holder.tvTitle.setText(book.get_title());
        holder.tvAuthor.setText("Author: " + book.get_author());
        holder.tvDescription.setText("Descrition: " + book.get_description());
        holder.tvIsbn.setText("ISBN: " + book.get_isbn());
        holder.tvRating.setText("Rating: " + (book.get_rating()));
        holder.itemView.findViewById(R.id.buttonSave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("demo", "onClick for book" + book.get_title());
                TopbookTable book_to_insert = new TopbookTable(book);
                topbook_dao.insert(book_to_insert);
                Log.d("demo", "total books in db: " + topbook_dao.getAll().size());
            }
        });
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

}
