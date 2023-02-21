package com.android.pythontutorial.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.pythontutorial.ProfileActivity;
import com.android.pythontutorial.R;
import com.android.pythontutorial.databinding.ActivityDashboard1Binding;

public class Dashboard1Activity extends AppCompatActivity {

    AlertDialog.Builder builder;
    ActivityDashboard1Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashboard1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        checkUser();

        builder = new AlertDialog.Builder(this);
        binding.programsCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard1Activity.this,ProgramsActivity.class));
            }
        });

        binding.compilerCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard1Activity.this,CompilerActivity.class));
            }
        });


        binding.projectsCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard1Activity.this,ProjectActivity.class));
            }
        });


        binding.aboutCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.setMessage("Welcome to Python Tutorial Application! In this app you'll get python programs along with compiler,"+
                        " you can copy and paste the program into the compiler and run the program. I also have many python gui projects\n\n"+
                                "Thank You.")
                        .setCancelable(false)
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.setTitle("About Application");
                alert.show();
            }
        });

        binding.profileCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard1Activity.this, ProfileActivity.class));
            }
        });

        binding.logoutCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("credentials",0);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("email");
                editor.remove("password");
                editor.apply();
                Toast.makeText(Dashboard1Activity.this, "You are logged out!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Dashboard1Activity.this,LoginActivity.class));
                finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Exit Application");
        builder.setMessage("Are you sure you want to exit ?");
        builder.setCancelable(false);
        builder.setIcon(R.drawable.ic_exit);
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        AlertDialog alertDialog = builder.create();
        builder.show();
    }
    void checkUser() {
        SharedPreferences sharedPreferences = getSharedPreferences("credentials",0);
        if(!sharedPreferences.contains("email")){
            startActivity(new Intent(Dashboard1Activity.this,MainActivity.class));
        }
    }
}