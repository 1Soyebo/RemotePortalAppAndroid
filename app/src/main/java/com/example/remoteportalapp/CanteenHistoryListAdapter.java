package com.example.remoteportalapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class CanteenHistoryListAdapter extends RecyclerView.Adapter<CanteenHistoryListAdapter.CanteenHistoryListViewHolder> {
    public final LinkedList<String> mWordList;
    public LayoutInflater mInflater;

    public CanteenHistoryListAdapter(LinkedList<String> mwordlist, CanteenHistoryFragment context){
        this.mWordList = mwordlist;
        this.mInflater = LayoutInflater.from(context.getActivity());

    }

    public class CanteenHistoryListViewHolder extends RecyclerView.ViewHolder{
        public final TextView lblCanteenName;
        public CanteenHistoryListAdapter mAdapter;

        public CanteenHistoryListViewHolder(View itemView, CanteenHistoryListAdapter adapter){
            super(itemView);
            this.lblCanteenName = itemView.findViewById(R.id.lblCanteenName);
            this.mAdapter = adapter;
        }
    }

    @NonNull
    @Override
    public CanteenHistoryListAdapter.CanteenHistoryListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.table_view_cell_canteen_history, parent,false);
        return new CanteenHistoryListViewHolder(itemView,this);
    }

    @Override
    public void onBindViewHolder(@NonNull CanteenHistoryListAdapter.CanteenHistoryListViewHolder holder, int position) {
        holder.lblCanteenName.setText(mWordList.get(position));
    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }
}
