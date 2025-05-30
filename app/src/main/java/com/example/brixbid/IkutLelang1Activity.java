package com.example.brixbid;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;

public class IkutLelang1Activity extends AppCompatActivity {

    private View winProduct;
    private TextView tvPrice;
    private LinearLayout bidListLayout;
    private int currentPrice = 50000; // nilai awal

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ikut_lelang1); // ganti sesuai nama layout xml kamu

        // Hubungkan ke elemen layout
        tvPrice = findViewById(R.id.tv_price);
        bidListLayout = findViewById(R.id.bid_list);
        winProduct = findViewById(R.id.img_product);

        TextView btnPlus = findViewById(R.id.btn_plus);
        TextView btnSubmit = findViewById(R.id.btn_submit);


        winProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IkutLelang1Activity.this, WinnerPopupActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // Tombol "+" tambah Rp.50.000
        btnPlus.setOnClickListener(v -> {
            currentPrice += 50000;
            tvPrice.setText("Rp " + NumberFormat.getInstance().format(currentPrice));
        });

        // Tombol "↑" submit + Rp.500.000 dan tampilkan nama Noah di atas
        btnSubmit.setOnClickListener(v -> {
            int bidAmount = currentPrice + 500000;

            // Buat item penawaran baru
            LinearLayout newBidItem = new LinearLayout(this);
            newBidItem.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            newBidItem.setOrientation(LinearLayout.HORIZONTAL);
            newBidItem.setPadding(0, 8, 0, 8);

            TextView name = new TextView(this);
            name.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1));
            name.setText("Noah");
            name.setTextColor(Color.parseColor("#333333"));
            name.setTextSize(14);

            TextView amount = new TextView(this);
            amount.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            amount.setText("Rp." + NumberFormat.getInstance().format(bidAmount));
            amount.setTextColor(Color.parseColor("#333333"));
            amount.setTextSize(14);
            amount.setTypeface(null, Typeface.BOLD);

            newBidItem.addView(name);
            newBidItem.addView(amount);

            View divider = new View(this);
            divider.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1));
            divider.setBackgroundColor(Color.parseColor("#E0E0E0"));

            // Tambahkan ke atas daftar
            bidListLayout.addView(divider, 0);
            bidListLayout.addView(newBidItem, 0);

            // Reset harga ke 50.000 (opsional)
            currentPrice = 50000;
            tvPrice.setText("Rp." + NumberFormat.getInstance().format(currentPrice));
        });

    }
}