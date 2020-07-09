package com.example.remoteportalapp.ui.SupervisorClasses;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.remoteportalapp.R;

import java.util.LinkedList;

public class SupervisorLocationListAdapter extends RecyclerView.Adapter<SupervisorLocationListAdapter.SupervisorLocationListViewHolder> {

    public final LinkedList<String> mwwordList;
    public LayoutInflater mInfalter;

    public SupervisorLocationListAdapter(SupervisorLocatoinFragment context, LinkedList<String> mwordList){
        this.mwwordList = mwordList;
        this.mInfalter = LayoutInflater.from(context.getActivity());

    }

    public class SupervisorLocationListViewHolder extends RecyclerView.ViewHolder{
        public final TextView lblStaffName;
        public SupervisorLocationListAdapter mAdapter;

        public SupervisorLocationListViewHolder(View itemView, SupervisorLocationListAdapter adapter){
            super(itemView);
            this.lblStaffName = itemView.findViewById(R.id.lblRequstListName);
            this.mAdapter = adapter;
        }
    }


    @NonNull
    @Override
    public SupervisorLocationListAdapter.SupervisorLocationListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInfalter.inflate(R.layout.table_view_cell_supervisor_request_list,parent,false);
        return new SupervisorLocationListViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull SupervisorLocationListAdapter.SupervisorLocationListViewHolder holder, int position) {
        holder.lblStaffName.setText(mwwordList.get(position));
    }

    @Override
    public int getItemCount() {
        return mwwordList.size();
    }
}
