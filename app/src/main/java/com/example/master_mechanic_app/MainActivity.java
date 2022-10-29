package com.example.master_mechanic_app;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class MainActivity extends AppCompatActivity {

    FirebaseFirestore Fstore;
    FirebaseAuth FAuth;
    String userID;
    TextView Name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name = findViewById(R.id.name);
        FAuth = FirebaseAuth.getInstance();
        Fstore = FirebaseFirestore.getInstance();

        userID = FAuth.getUid();

        DocumentReference documentReference = Fstore.collection("Users").document("moqD9Y6at4hH2fKJMMKnlustlSA3");
        documentReference .addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                Name.setText(value.getString("name"));
            }
        });

    }
}