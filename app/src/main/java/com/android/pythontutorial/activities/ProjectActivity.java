package com.android.pythontutorial.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.android.pythontutorial.R;
import com.android.pythontutorial.databinding.ActivityProjectBinding;

public class ProjectActivity extends AppCompatActivity {
    ActivityProjectBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProjectBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        getSupportActionBar().setTitle("Python Projects");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        binding.textEditorCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProjectActivity.this,TextEditorActivity.class);
                startActivity(intent);
            }
        });

        binding.paintCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProjectActivity.this, PaintActivity.class);
                startActivity(intent);
            }
        });

        binding.calculatorCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProjectActivity.this, CalculatorActivity.class);
                startActivity(intent);
            }
        });

        binding.pingpongCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProjectActivity.this, PingPongActivity.class);
                startActivity(intent);
            }
        });

        binding.clockCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProjectActivity.this, DigitalClockActivity.class);
                startActivity(intent);
            }
        });

        binding.mailCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProjectActivity.this, EmailActivity.class);
                startActivity(intent);
            }
        });
    }
}