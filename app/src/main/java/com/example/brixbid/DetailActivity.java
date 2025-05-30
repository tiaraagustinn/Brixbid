package com.example.brixbid;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.detail), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 👇 Tambahkan kode ini
        Button btnPembelianNPL = findViewById(R.id.btnPembelianNPL);
        btnPembelianNPL.setOnClickListener(v -> {
            Intent intent = new Intent(DetailActivity.this, BeliNplActivity.class);
            startActivity(intent);
        });

        Button btnIkutLelang = findViewById(R.id.btnIkutLelang);
        btnIkutLelang.setOnClickListener(v -> {
            Intent intent = new Intent(DetailActivity.this, NplActivity.class);
            startActivity(intent);
        });

    }
}
