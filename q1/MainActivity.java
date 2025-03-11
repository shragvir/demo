package com.example.q1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;


import android.app.DatePickerDialog;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        button = findViewById(R.id.button_date);
        textView = findViewById(R.id.textView4);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get current date
                Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                // Create the DatePickerDialog
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(android.widget.DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
                                // Format the selected date
                                String formattedDate = selectedDay + "-" + (selectedMonth + 1) + "-" + selectedYear;
                                // Set the selected date to the TextView
                                textView.setText(formattedDate);
                            }
                        },
                        year,  // Initial year
                        month, // Initial month
                        day    // Initial day
                );

                // Show the DatePickerDialog
                datePickerDialog.show();
            }
        });

        Button submitButton = findViewById(R.id.button_submit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get user input
                EditText etName = findViewById(R.id.et_Name);
                String name = etName.getText().toString();

                RadioGroup genderGroup = findViewById(R.id.radioGroup_gender);
                int selectedGenderId = genderGroup.getCheckedRadioButtonId();
                String gender = "";
                if (selectedGenderId != -1) {
                    RadioButton selectedGender = findViewById(selectedGenderId);
                    gender = selectedGender.getText().toString();
                }

                TextView tvDob = findViewById(R.id.textView4);
                String dob = tvDob.getText().toString();

                TextView tvDomain = findViewById(R.id.et_domain);
                String domain = tvDomain.getText().toString();

                TextView tvWExp = findViewById(R.id.et_exp);
                String wexp = tvWExp.getText().toString();

                TextView tvQualif = findViewById(R.id.et_Qualification);
                String qualif = tvQualif.getText().toString();

                //implicit intent
                /*Uri webpage = Uri.parse("https://www.nykaa.com/?utm_source=admitad&utm_campaign=301233_20250205cl6qbf2xmxno&tagtag_uid=79dec06d3146831304ff1b15b31fd5a1");
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(intent);*/

                //explicit intent
                // Navigate to UserProfileActivity
                Intent intent = new Intent(MainActivity.this, UserProfileActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("gender", gender);
                intent.putExtra("dob", dob);
                intent.putExtra("domain", domain);
                intent.putExtra("wexp", wexp);
                intent.putExtra("qualif", qualif);
                startActivity(intent);
            }
        });



    }
}