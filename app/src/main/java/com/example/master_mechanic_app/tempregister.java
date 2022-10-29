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
import com.google.firebase.firestore.FirebaseFirestore;

public class tempregister extends AppCompatActivity {

    EditText reg_name_txt,reg_email_txt,reg_password,reg_confirm_password;
    Button reg_btn,logIn_Btn;
    FirebaseAuth FAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tempregister);

        reg_name_txt = findViewById(R.id.Reg_name_txt);
        reg_email_txt = findViewById(R.id.Reg_email_txt);
        reg_password = findViewById(R.id.Reg_password);
        reg_confirm_password = findViewById(R.id.Reg_confirm_password);
        reg_btn = findViewById(R.id.Reg_btn);
        logIn_Btn = findViewById(R.id.LogIn_Btn);
        FAuth = FirebaseAuth.getInstance();


        if(FAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),tempLog.class));
        }


        //registering the user
        reg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = reg_name_txt.getText().toString().trim();
                String email = reg_email_txt.getText().toString().trim();
                String password = reg_password.getText().toString().trim();


                FAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(tempregister.this,"user Created SuccessFuly" , Toast.LENGTH_LONG).show();
                            startActivity(new Intent(getApplicationContext(),mainDashboard.class));
                        }else{
                            Toast.makeText(tempregister.this,"Error.. Please try again later" , Toast.LENGTH_LONG).show();

                        }
                    }
                });
            }
        });



    }
}