package com.byethost4.itisarndwebsite.elitelistapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

public class AdapterCars extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    List<Car> data= Collections.emptyList();
    Car current;
    int currentPos=0;

    // create constructor to initialize context and data sent from MainActivity
    public AdapterCars(Context context, List<Car> data){
        this.context=context;
        inflater= LayoutInflater.from(context);
        this.data=data;
        for(Car coolCar: data)
        {
            Log.e("coolCar",coolCar.getBrand()+ " " +coolCar.getData());
        }
    }

    // Inflate the layout when ViewHolder created
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.container_car, parent,false);
        MyHolder holder=new MyHolder(view);
        return holder;
    }

    // Bind data
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        // Get current position of item in RecyclerView to bind data and assign values from list
        MyHolder myHolder= (MyHolder) holder;
        Car current=data.get(position);
        myHolder.textMarke.setText(current.getBrand());
        myHolder.textSpalva.setText("Spalva: " + current.getColor());
        myHolder.textMetai.setText("Metai: " + current.getYear());
        myHolder.textKebulas.setText("Kėbulas: " + current.getType());
        Log.e("fancyCar",current.getBrand()+ " " +current.getData());

    }

    // return total item from List
    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView textMarke;
        TextView textSpalva;
        TextView textMetai;
        TextView textKebulas;

        // create constructor to get widget reference
        public MyHolder(View itemView) {
            super(itemView);
            textMarke = itemView.findViewById(R.id.textMarke);
            textSpalva = itemView.findViewById(R.id.textSpalva);
            textMetai = itemView.findViewById(R.id.textMetai);
            textKebulas = itemView.findViewById(R.id.textKebulas);
            itemView.setOnClickListener(this);
        }

        // Click event for all items
        @Override
        public void onClick(View v) {

            Toast.makeText(context, "You clicked an item", Toast.LENGTH_SHORT).show();

        }

    }

}
