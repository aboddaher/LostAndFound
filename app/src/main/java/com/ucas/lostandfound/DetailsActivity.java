package com.ucas.lostandfound;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {
    TextView tvItemName, tvItemLocation, tvItemDetails;
    Button btBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        tvItemName = findViewById(R.id.tv_item_name_details);
        tvItemLocation = findViewById(R.id.tv_item_location_details);
        tvItemDetails = findViewById(R.id.tv_item_details_details);
        btBack = findViewById(R.id.bt_back_details);

        LostItem item = getIntent().getParcelableExtra("item");

        if (item != null) {
            tvItemName.setText(getText(R.string.item_name) + item.getName());
            tvItemLocation.setText(getText(R.string.item_location) + item.getLocation());
            tvItemDetails.setText(getText(R.string.item_details) + item.getDetails());
        }

        btBack.setOnClickListener(v -> finish());
    }
}
