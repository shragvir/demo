package com.example.q2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button button_register;
    TextView et_email;
    TextView et_mobileNo;
    TextView et_password;

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

        button_register=findViewById(R.id.button_register);
        et_email=findViewById(R.id.et_email);
        et_mobileNo=findViewById(R.id.et_mobileNo);
        et_password=findViewById(R.id.et_password);

        button_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = String.valueOf(et_email.getText());
                String mobileNo = String.valueOf(et_mobileNo.getText());
                String password = String.valueOf(et_password.getText());
                email = email.trim();
                if(email.isBlank()){
                    Toast.makeText(getApplicationContext(), "enter valid email", Toast.LENGTH_SHORT).show();
                }
                else if(mobileNo.isBlank() || mobileNo.length()!=10){
                    Toast.makeText(getApplicationContext(), "enter valid mobile number", Toast.LENGTH_SHORT).show();
                }
                else if(password.isEmpty()){
                    Toast.makeText(getApplicationContext(), "enter a password", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Registration succesful!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}