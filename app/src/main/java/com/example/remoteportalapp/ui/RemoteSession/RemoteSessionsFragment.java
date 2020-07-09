package com.example.remoteportalapp.ui.RemoteSession;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.remoteportalapp.HelperClass;
import com.example.remoteportalapp.R;

import java.util.LinkedList;

public class RemoteSessionsFragment extends Fragment {

    private RecyclerView requestSessionRecyclerView;
    private RemoteSessionListAdapter mAdapter;

    private final LinkedList<String> mWordList = new LinkedList<>();

    private GalleryViewModel galleryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_staff_remote_sessions, container, false);

        for (int i = 0; i < 20; i++) {
            mWordList.addLast("Word " + i);
        }

        requestSessionRecyclerView = (RecyclerView) root.findViewById(R.id.requestSessionRecyclerView);
        mAdapter = new RemoteSessionListAdapter(this,mWordList);
        requestSessionRecyclerView.setAdapter(mAdapter);
        requestSessionRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageButton btnMenu = getView().findViewById(R.id.btnMenu);
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HelperClass.handleMenuSlide(getActivity());
            }
        });

        TextView textDate = getView().findViewById(R.id.textTodayDate);
        textDate.setText(HelperClass.getCurrentTime());

        TextView textTime = getView().findViewById(R.id.textTodayTime);
        textTime.setText(HelperClass.getCurrentDate());





    }

//    public static void goToCancelPopMenuAction(){
//        NavDirections action = RemoteSessionsFragmentDirections.actionRemoteSessionsToNavHome();
//        NavHostFragment.findNavController(this.getParentFragment()).navigate(action);
//    }
}
