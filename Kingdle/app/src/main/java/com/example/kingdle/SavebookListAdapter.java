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

public class SavebookListAdapter extends RecyclerView.Adapter<SavebookListAdapter.ViewHolder> {



    private List<TopbookTable> bookList;
    TopbookDao topbook_dao;

    SavebookListAdapter(List<TopbookTable> list, TopbookDao topbook_dao) {
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
        Button buttonRemove;

        ViewHolder(View bookRow) {
            super(bookRow);
            ivBook = bookRow.findViewById(R.id.ivBook);
            tvTitle = bookRow.findViewById(R.id.tvTitle);
            tvAuthor = bookRow.findViewById(R.id.tvAuthor);
            tvRating = bookRow.findViewById(R.id.tvRating);
            tvDescription = bookRow.findViewById(R.id.tvDescription);
            tvIsbn =  bookRow.findViewById(R.id.tvIsbn);
            buttonRemove = bookRow.findViewById(R.id.buttonRemove);
        }
    }

    @NonNull
    @Override
    public SavebookListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.savebook_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TopbookTable book = bookList.get(position);
        //Picasso.get().load("https://image.tmdb.org/t/p/w500" + movie.getPosterPath()).into(holder.ivMovie);
        holder.ivBook.setImageResource(R.drawable.ic_book_foreground);
        holder.tvTitle.setText(book.title);
        holder.tvAuthor.setText("Author: " + book.author);
        holder.tvDescription.setText("Descrition: " + book.description);
        holder.tvIsbn.setText("ISBN: " + book.isbn);
        holder.tvRating.setText("Rating: " + (book.rating));
        holder.itemView.findViewById(R.id.buttonRemove).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.d("demo", "onClick for book" + book.get_title());
                topbook_dao.removeById(book.id);
            }
        });
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

}
