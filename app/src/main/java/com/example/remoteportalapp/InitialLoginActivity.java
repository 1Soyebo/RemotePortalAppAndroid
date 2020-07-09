package com.example.remoteportalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InitialLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLoginStaff = findViewById(R.id.btnLoginStaff);
        btnLoginStaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FinalLoginActivity.activityName = "Staff Login";
                NewStaffActivity.isSupervisor = false;
                Intent goToLoginStaff = new Intent(getApplicationContext(), FinalLoginActivity.class);
                startActivity(goToLoginStaff);
            }
        });

        Button btnLoginSupervisor = findViewById(R.id.btnLoginSupervisor);
        btnLoginSupervisor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FinalLoginActivity.activityName = "Supervisor Login";
                NewStaffActivity.isSupervisor = true;
                Intent goToLoginSupervisor = new Intent(getApplicationContext(), FinalLoginActivity.class);
                startActivity(goToLoginSupervisor);
            }
        });



    }
}
