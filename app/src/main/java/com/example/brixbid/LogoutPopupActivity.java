package com.example.brixbid; // Ganti dengan package kamu

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.example.brixbid.LoginActivity;
import com.example.brixbid.ProfilActivity;
import com.example.brixbid.R;

public class LogoutPopupActivity extends AppCompatActivity {

    Button btnBatal, btnKeluar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout_popup); // Pastikan ini sesuai nama layout

        btnBatal = findViewById(R.id.btnBatal);
        btnKeluar = findViewById(R.id.btnKeluar);

        // Tombol Kembali ke activity_profil
        btnBatal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogoutPopupActivity.this, ProfilActivity.class);
                startActivity(intent);
                finish(); // Optional: supaya tidak kembali ke logout lagi
            }
        });

        // Tombol Keluar ke activity_login
        btnKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogoutPopupActivity.this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK); // Clear semua activity sebelumnya
                startActivity(intent);
                finish();
            }
        });
    }
}
