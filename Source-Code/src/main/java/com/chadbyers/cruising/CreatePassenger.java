package com.chadbyers.cruising;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.chadbyers.cruising.database.DBHelper;
import com.chadbyers.cruising.database.Passenger;
import com.chadbyers.cruising.databinding.ActivityCreatePassengerBinding;

public class CreatePassenger extends AppCompatActivity {

    private ActivityCreatePassengerBinding binding;

    // Listener
    private View.OnClickListener button_create_passenger_clickListener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            String firstName = binding.edittextFirstName.getText().toString();
            String lastName = binding.edittextLastName.getText().toString();
            int passportNumber = Integer.valueOf(binding.edittextPassport.getText().toString());
            String birthdate = binding.edittextBirthdate.getText().toString();
            String city = binding.edittextCity.getText().toString();
            String state = binding.edittextState.getText().toString();

            Passenger p = new Passenger(firstName, lastName, passportNumber, birthdate, city, state);
            DBHelper helper = DBHelper.getInstance(CreatePassenger.this);

            long result = helper.insertPassenger(p);
            if(result>=0){
                Toast.makeText(CreatePassenger.this, "Success", Toast.LENGTH_SHORT).show();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCreatePassengerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.buttonCreatePassenger.setOnClickListener(button_create_passenger_clickListener);
    }
}