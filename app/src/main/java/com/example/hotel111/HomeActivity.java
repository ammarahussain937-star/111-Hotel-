package com.example.hotel111;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        String name = getSharedPreferences("user", MODE_PRIVATE).getString("name", "Admin");
        TextView tvHello = findViewById(R.id.tvHello);
        tvHello.setText("Hello, " + name + "!");

        findViewById(R.id.cardBuckets).setOnClickListener(v -> showToast("Buckets"));
        findViewById(R.id.cardBurgers).setOnClickListener(v -> showToast("Burgers"));
        findViewById(R.id.cardSnacks).setOnClickListener(v -> showToast("Snacks"));
        findViewById(R.id.cardDrinks).setOnClickListener(v -> showToast("Drinks"));
        findViewById(R.id.cardDeals).setOnClickListener(v -> showToast("Deals"));

        View.OnClickListener openProfile = v ->
                startActivity(new Intent(HomeActivity.this, ProfileActivity.class));
        findViewById(R.id.cardProfile).setOnClickListener(openProfile);
        findViewById(R.id.btnProfile).setOnClickListener(openProfile);
    }

    private void showToast(String item) {
        Toast.makeText(this, item + " coming soon", Toast.LENGTH_SHORT).show();
    }
}
