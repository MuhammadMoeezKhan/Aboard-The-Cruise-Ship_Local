package com.muhammadmoeezkhan.cruising;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.muhammadmoeezkhan.cruising.database.DBHelper;
import com.muhammadmoeezkhan.cruising.database.Passenger;
import com.muhammadmoeezkhan.cruising.databinding.ActivityUpdatePassengerBinding;

public class UpdatePassenger extends AppCompatActivity {

    private ActivityUpdatePassengerBinding binding;

    // Listeners
    private View.OnClickListener button_find_passenger_clickListener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            int id = Integer.valueOf(binding.edittextId.getText().toString());

            DBHelper helper = DBHelper.getInstance(UpdatePassenger.this);
            Passenger foundPassenger = helper.getPassengerById(id);

            binding.edittextFirstName.setText(foundPassenger.getFirstName());
            binding.edittextLastName.setText(foundPassenger.getLastName());
            binding.edittextPassport.setText(String.valueOf(foundPassenger.getPassportNumber()));
            binding.edittextBirthdate.setText(foundPassenger.getBirthdate());
            binding.edittextCity.setText(foundPassenger.getCity());
            binding.edittextState.setText(foundPassenger.getState());
        }
    };

    private View.OnClickListener button_update_passenger_clickListener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {

            DBHelper helper = DBHelper.getInstance(UpdatePassenger.this);

            int id = Integer.valueOf(binding.edittextId.getText().toString());
            String first_name =  binding.edittextFirstName.getText().toString();
            String last_name =  binding.edittextLastName.getText().toString();
            int passport_number =  Integer.valueOf(binding.edittextPassport.getText().toString());
            String birthdate =  binding.edittextBirthdate.getText().toString();
            String city =  binding.edittextCity.toString();
            String state =  binding.edittextState.getText().toString();

            Passenger updatePassenger = new Passenger(id, first_name,last_name,passport_number, birthdate, city, state);
            int rowsUpdated = helper.updatePassenger(updatePassenger);

            if(rowsUpdated>0){
                Toast.makeText(UpdatePassenger.this, "Record has been updated", Toast.LENGTH_LONG).show();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUpdatePassengerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.buttonFindPassenger.setOnClickListener(button_find_passenger_clickListener);
        binding.buttonUpdatePassenger.setOnClickListener(button_update_passenger_clickListener);
    }
}