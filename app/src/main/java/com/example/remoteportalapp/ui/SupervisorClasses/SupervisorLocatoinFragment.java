package com.example.remoteportalapp.ui.SupervisorClasses;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.remoteportalapp.HelperClass;
import com.example.remoteportalapp.R;
import com.google.android.material.snackbar.Snackbar;

import java.util.LinkedList;

import segmented_control.widget.custom.android.com.segmentedcontrol.SegmentedControl;
import segmented_control.widget.custom.android.com.segmentedcontrol.item_row_column.SegmentViewHolder;
import segmented_control.widget.custom.android.com.segmentedcontrol.listeners.OnSegmentClickListener;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SupervisorLocatoinFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SupervisorLocatoinFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private LinkedList<String> mWordlist = new LinkedList<>();

    public SupervisorLocatoinFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SupervisorLocatoinFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SupervisorLocatoinFragment newInstance(String param1, String param2) {
        SupervisorLocatoinFragment fragment = new SupervisorLocatoinFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        for (int i = 0; i < 20; i++) {
            mWordlist.addLast("Word " + i);
        }

        View root = inflater.inflate(R.layout.fragment_supervisor_locatoin, container, false);
        RecyclerView locationSupervisorRecyclerView = root.findViewById(R.id.recyclerViewLocation);
        SupervisorLocationListAdapter adpater = new SupervisorLocationListAdapter(this,mWordlist);
        locationSupervisorRecyclerView.setAdapter(adpater);
        locationSupervisorRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final ConstraintLayout locateStaff = getView().findViewById(R.id.locationStaffContraintLayout);
        final ConstraintLayout viewLocations = getView().findViewById(R.id.viewLocationsContraintLayout);

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

        SegmentedControl locationSegmentControl = (SegmentedControl) getView().findViewById(R.id.supervisor_loaction_segmented_control);
        locationSegmentControl.addOnSegmentClickListener(new OnSegmentClickListener() {
            @Override
            public void onSegmentClick(SegmentViewHolder segmentViewHolder) {
                Integer position = segmentViewHolder.getSectionPosition();

                switch (position){
                    case 0:
                        locateStaff.setVisibility(View.VISIBLE);
                        viewLocations.setVisibility(View.GONE);
                        break;
                    case 1:
                        viewLocations.setVisibility(View.VISIBLE);
                        locateStaff.setVisibility(View.GONE);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + position);
                }
            }
        });

    }
}
