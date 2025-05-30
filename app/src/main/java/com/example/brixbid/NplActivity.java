package com.example.brixbid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class NplActivity extends AppCompatActivity {
    TextView btnNpl;
    Button btnCek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_npl);

        btnNpl = findViewById(R.id.btnNpl);
        btnCek = findViewById(R.id.btnCek);

        // Aksi ketika "Beli Nomor Peserta" diklik
        btnNpl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NplActivity.this, BeliNplActivity.class);
                startActivity(intent);
            }
        });

        // Aksi ketika "Cek Nomor" diklik
        btnCek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NplActivity.this, IkutLelang1Activity.class);
                startActivity(intent);
            }
        });
    }
}