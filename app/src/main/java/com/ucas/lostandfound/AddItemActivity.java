package com.ucas.lostandfound;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddItemActivity extends AppCompatActivity {
    EditText etName, etLocation, etDetails;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        etName = findViewById(R.id.et_item_name_add);
        etLocation = findViewById(R.id.et_location_add);
        etDetails = findViewById(R.id.et_details_add);
        btnSubmit = findViewById(R.id.btn_add_add);

        btnSubmit.setOnClickListener(v -> {
            String name = etName.getText().toString().trim();
            String location = etLocation.getText().toString().trim();
            String details = etDetails.getText().toString().trim();

            if (name.isEmpty() || location.isEmpty() || details.isEmpty()) {
                if (name.isEmpty()) etName.setError(getString(R.string.this_is_requierd));
                if (location.isEmpty()) etLocation.setError(getString(R.string.this_is_requierd));
                if (details.isEmpty()) etDetails.setError(getString(R.string.this_is_requierd));
                return;
            }

            LostItem item = new LostItem(name, location, details);
            Intent intent = new Intent();
            intent.putExtra("newItem", item);
            setResult(RESULT_OK, intent);
            finish();
        });
    }
}
