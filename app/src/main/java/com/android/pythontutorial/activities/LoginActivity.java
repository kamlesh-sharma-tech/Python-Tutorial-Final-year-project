package com.android.pythontutorial.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.android.pythontutorial.R;
import com.android.pythontutorial.databinding.ActivityLoginBinding;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding binding;
    GoogleSignInClient mGoogleSignInClient;
    private static int RC_SIGN_IN=100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        checkExistingUser();
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Configure sign-in to request the user's ID, email address, and basic
// profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        // Check for existing Google Sign In account, if the user is already signed in
// the GoogleSignInAccount will be non-null.
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);

        // Set the dimensions of the sign-in button.

        binding.signInButton.setSize(SignInButton.SIZE_STANDARD);

        binding.signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });

        binding.textSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = binding.etLoginEmail.getText().toString();
                String password = binding.etLoginPassword.getText().toString();
                if (email.isEmpty()) {
                    Snackbar snackbar = Snackbar.make(view, "Email is required", Snackbar.LENGTH_LONG);
                    snackbar.show();
                    binding.etLoginEmail.requestFocus();
                }
                else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    Snackbar snackbar = Snackbar.make(view, "Please enter a valid email address", Snackbar.LENGTH_LONG);
                    snackbar.show();
                    binding.etLoginEmail.requestFocus();
                }
                else if (password.isEmpty()) {
                    Snackbar snackbar = Snackbar.make(view, "Password is required", Snackbar.LENGTH_LONG);
                    snackbar.show();
                    binding.etLoginPassword.requestFocus();
                }
                else {
                    processLogin(email, password);
                }
            }
        });

    }

    private void processLogin(String email, String password) {
        binding.loading.setVisibility(View.VISIBLE);
        Call<responsemodel> call = controller.getInstance()
                .getapi()
                .verifyUser(email,password);
        call.enqueue(new Callback<responsemodel>() {
            @Override
            public void onResponse(Call<responsemodel> call, Response<responsemodel> response) {
                responsemodel obj = response.body();
                if(obj.getSuccess().equals("true")){
                    SharedPreferences sharedPreferences = getSharedPreferences("credentials",0);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("name",obj.getUser().getName());
                    editor.putString("email",email);
                    editor.putString("mobile",obj.getUser().getMobile());
                    editor.putString("password",password);
                    editor.apply();
                    binding.loading.setVisibility(View.GONE);
                    Intent intent = new Intent(LoginActivity.this,Dashboard1Activity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                }else{
//                    Toast.makeText(LoginActivity.this, ""+obj.getMessage(), Toast.LENGTH_SHORT).show();
                    binding.loginError.setText(obj.getMessage());
                    binding.loading.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<responsemodel> call, Throwable t) {
//                Toast.makeText(LoginActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
                binding.loginError.setText(t.getMessage());
                binding.loading.setVisibility(View.GONE);
            }
        });
    }
    void checkExistingUser() {
        SharedPreferences sharedPreferences = getSharedPreferences("credentials",0);
        if(sharedPreferences.contains("email")){
            startActivity(new Intent(LoginActivity.this,Dashboard1Activity.class));
//            Toast.makeText(this, "Login Successfully", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);

            GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
            if (acct != null) {
                String personName = acct.getDisplayName();
                String personGivenName = acct.getGivenName();
                String personFamilyName = acct.getFamilyName();
                String personEmail = acct.getEmail();
                String personId = acct.getId();
                Uri personPhoto = acct.getPhotoUrl();

                Toast.makeText(this, "user email : "+personEmail, Toast.LENGTH_SHORT).show();

            }

            startActivity(new Intent(LoginActivity.this,Dashboard1Activity.class));

            // Signed in successfully, show authenticated UI.

        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.d("Message",e.toString());
        }
    }

}