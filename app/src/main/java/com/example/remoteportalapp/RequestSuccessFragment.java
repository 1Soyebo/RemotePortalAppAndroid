package com.example.remoteportalapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RequestSuccessFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RequestSuccessFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RequestSuccessFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RequestSuccessFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RequestSuccessFragment newInstance(String param1, String param2) {
        RequestSuccessFragment fragment = new RequestSuccessFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_request_success, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView btnMenuRequestSuccess = getView().findViewById(R.id.btnMenuRequestSuccess);
        btnMenuRequestSuccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HelperClass.handleMenuSlide(getActivity());
            }
        });

        ImageView btnBackRequestSuccess = getView().findViewById(R.id.btnBackRequestSuccess);
        btnBackRequestSuccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });


        TextView textDate = getView().findViewById(R.id.textTodayDateRequestSuccess);
        textDate.setText(HelperClass.getCurrentTime());

        TextView textTime = getView().findViewById(R.id.textTodayTimeRequestSuccess);
        textTime.setText(HelperClass.getCurrentDate());

    }
}
