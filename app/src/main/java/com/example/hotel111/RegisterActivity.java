package com.example.hotel111;

import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    EditText etName, etEmail, etPassword, etConfirm;
    Button btnRegister;
    TextView tvLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etConfirm = findViewById(R.id.etConfirm);
        btnRegister = findViewById(R.id.btnRegister);
        tvLogin = findViewById(R.id.tvLogin);

        btnRegister.setOnClickListener(v -> {
            String name = etName.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString().trim();
            String confirm = etConfirm.getText().toString().trim();

            if (name.isEmpty()) {
                etName.setError("Enter name");
                return;
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                etEmail.setError("Enter valid email");
                return;
            }
            if (password.length() < 6) {
                etPassword.setError("Password must be at least 6 characters");
                return;
            }
            if (!password.equals(confirm)) {
                etConfirm.setError("Passwords do not match");
                return;
            }

            getSharedPreferences("user", MODE_PRIVATE).edit()
                    .putString("name", name)
                    .putString("email", email)
                    .putString("password", password)
                    .apply();

            Toast.makeText(this, "Account created, please login", Toast.LENGTH_SHORT).show();
            finish();
        });

        tvLogin.setOnClickListener(v -> finish());
    }
}
