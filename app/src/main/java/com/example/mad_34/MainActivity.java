package com.example.mad_34;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);

        Button submitButton = findViewById(R.id.button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUserToDatabase();
            }
        });
    }

    private void addUserToDatabase() {
        EditText nameEditText = findViewById(R.id.editTextText);
        EditText ageEditText = findViewById(R.id.editTextNumber);
        EditText genderEditText = findViewById(R.id.editTextText2);
        EditText yearOfBirthEditText = findViewById(R.id.editTextNumber2);
        EditText passwordEditText = findViewById(R.id.editTextTextPassword);

        String name = nameEditText.getText().toString();
        String ageStr = ageEditText.getText().toString();
        String gender = genderEditText.getText().toString();
        String yearOfBirthStr = yearOfBirthEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        // Check if any field is empty
        if (name.isEmpty() || ageStr.isEmpty() || gender.isEmpty() || yearOfBirthStr.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return; // Stop execution if any field is empty
        }

        // Convert age and year of birth to integer
        int age = Integer.parseInt(ageStr);
        int yearOfBirth = Integer.parseInt(yearOfBirthStr);

        // Add user to database
        databaseHelper.addUser(name, age, gender, yearOfBirth, password);

        // Display a toast message
        Toast.makeText(this, "User added successfully", Toast.LENGTH_SHORT).show();
    }
}