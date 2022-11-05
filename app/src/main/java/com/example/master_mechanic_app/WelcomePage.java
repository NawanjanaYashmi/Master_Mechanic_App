package com.example.master_mechanic_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class WelcomePage extends AppCompatActivity {
    EditText Login_txt,Login_pass_txt;
    Button loginbtn ;
    FirebaseAuth FAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp_log);
        Login_txt = findViewById(R.id.login_txt);
        Login_pass_txt = findViewById(R.id.login_pass_txt);
        loginbtn = findViewById(R.id.logbtn);

        FAuth = FirebaseAuth.getInstance();


        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = Login_txt.getText().toString().trim();
                String password = Login_pass_txt.getText().toString().trim();

                FAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(WelcomePage.this, "User Login Successsful", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),VehicleDash.class));
                        }else{
                            Toast.makeText(WelcomePage.this, "Email Or Password Is Incorrect", Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }
        });
    }
}