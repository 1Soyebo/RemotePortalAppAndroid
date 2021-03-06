package com.example.remoteportalapp.ui.StaffClasses;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.remoteportalapp.HelperClass;
import com.example.remoteportalapp.R;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StaffCanteenFragmeent#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StaffCanteenFragmeent extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public StaffCanteenFragmeent() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StaffCanteenFragmeent.
     */
    // TODO: Rename and change types and number of parameters
    public static StaffCanteenFragmeent newInstance(String param1, String param2) {
        StaffCanteenFragmeent fragment = new StaffCanteenFragmeent();
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_staff_canteen_fragmeent, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView btnBAckRequest = getView().findViewById(R.id.btnBackRequestSuccess);
        btnBAckRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

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

        Button btnGoToCanteenHistory = getView().findViewById(R.id.btnViewCanteenHistory);
        btnGoToCanteenHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavDirections action = StaffCanteenFragmeentDirections.actionStaffCanteenFragmeentToCanteenHistoryFragment();
                NavHostFragment.findNavController(getParentFragment()).navigate(action);

            }
        });

        Button btnGoToRequestlist = getView().findViewById(R.id.btnStaffCanteenPrint);
        btnGoToRequestlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavDirections action = StaffCanteenFragmeentDirections.actionStaffCanteenFragmeentToSupervisorRequestListFragment();
                NavHostFragment.findNavController(getParentFragment()).navigate(action);
            }
        });
    }
}
