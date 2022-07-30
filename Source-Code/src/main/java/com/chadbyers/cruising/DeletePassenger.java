package com.chadbyers.cruising;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.chadbyers.cruising.database.DBHelper;
import com.chadbyers.cruising.databinding.ActivityDeletePassengerBinding;

public class DeletePassenger extends AppCompatActivity {

    private ActivityDeletePassengerBinding binding;

    // Listener
    private View.OnClickListener button_delete_passenger_clickListener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            int passportNo = Integer.valueOf(binding.edittextDeleteYear.getText().toString());

            DBHelper helper = DBHelper.getInstance(DeletePassenger.this);
            int rowsDeleted = helper.deletePassenger(passportNo);

            if(rowsDeleted>0){
                Toast.makeText(DeletePassenger.this, "Passenger With Passport No#  = " + passportNo + " Has Been Removed", Toast.LENGTH_LONG).show();
            }
            Log.d("CSC396", "" + rowsDeleted);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDeletePassengerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonDeletePassenger.setOnClickListener(button_delete_passenger_clickListener);
    }
}