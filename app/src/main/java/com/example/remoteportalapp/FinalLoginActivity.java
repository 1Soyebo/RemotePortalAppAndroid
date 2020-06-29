package com.example.remoteportalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class FinalLoginActivity extends AppCompatActivity {

    public static String activityName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_staff);

        Button btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToHomeView = new Intent(getApplicationContext(), NewStaffActivity.class);
                startActivity(goToHomeView);
            }
        });


        ImageView backButton = findViewById(R.id.btnBack);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        TextView viewTitle = findViewById(R.id.lblLoginTitle);
        viewTitle.setText(activityName);
    }
}
