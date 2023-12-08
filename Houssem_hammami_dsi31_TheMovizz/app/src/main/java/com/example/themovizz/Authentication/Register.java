package com.example.themovizz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register extends AppCompatActivity {
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        EditText email = findViewById(R.id.email);
        EditText password1 = findViewById(R.id.password1);
        EditText password2 = findViewById(R.id.password2);
        TextView registerText = findViewById(R.id.sig_text);
        Button register_btn = findViewById(R.id.reg_btn);

        register_btn.setOnClickListener(view -> {
            String _email = email.getText().toString();
            String _password1 = password1.getText().toString();
            String _password2 = password2.getText().toString();

            if(TextUtils.isEmpty(_email) || TextUtils.isEmpty(_password1) || !_password1.equals(_password2)) {
                Toast.makeText(Register.this, "Please put your email, password and confirm password.",
                        Toast.LENGTH_SHORT).show();
                return;
            }
            this.registerUser(_email, _password1);
        });

        registerText.setOnClickListener(view -> {
            this.toLogin();
        });
    }

    public void registerUser(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent intent = new Intent(Register.this, Login.class);
                            intent.putExtra("email", email);
                            intent.putExtra("password", password);
                            startActivity(intent);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(Register.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }
                    }
                });
    }

    public void toLogin() {
        Intent intent = new Intent(Register.this, Login.class);
        startActivity(intent);
    }
}