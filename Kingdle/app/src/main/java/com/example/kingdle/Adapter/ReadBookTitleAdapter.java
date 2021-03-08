package com.example.kingdle.Adapter;
import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.kingdle.R;

import java.util.*;

public class ReadBookTitleAdapter extends RecyclerView.Adapter<ReadBookTitleAdapter.ViewHolder>{
    private List<List<String>> mData;

    public ReadBookTitleAdapter(List<List<String>> mData) {
        this.mData = mData;
    }

        public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView tvTitle;
        TextView tvContent;
        Button reButton;
        int id;

        public ViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvContent = (TextView) itemView.findViewById(R.id.tvContent);
            reButton = (Button) itemView.findViewById(R.id.ReButton);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
//            int id = v.getId();
//            int a = R.id.tvTitle;
//            int b = R.id.ReButton;
//            switch (v.getId()) {
//                case R.id.tvTitle:
//                    itemView.findViewById(R.id.tvContent).setVisibility(View.VISIBLE);
//                    break;
//                case R.id.ReButton:
//                    itemView.findViewById(R.id.tvContent).setVisibility(View.GONE);
//                    break;
//                default:
//                    break;
//            }
        }

}
    @Override
    public ReadBookTitleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.booktitle_row, parent, false);
        return new ReadBookTitleAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ReadBookTitleAdapter.ViewHolder holder, int position) {
        List<String> list = mData.get(position);
        holder.tvTitle.setText(list.get(0));
        holder.tvContent.setText(list.get(1));
        holder.tvContent.setVisibility(View.GONE);
        holder.reButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.tvContent.setVisibility(View.GONE);
            }
        });
        holder.tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.tvContent.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
