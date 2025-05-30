package com.example.brixbid;

import android.content.Intent;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    protected void setupBottomNavigation() {
        LinearLayout navBeranda = findViewById(R.id.nav_beranda);
        LinearLayout navLelang = findViewById(R.id.nav_lelang);
        LinearLayout navMenu = findViewById(R.id.nav_menu);
        LinearLayout navNotifikasi = findViewById(R.id.nav_notifikasi);
        LinearLayout navAkun = findViewById(R.id.nav_akun);

        navBeranda.setOnClickListener(v -> {
            if (!(this instanceof HomeActivity)) {
                startActivity(new Intent(this, HomeActivity.class));
                finish();
            }
        });

        navLelang.setOnClickListener(v -> {
            if (!(this instanceof MainActivity)) {
                startActivity(new Intent(this, MainActivity.class));
                finish();
            }
        });

        navMenu.setOnClickListener(v -> {
            if (!(this instanceof OpenlelangActivity)) {
                startActivity(new Intent(this, OpenlelangActivity.class));
                finish();
            }
        });

        navNotifikasi.setOnClickListener(v -> {
            if (!(this instanceof AktivitasActivity)) {
                startActivity(new Intent(this, AktivitasActivity.class));
                finish();
            }
        });

        navAkun.setOnClickListener(v -> {
            if (!(this instanceof ProfilActivity)) {
                startActivity(new Intent(this, ProfilActivity.class));
                finish();
            }
        });
    }
}
