package com.example.hotel111;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ResetPasswordActivity extends AppCompatActivity {

    EditText etNewPassword, etConfirm;
    Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        etNewPassword = findViewById(R.id.etNewPassword);
        etConfirm = findViewById(R.id.etConfirm);
        btnReset = findViewById(R.id.btnReset);

        btnReset.setOnClickListener(v -> {
            String password = etNewPassword.getText().toString().trim();
            String confirm = etConfirm.getText().toString().trim();

            if (password.length() < 6) {
                etNewPassword.setError("Password must be at least 6 characters");
                return;
            }
            if (!password.equals(confirm)) {
                etConfirm.setError("Passwords do not match");
                return;
            }

            getSharedPreferences("user", MODE_PRIVATE).edit()
                    .putString("password", password)
                    .apply();

            Toast.makeText(this, "Password changed", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ResetPasswordActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        });
    }
}
