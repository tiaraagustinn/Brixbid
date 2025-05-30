package com.example.brixbid;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BeliNplActivity extends AppCompatActivity {

    private Button btnLanjutkan;
    private ImageView btnBack;
    private Spinner spinnerPembayaran;
    private String selectedPaymentMethod = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beli_npl);

        initViews();
        setupSpinner();

        btnLanjutkan = findViewById(R.id.btn_lanjutkan);
        btnBack = findViewById(R.id.btn_back);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BeliNplActivity.this, DetailActivity.class);
                startActivity(intent);
                finish(); // Agar tidak bisa kembali ke form ini
            }
        });

        btnLanjutkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BeliNplActivity.this, DetailActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void initViews() {
        spinnerPembayaran = findViewById(R.id.spinner_pembayaran);
    }

    private void setupSpinner() {
        // Data untuk dropdown
        String[] metodePembayaran = {
                "Pilih Metode Pembayaran",
                "Bank BCA",
                "Bank Mandiri",
                "Bank BRI",
                "Bank BNI",
                "E-Wallet",
                "Kartu Kredit/Debit"
        };

        // Create adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                metodePembayaran
        );

        // Set dropdown layout
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Set adapter to spinner
        spinnerPembayaran.setAdapter(adapter);

        // Set listener untuk handle selection
        spinnerPembayaran.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selected = metodePembayaran[position];

                if (position == 0) {
                    // First item is placeholder, don't process
                    selectedPaymentMethod = "";
                } else {
                    selectedPaymentMethod = selected;
                    Toast.makeText(BeliNplActivity.this,
                            "Dipilih: " + selected, Toast.LENGTH_SHORT).show();

                    // Handle different payment methods
                    handlePaymentMethodSelection(selected, position);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                selectedPaymentMethod = "";
            }
        });
    }

    private void handlePaymentMethodSelection(String method, int position) {
        switch (position) {
            case 1: // Transfer Bank BCA
            case 2: // Transfer Bank Mandiri
            case 3: // Transfer Bank BRI
            case 4: // Transfer Bank BNI
                handleBankTransfer(method);
                break;

            case 5: //ewallet
                handleEWallet(method);
                break;

            case 6: // Kartu Kredit
                handleCreditCard();
                break;
        }
    }

    private void handleBankTransfer(String bankName) {
        // Logic untuk transfer bank
        // Bisa tampilkan nomor rekening, dll
        Toast.makeText(this, "Mengarahkan ke " + bankName, Toast.LENGTH_SHORT).show();
    }

    private void handleEWallet(String walletName) {
        // Logic untuk e-wallet
        // Bisa buka deeplink ke aplikasi wallet
        Toast.makeText(this, "Membuka " + walletName, Toast.LENGTH_SHORT).show();
    }

    private void handleCOD() {
        // Logic untuk COD
        Toast.makeText(this, "Cash On Delivery dipilih", Toast.LENGTH_SHORT).show();
    }

    private void handleCreditCard() {
        // Logic untuk kartu kredit
        Toast.makeText(this, "Input data kartu kredit", Toast.LENGTH_SHORT).show();
    }

    // Method untuk mendapatkan metode pembayaran yang dipilih
    public String getSelectedPaymentMethod() {
        return selectedPaymentMethod;
    }

    // Method untuk validasi sebelum proses pembayaran
    private boolean validatePaymentSelection() {
        if (selectedPaymentMethod.isEmpty()) {
            Toast.makeText(this, "Silakan pilih metode pembayaran", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    // Method untuk proses pembayaran (dipanggil dari tombol bayar)
    public void processPembayaran(View view) {
        if (validatePaymentSelection()) {
            // Lanjutkan ke proses pembayaran
            Toast.makeText(this, "Memproses pembayaran dengan " + selectedPaymentMethod,
                    Toast.LENGTH_LONG).show();

            // TODO: Implement actual payment processing
            // Intent ke halaman konfirmasi atau payment gateway
        }
    }
}