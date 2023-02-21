package com.android.pythontutorial.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.android.pythontutorial.databinding.ActivityRegisterBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    ActivityRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.textLoginTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });

        binding.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });

    }

    private void registerUser() {
        String userName = String.valueOf(binding.etRegisterFullName.getText());
        String userEmail = binding.etRegisterEmail.getText().toString();
        String userContact = binding.etRegisterContact.getText().toString();
        String userPassword = binding.etRegisterPassword.getText().toString();
        String userCPassword = binding.etRegisterCPassword.getText().toString();

        if(userName.isEmpty()){
            Toast.makeText(this, "Name is required", Toast.LENGTH_SHORT).show();
            binding.etRegisterFullName.requestFocus();
            return;
        }
        if(userEmail.isEmpty()){
            Toast.makeText(this, "Email is required", Toast.LENGTH_SHORT).show();
            binding.etRegisterEmail.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()){
            Toast.makeText(this, "Please enter a valid email address", Toast.LENGTH_SHORT).show();
            binding.etRegisterEmail.requestFocus();
            return;
        }
        if(userContact.isEmpty()){
            Toast.makeText(this, "Mobile is required", Toast.LENGTH_SHORT).show();
            binding.etRegisterContact.requestFocus();
            return;
        }
        if(userContact.length()!=10){
            Toast.makeText(this, "Mobile number must contain 10 digits only", Toast.LENGTH_SHORT).show();
            binding.etRegisterContact.requestFocus();
            return;
        }
        if(userPassword.isEmpty()){
            Toast.makeText(this, "Password is required", Toast.LENGTH_SHORT).show();
            binding.etRegisterPassword.requestFocus();
            return;
        }
        if(userCPassword.isEmpty()){
            Toast.makeText(this, "Confirm Password is required", Toast.LENGTH_SHORT).show();
            binding.etRegisterCPassword.requestFocus();
            return;
        }
        if(!userCPassword.equals(userPassword)){
            Toast.makeText(this, "Password's  do not match", Toast.LENGTH_SHORT).show();
            binding.etRegisterCPassword.requestFocus();
            return;
        }

        binding.loading.setVisibility(View.VISIBLE);

        Call<RegisterResponse> call = controller.getInstance().getapi().register(userName,userEmail,userContact,userPassword);
        call.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                RegisterResponse obj = response.body();
                if(response.body().getSuccess().equals("true")){
                    Toast.makeText(RegisterActivity.this, ""+obj.getMessage(), Toast.LENGTH_SHORT).show();
                    binding.loading.setVisibility(View.GONE);
                    Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }else{
//                    Toast.makeText(RegisterActivity.this, ""+obj.getMessage(), Toast.LENGTH_SHORT).show();
                    binding.registerError.setText(obj.getMessage());
                    binding.loading.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
//                Toast.makeText(RegisterActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                binding.registerError.setText(t.getMessage());
                binding.loading.setVisibility(View.GONE);
            }
        });
    }
}