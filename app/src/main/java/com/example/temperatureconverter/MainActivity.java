package com.example.temperatureconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

//    EditText Temp = findViewById(R.id.inputTemp);
//    RadioButton rbC = findViewById(R.id.RbCelc);
//    RadioButton rbF = findViewById(R.id.RdbFarn);
//    TextView Lbl = findViewById(R.id.labelAns);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Button calcB = findViewById(R.id.BtnCalculate);


        calcB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateAnswer();
            }
        });
    }

    private void calculateAnswer(){
        EditText Temp = findViewById(R.id.inputTemp);
        RadioButton rbC = findViewById(R.id.RbCelc);
        RadioButton rbF = findViewById(R.id.RdbFarn);
        TextView Lbl = findViewById(R.id.labelAns);
        Calculations objCal = new Calculations();

        Float ans;
        if(Temp.getText().toString().isEmpty())
            Toast.makeText(this,"Please add a value", Toast.LENGTH_LONG).show();
        else {
            if(rbC.isChecked()) {
                ans = objCal.convertCelciusToFahrenheit(Float.valueOf(Temp.getText().toString()));
                Lbl.setText(String.valueOf(ans));
            }
            else {
                ans = objCal.convertFahrenheitToCelcius(Float.valueOf(Temp.getText().toString()));
                Lbl.setText(String.valueOf(ans));
            }
        }
    }
}