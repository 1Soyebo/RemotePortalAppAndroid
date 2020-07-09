package com.example.remoteportalapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;

import com.example.remoteportalapp.HelperClass;
import com.example.remoteportalapp.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
//        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
//                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        CardView cardViewRequest = view.findViewById(R.id.cardViewRequest);
        cardViewRequest.setClickable(true);
        cardViewRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(this, "go", 5ms).show();
                NavDirections action = HomeFragmentDirections.actionNavHomeToRequestRemoteWork();
                NavHostFragment.findNavController(getParentFragment()).navigate(action);
            }
        });

        CardView cardViewCheckIn = view.findViewById(R.id.cardViewCheckIn);
        cardViewCheckIn.setClickable(true);
        cardViewCheckIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(this, "go", 5ms).show();
                NavDirections action = HomeFragmentDirections.actionNavHomeToStaffCheckInFragment();
                NavHostFragment.findNavController(getParentFragment()).navigate(action);
            }
        });

        CardView cardViewSurvey = view.findViewById(R.id.cardViewSurvey);
        cardViewSurvey.setClickable(true);
        cardViewSurvey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(this, "go", 5ms).show();
                NavDirections action = HomeFragmentDirections.actionNavHomeToStaffSurveyFragment();
                NavHostFragment.findNavController(getParentFragment()).navigate(action);
            }
        });

        CardView cardViewCanteen = view.findViewById(R.id.cardViewCanteen);
        cardViewCanteen.setClickable(true);
        cardViewCanteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(this, "go", 5ms).show();
                NavDirections action = HomeFragmentDirections.actionNavHomeToStaffCanteenFragmeent();
                NavHostFragment.findNavController(getParentFragment()).navigate(action);
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

    }




}
