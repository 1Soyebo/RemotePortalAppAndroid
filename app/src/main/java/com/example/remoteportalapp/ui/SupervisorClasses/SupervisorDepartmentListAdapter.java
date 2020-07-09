package com.example.remoteportalapp.ui.SupervisorClasses;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.remoteportalapp.R;

import java.util.LinkedList;

public class SupervisorDepartmentListAdapter extends RecyclerView.Adapter<SupervisorDepartmentListAdapter.SupervisorDepartmentListViewHolder> {
    public final LinkedList<String> mWordList;
    public LayoutInflater mInflater;

    public SupervisorDepartmentListAdapter(LinkedList<String> mwordlist, SupervisorDepartmentFragment context){
        this.mWordList = mwordlist;
        this.mInflater = LayoutInflater.from(context.getActivity());

    }

    public class SupervisorDepartmentListViewHolder extends RecyclerView.ViewHolder{
        public SupervisorDepartmentListAdapter mAdapter;
        public final TextView lblStaffName;

        public SupervisorDepartmentListViewHolder(View itemView, SupervisorDepartmentListAdapter adapter){
            super(itemView);
            this.lblStaffName = itemView.findViewById(R.id.lblRequstListName);
            this.mAdapter = adapter;

        }
    }

    @NonNull
    @Override
    public SupervisorDepartmentListAdapter.SupervisorDepartmentListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.table_view_cell_supervisor_request_list, parent,false);
        return new SupervisorDepartmentListViewHolder(itemView,this);
    }

    @Override
    public void onBindViewHolder(@NonNull SupervisorDepartmentListAdapter.SupervisorDepartmentListViewHolder holder, int position) {
        holder.lblStaffName.setText(mWordList.get(position));
    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }
}
