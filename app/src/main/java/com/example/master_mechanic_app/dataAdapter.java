package com.example.master_mechanic_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class dataAdapter extends RecyclerView.Adapter<dataAdapter.MyViewHolder> {

    Context context;

    public dataAdapter(Context context, ArrayList<Items> itemsArrayList) {
        this.context = context;
        this.itemsArrayList = itemsArrayList;
    }

    ArrayList<Items> itemsArrayList;

    @NonNull
    @Override
    public dataAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View  v = LayoutInflater.from(context).inflate(R.layout.item_row,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull dataAdapter.MyViewHolder holder, int position) {
        Items items = itemsArrayList.get(position);
        holder.itemname.setText(items.Name);
        holder.price.setText(String.valueOf(items.price));
    }

    @Override
    public int getItemCount() {
        return itemsArrayList.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView itemname,price;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            itemname = itemView.findViewById(R.id.ItemName);
            price = itemView.findViewById(R.id.price);
        }



    }

}
