package com.example.brixbid;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.brixbid.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private RecyclerView recyclerView;
    private ProductAdapter adapter;
    private List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setupRecyclerView();
        loadProducts();

        setupBottomNavigation();

    }


    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
    }

    private void setupRecyclerView() {
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);

        productList = new ArrayList<>();
        adapter = new ProductAdapter(productList);
        recyclerView.setAdapter(adapter);
    }

    private void loadProducts() {
        // Sample data
        productList.add(new Product("Bata Sikat - 35 Buah", "4.5", "20 Terjual", "Rp 1.260.000", "17 April 2025\nSURABAYA", R.drawable.batu));
        productList.add(new Product("Kayu Utuh - 30 Buah", "4.8", "15 Terjual", "Rp 2.500.000", "17 April 2025\nSURABAYA", R.drawable.kayu));
        productList.add(new Product("Nippon Paint Sikat - 3 dm", "4.6", "35 Terjual", "Rp 1.869.000", "17 April 2025\nSURABAYA", R.drawable.cat));
        productList.add(new Product("Seng Universal - 250 lembar", "4.4", "12 Terjual", "Rp 48.000", "17 April 2025\nSURABAYA", R.drawable.seng));
        productList.add(new Product("Besi Beton - 12mm", "4.7", "28 Terjual", "Rp 850.000", "17 April 2025\nSURABAYA", R.drawable.kawat));
        productList.add(new Product("Pipa PVC - 4 inch", "4.3", "18 Terjual", "Rp 320.000", "17 April 2025\nSURABAYA", R.drawable.pipa));

        adapter.notifyDataSetChanged();
    }

    // Product Model Class
    public static class Product {
        private String title;
        private String rating;
        private String sold;
        private String price;
        private String location;
        private int imageRes;

        public Product(String title, String rating, String sold, String price, String location, int imageRes) {
            this.title = title;
            this.rating = rating;
            this.sold = sold;
            this.price = price;
            this.location = location;
            this.imageRes = imageRes;
        }

        // Getters
        public String getTitle() { return title; }
        public String getRating() { return rating; }
        public String getSold() { return sold; }
        public String getPrice() { return price; }
        public String getLocation() { return location; }
        public int getImageRes() { return imageRes; }
    }

    // RecyclerView Adapter
    public static class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
        private List<Product> products;

        public ProductAdapter(List<Product> products) {
            this.products = products;
        }

        @NonNull
        @Override
        public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.activity_lelang, parent, false);
            return new ProductViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
            Product product = products.get(position);
            holder.bind(product);
        }



        @Override
        public int getItemCount() {
            return products.size();
        }

        // ViewHolder Class
        public static class ProductViewHolder extends RecyclerView.ViewHolder {
            private ImageView ivProduct;
            private TextView tvTitle;
            private TextView tvRating;
            private TextView tvSold;
            private TextView tvPrice;
            private TextView tvLocation;

            public ProductViewHolder(@NonNull View itemView) {
                super(itemView);
                ivProduct = itemView.findViewById(R.id.ivProduct);
                tvTitle = itemView.findViewById(R.id.tvTitle);
                tvRating = itemView.findViewById(R.id.tvRating);
                tvSold = itemView.findViewById(R.id.tvSold);
                tvPrice = itemView.findViewById(R.id.tvPrice);
                tvLocation = itemView.findViewById(R.id.tvLocation);
            }

            public void bind(Product product) {
                tvTitle.setText(product.getTitle());
                tvRating.setText(product.getRating());
                tvSold.setText(product.getSold());
                tvPrice.setText(product.getPrice());
                tvLocation.setText(product.getLocation());
                ivProduct.setImageResource(product.getImageRes());

                itemView.setOnClickListener(v -> {
                    if (product.getTitle().equalsIgnoreCase("Kayu Utuh - 30 Buah")) {
                        Intent intent = new Intent(itemView.getContext(), DetailActivity.class);
                        itemView.getContext().startActivity(intent);
                    }
                });

            }

        }
    }

}