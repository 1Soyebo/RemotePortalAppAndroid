package com.example.remoteportalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLoginStaff = findViewById(R.id.btnLoginStaff);
        btnLoginStaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToLoginStaff = new Intent(getApplicationContext(), LoginStaffActivity.class);
                startActivity(goToLoginStaff);
            }
        });




    }
}
