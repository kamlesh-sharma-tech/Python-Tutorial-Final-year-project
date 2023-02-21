package com.android.pythontutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.android.pythontutorial.activities.Dashboard1Activity;
import com.android.pythontutorial.databinding.ActivityProfileBinding;

public class ProfileActivity extends AppCompatActivity {
    ActivityProfileBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        checkUser();

    }

    public void checkUser() {
        SharedPreferences sharedPreferences = getSharedPreferences("credentials",0);
        if(sharedPreferences.contains("email")){
            binding.name.setText(sharedPreferences.getString("name",""));
            binding.email.setText(sharedPreferences.getString("email",""));
            binding.mobile.setText(sharedPreferences.getString("mobile",""));
            binding.password.setText(sharedPreferences.getString("password",""));
        }else{
            startActivity(new Intent(ProfileActivity.this, Dashboard1Activity.class));
        }
    }
}