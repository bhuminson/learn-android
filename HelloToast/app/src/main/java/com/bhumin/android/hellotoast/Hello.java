package com.bhumin.android.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class Hello extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);
        Intent intent = getIntent();
        String count = intent.getStringExtra(MainActivity.EXTRA_COUNT);
        TextView countDisplay = findViewById(R.id.current_count);
        countDisplay.setText(count);
    }
}
