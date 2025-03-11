package com.example.q1;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UserProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        // Retrieve data from the Intent
        String name = getIntent().getStringExtra("name");
        String gender = getIntent().getStringExtra("gender");
        String dob = getIntent().getStringExtra("dob");
        String domain = getIntent().getStringExtra("domain");
        String wexp = getIntent().getStringExtra("wexp");
        String qualif = getIntent().getStringExtra("qualif");

        // Update UI elements
        TextView tvName = findViewById(R.id.tv_profile_name);
        TextView tvGender = findViewById(R.id.tv_profile_gender);
        TextView tvDob = findViewById(R.id.tv_profile_dob);
        TextView tvDomain = findViewById(R.id.tv_profile_domain);
        TextView tvWExp = findViewById(R.id.tv_profile_wexp);
        TextView tvQualif = findViewById(R.id.tv_profile_qualif);

        tvName.setText("Name: " + name);
        tvGender.setText("Gender: " + gender);
        tvDob.setText("DOB: " + dob);
        tvDomain.setText("Domain: " + domain);
        tvWExp.setText("Work Experience: " + wexp);
        tvQualif.setText("Qualification: " + qualif);
    }
}