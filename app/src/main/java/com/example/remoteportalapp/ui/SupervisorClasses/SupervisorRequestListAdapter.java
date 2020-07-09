package com.example.remoteportalapp.ui.SupervisorClasses;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.remoteportalapp.R;

import java.util.LinkedList;

public class SupervisorRequestListAdapter extends RecyclerView.Adapter<SupervisorRequestListAdapter.RequestListViewHolder> {

    public final LinkedList<String> mWordList;
    private LayoutInflater mInflater;
    private SupervisorRequestListFragment fragment;

    public SupervisorRequestListAdapter(SupervisorRequestListFragment context, LinkedList<String> mwordList){
        this.mWordList = mwordList;
        this.mInflater = LayoutInflater.from(context.getActivity());
        this.fragment = context;
    }

    public class RequestListViewHolder extends RecyclerView.ViewHolder{
        public final TextView lblRequestListName;
        final SupervisorRequestListAdapter mAdapter;
        public final CardView myCardview;


        public RequestListViewHolder(View itemView, SupervisorRequestListAdapter mAdapter) {
            super(itemView);
            this.lblRequestListName = itemView.findViewById(R.id.lblRequstListName);
            this.mAdapter = mAdapter;
            this.myCardview = itemView.findViewById(R.id.cardViewRequestList);
            myCardview.setClickable(true);
            myCardview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    NavDirections action = SupervisorRequestListFragmentDirections.actionSupervisorRequestListFragmentToSupervisorRequestDetailsFragment();
                    NavHostFragment.findNavController(fragment.getParentFragment()).navigate(action);
                }
            });
        }


    }

    @NonNull
    @Override
    public SupervisorRequestListAdapter.RequestListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.table_view_cell_supervisor_request_list, parent,false);
        return new RequestListViewHolder(mItemView,this);
    }

    @Override
    public void onBindViewHolder(@NonNull SupervisorRequestListAdapter.RequestListViewHolder holder, int position) {
        holder.lblRequestListName.setText(mWordList.get(position));
    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }


}
