package com.example.remoteportalapp.ui.RemoteSession;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.remoteportalapp.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.LinkedList;

public class RemoteSessionListAdapter extends RecyclerView.Adapter<RemoteSessionListAdapter.RemoteSessionListViewHolder> {

    private RemoteSessionsFragment fragment;
    private final LinkedList<String> mWordList;
    private LayoutInflater mInflater;


    public RemoteSessionListAdapter(RemoteSessionsFragment context, LinkedList<String> wordlist){
        mInflater = LayoutInflater.from(context.getActivity());
        this.mWordList = wordlist;
        this.fragment = context;
    }

    public class RemoteSessionListViewHolder extends  RecyclerView.ViewHolder implements PopupMenu.OnMenuItemClickListener {
        public final TextView lblTitle;
//        public final TextView lblDayStatus;
//        public final TextView lblDayduration;
//        public final TextView lblTimeDuration;
        public final ImageButton btnRemoteSession;
        final RemoteSessionListAdapter mAdapter;

        public RemoteSessionListViewHolder(final View itemView, RemoteSessionListAdapter adapter){
            super(itemView);
            //final RemoteSessionsFragment context = new RemoteSessionsFragment();
            lblTitle = itemView.findViewById(R.id.lblTitleRequestSession);
            this.mAdapter = adapter;
            btnRemoteSession = itemView.findViewById(R.id.btnRemoteSession);
            btnRemoteSession.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    PopupMenu popup = new PopupMenu(itemView.getContext(),v);
                    popup.setOnMenuItemClickListener(RemoteSessionListViewHolder.this);
                    popup.inflate(R.menu.remote_sessions_menu);
                    popup.show();

                }
            });
        }

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()){
                case R.id.endSession:
                    StaffEndOrSuspendBottomSheetFragment bottomSheetFragment = new StaffEndOrSuspendBottomSheetFragment();
                    StaffEndOrSuspendBottomSheetFragment.fragmentTitle = "End Remote Session";
                    
                    bottomSheetFragment.show(fragment.getChildFragmentManager(), bottomSheetFragment.getTag());
                    break;
                case R.id.suspendSession:
                    StaffEndOrSuspendBottomSheetFragment bottomSheetFragmentSuspend = new StaffEndOrSuspendBottomSheetFragment();
                    StaffEndOrSuspendBottomSheetFragment.fragmentTitle = "Suspend Remote Session";
                    bottomSheetFragmentSuspend.show(fragment.getChildFragmentManager(), bottomSheetFragmentSuspend.getTag());

                    break;
                case R.id.cancelAction:
                    NavDirections action = RemoteSessionsFragmentDirections.actionRemoteSessionsToNavHome();
                    NavHostFragment.findNavController(fragment.getParentFragment()).navigate(action);
                    break;
                case R.id.editDate:
                    NavDirections editDateAction = RemoteSessionsFragmentDirections.actionRemoteSessionsToRequestRemoteWork();
                    NavHostFragment.findNavController(fragment.getParentFragment()).navigate(editDateAction);
                    break;
                default:
                    System.out.print("hmm");

            }

            return false;
        }
    }


    @NonNull
    @Override
    public RemoteSessionListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View mItemView = mInflater.inflate(R.layout.table_view_cell_staff_remote_sessions, parent,false);
        return new RemoteSessionListViewHolder(mItemView,this);
    }

    @Override
    public void onBindViewHolder(@NonNull RemoteSessionListViewHolder holder, int position) {
        String current = mWordList.get(position);
        holder.lblTitle.setText(current);
    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }
}
