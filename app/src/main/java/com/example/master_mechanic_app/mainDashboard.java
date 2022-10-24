package com.example.master_mechanic_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;


import com.example.master_mechanic_app.databinding.ActivityMainDashboardBinding;

import java.io.CharArrayReader;

public class mainDashboard extends AppCompatActivity {

    ActivityMainDashboardBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new VehicleFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            switch(item.getItemId()){
                case R.id.vehicle:
                    replaceFragment(new VehicleFragment());
                    break;
                case R.id.repair:
                    replaceFragment(new RepairFragment());
                    break;
                case R.id.shop:
                    replaceFragment(new storeFragment());
                    break;
            }

            return true;
        });

    }


    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameView,fragment);
        fragmentTransaction.commit();
    }
}