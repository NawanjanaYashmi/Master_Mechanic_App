package com.example.master_mechanic_app;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import org.w3c.dom.Document;

import java.util.ArrayList;

public class shop extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Items> itemsArrayList;
    dataAdapter myAdapter;
    FirebaseFirestore Fstore;
    ProgressDialog progressDailog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);




        recyclerView = findViewById(R.id.Rview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Fstore = FirebaseFirestore.getInstance();
        itemsArrayList= new ArrayList<Items>();
        myAdapter= new dataAdapter(shop.this,itemsArrayList);


        recyclerView.setAdapter((myAdapter));

        EventChangeListner();

    }

    private void EventChangeListner() {
        Fstore.collection("Item").orderBy("Name", Query.Direction.ASCENDING).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if(error !=null){

                    Log.e("fire store error", error.getMessage());
                    return;
                }
                for(DocumentChange dc : value.getDocumentChanges()){
                    if(dc.getType() == DocumentChange.Type.ADDED){
                        itemsArrayList.add(dc.getDocument().toObject(Items.class));
                    }
                    myAdapter.notifyDataSetChanged();

                }
            }
        });
    }
}