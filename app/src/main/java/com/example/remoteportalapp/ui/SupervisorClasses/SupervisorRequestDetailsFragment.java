package com.example.remoteportalapp.ui.SupervisorClasses;

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
import android.widget.TextView;

import com.example.remoteportalapp.HelperClass;
import com.example.remoteportalapp.R;
import com.example.remoteportalapp.ui.RemoteSession.StaffEndOrSuspendBottomSheetFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SupervisorRequestDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SupervisorRequestDetailsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SupervisorRequestDetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SupervisorRequestDetailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SupervisorRequestDetailsFragment newInstance(String param1, String param2) {
        SupervisorRequestDetailsFragment fragment = new SupervisorRequestDetailsFragment();
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
        return inflater.inflate(R.layout.fragment_supervisor_request_details, container, false);
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

        Button btnDecline = getView().findViewById(R.id.btnDecline);
        btnDecline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SupervisorDeclineREquestBottomSheet bottomSheetFragmentSuspend = new SupervisorDeclineREquestBottomSheet();
                bottomSheetFragmentSuspend.show(getChildFragmentManager(), bottomSheetFragmentSuspend.getTag());
            }
        });

        Button btnApprove = getView().findViewById(R.id.btnApprove);
        btnApprove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavDirections action = SupervisorRequestDetailsFragmentDirections.actionSupervisorRequestDetailsFragmentToSupervisoreRequestApproved();
                NavHostFragment.findNavController(getParentFragment()).navigate(action);
            }
        });
    }
}
