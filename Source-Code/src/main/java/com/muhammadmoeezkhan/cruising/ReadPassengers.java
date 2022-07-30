package com.muhammadmoeezkhan.cruising;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.muhammadmoeezkhan.cruising.database.DBHelper;
import com.muhammadmoeezkhan.cruising.database.Passenger;
import com.muhammadmoeezkhan.cruising.databinding.ActivityReadPassengersBinding;

import java.util.List;

public class ReadPassengers extends AppCompatActivity {

    private ActivityReadPassengersBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityReadPassengersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DBHelper helper = DBHelper.getInstance(ReadPassengers.this);
        List<Passenger> allPassengers = helper.getAllPassengers();

        ArrayAdapter<Passenger> adapter = new ArrayAdapter<Passenger>(this, android.R.layout.simple_list_item_1, allPassengers);
        binding.listviewPassengers.setAdapter(adapter);

    }
}