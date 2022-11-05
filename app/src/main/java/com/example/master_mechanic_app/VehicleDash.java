package com.example.master_mechanic_app;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import dalvik.system.InMemoryDexClassLoader;

public class VehicleDash extends AppCompatActivity  {
    Button setcheckup ,checkBtn, setWash;
    ImageButton vehicle,tool,shop;
    TextView name_txt;
    FirebaseAuth FAuth;
    FirebaseFirestore FStore;
    String UID;
    CardView AddVehiclecard,Breakdowncard,fuelPasscard;
    ImageView profileimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_dash);

        vehicle = findViewById(R.id.carbtn);
        tool = findViewById(R.id.toolbtn);
        shop = findViewById(R.id.shopbtn);
        FStore = FirebaseFirestore.getInstance();
        FAuth = FirebaseAuth.getInstance();
        UID = FAuth.getUid();
        name_txt = findViewById(R.id.name_txt);
        AddVehiclecard = findViewById(R.id.addVehiclecard);
        Breakdowncard = findViewById(R.id.breakdowncard);
        fuelPasscard = findViewById(R.id.FuelPasscard);
        checkBtn = findViewById(R.id.checkBtn);
        profileimg = findViewById(R.id.imageView2);



        AddVehiclecard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),addnewvehicle.class));
            }
        });

        fuelPasscard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),fuelpass.class));

            }
        });

        Breakdowncard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Breakdown.class));
            }
        });

        profileimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Editprofile.class));
            }
        });

        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),shop.class));
            }
        });

        checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),cheakup.class));
            }
        });


        DocumentReference documentReference = FStore.collection("Users").document(UID);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                name_txt.setText(value.getString("name"));
            }
        });

    }
}