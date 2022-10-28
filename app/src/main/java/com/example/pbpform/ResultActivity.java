package com.example.pbpform;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    TextView textNamaLengkap;
    TextView textBirthPlace;
    TextView textBirthDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textNamaLengkap = findViewById(R.id.receiver1);
        textBirthPlace = findViewById(R.id.receiver2);
        textBirthDate = findViewById(R.id.receiver3);

        //get intent
        Intent intent = getIntent();

        //get data from intent
        String namaLengkap = intent.getStringExtra("namaLengkap");
        String birthPlace = intent.getStringExtra("birthPlace");
        String birthDate = intent.getStringExtra("birthDate");

        //set text to text view
        textNamaLengkap.setText(namaLengkap);
        textBirthPlace.setText(birthPlace);
        textBirthDate.setText(birthDate);
    }
}