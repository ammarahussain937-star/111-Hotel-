package com.example.hotel111;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ForgotPasswordActivity extends AppCompatActivity {

    EditText etEmail;
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        etEmail = findViewById(R.id.etEmail);
        btnSend = findViewById(R.id.btnSend);

        btnSend.setOnClickListener(v -> {
            String email = etEmail.getText().toString().trim();

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                etEmail.setError("Enter valid email");
                return;
            }

            // no backend, so we just pretend the code was sent
            Toast.makeText(this, "Recovery code sent to " + email, Toast.LENGTH_LONG).show();
            startActivity(new Intent(ForgotPasswordActivity.this, ResetPasswordActivity.class));
            finish();
        });
    }
}
