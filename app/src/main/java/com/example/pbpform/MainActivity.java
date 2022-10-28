package com.example.pbpform;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.res.Configuration;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;

import android.os.Bundle;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button sendButton;
    EditText nameText;
    EditText placeText;
    TextView birthText;
    DatePickerDialog.OnDateSetListener setListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendButton = findViewById(R.id.buttonId);
        nameText = findViewById(R.id.nameId);
        placeText = findViewById(R.id.placeId);
        birthText = findViewById(R.id.birthId);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);


        int nightModeFlags =
                getApplicationContext().getResources().getConfiguration().uiMode &
                        Configuration.UI_MODE_NIGHT_MASK;
        int bgDatePicker = 0;
        switch (nightModeFlags) {
            case Configuration.UI_MODE_NIGHT_NO:
                bgDatePicker = android.R.color.background_light;
                break;

            case Configuration.UI_MODE_NIGHT_YES:
                bgDatePicker = android.R.color.background_dark;
                break;

        }

        int finalBgDatePicker = bgDatePicker;
        birthText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        MainActivity.this,
                        setListener,
                        year, month, day);
                datePickerDialog.getWindow().setBackgroundDrawableResource(finalBgDatePicker);
                datePickerDialog.show();
            }
        });

        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String date = day + "/" + month + "/" + year;
                birthText.setText(date);
            }
        };


        //add on click listener to button
        sendButton.setOnClickListener(v -> {
            //get text from edit text
            String namaLengkap = nameText.getText().toString();
            String birthPlace = placeText.getText().toString();
            String birthDate = birthText.getText().toString();

            if(birthDate.equals("Tanggal Lahir")){
                birthDate = "";
            }

            //create intent
            Intent intent = new Intent(MainActivity.this, ResultActivity.class);

            //put text in intent
            intent.putExtra("namaLengkap", namaLengkap);
            intent.putExtra("birthPlace", birthPlace);
            intent.putExtra("birthDate", birthDate);

            //start activity
            startActivity(intent);
        });
    }
}