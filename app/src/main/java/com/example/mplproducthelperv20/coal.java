package com.example.mplproducthelperv20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mplproducthelperv20.R;

import java.text.DecimalFormat;

public class coal extends AppCompatActivity implements AdapterView.OnItemSelectedListener {



    double productValue;
    double checkValue;
    private static DecimalFormat df = new DecimalFormat("0.00");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coal);

        CheckBox checkbox1 = findViewById(R.id.weeklyBoost);
        checkbox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                if (buttonView.isChecked()) {
                    checkValue = 1.2;
                } else
                {
                    checkValue = 1;
                }

            }
        });


        checkbox1.setChecked(false);
        TextView message = findViewById(R.id.tvProdPerc);
        Button calculateButton = findViewById(R.id.calcBtn);
        EditText unitsText = findViewById(R.id.etUnitsInRegion);
        unitsText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Button calculateButton = findViewById(R.id.calcBtn);
                EditText unitsText = findViewById(R.id.etUnitsInRegion);

                double unitsString;
                try {
                    unitsString = Double.parseDouble(unitsText.getText().toString());
                } catch ( Exception e) {
                    unitsString = 0;

                }

                if (unitsString > 40){
                    calculateButton.setEnabled(false);
                    unitsText.setError("Too high! (Max 40)");
                }else
                    calculateButton.setEnabled(true);
                calculateButton.setText("Calculate");
            }



            @Override
            public void afterTextChanged(Editable s){}
        });
        Spinner productList = findViewById(R.id.spinProducts);
        productList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch(position){
                    case 0 : //Bacon
                        productValue = 0.1;
                        break;
                    case 1 : //Ballistic Missile
                        productValue = 0.005;
                        break;
                    case 2 : //Beef Steak
                        productValue = 0.13333333333333333;
                        break;
                    case 3 : //Beer Pint
                        productValue = 0.08;
                        break;
                    case 4 : //Bitto Cheese
                        productValue = 0.004;
                        break;
                    case 5 : //Bomber Jet
                        productValue = 0.0005;
                        break;
                    case 6 : //Bread
                        productValue = 0.08;
                        break;
                    case 7 : //Cheese
                        productValue = 0.08;
                        break;
                    case 8 : //Chemical Bomb
                        productValue = 0.002;
                        break;
                    case 9 : //Chemical Compounds
                        productValue = 0.06666666666666667;
                        break;
                    case 10 : //Citrozën C4
                        productValue = 0.0013333333333333333;
                        break;
                    case 11 : //Clothes Q1
                        productValue = 0.04;
                        break;
                    case 12 : //Clothes Q2
                        productValue = 0.016;
                        break;
                    case 13 : //Coal
                        productValue = 0.04;
                        break;
                    case 14 : //Coffee Beans
                        productValue = 0.028571428571428574;
                        break;
                    case 15 : //Coffee(Restaurant)
                        productValue = 0.08;
                        break;
                    case 16 : //Coffee(Shop)
                        productValue = 0.1;
                        break;
                    case 17 : //Corn
                        productValue = 1;
                        break;
                    case 18 : //Corn Flour
                        productValue = 0.06666666666666667;
                        break;
                    case 19 : //Cotton
                        productValue = 0.01;
                        break;
                    case 20 : //Cotton Paper
                        productValue = 0.02;
                        break;
                    case 21 : //Diesel
                        productValue = 0.8;
                        break;
                    case 22 : //Document Forms
                        productValue = 0.04;
                        break;
                    case 23 : //Efficiency Book
                        productValue = 0.02;
                        break;
                    case 24 : //Fabrics
                        productValue = 0.04;
                        break;
                    case 25 : //Fertilizer
                        productValue = 0.008;
                        break;
                    case 26 : //Gas Mask
                        productValue = 0.02;
                        break;
                    case 27 : //Glass Panel
                        productValue = 0.02;
                        break;
                    case 28 : //Grapes
                        productValue = 0.08;
                        break;
                    case 29 : //Heavy Tank
                        productValue = 0.0008;
                        break;
                    case 30 : //House Window
                        productValue = 0.013333333333333332;
                        break;
                    case 31 : //Iron
                        productValue = 0.04;
                        break;
                    case 32 : //Kerosene
                        productValue = 0.4;
                        break;
                    case 33 : //Learning Book
                        productValue = 0.01;
                        break;
                    case 34 : //Leather
                        productValue = 0.03333333333333333;
                        break;
                    case 35 : //Mansion
                        productValue = 0.03333333333333333;
                        break;
                    case 36 : //Meat
                        productValue = 0.1;
                        break;
                    case 37 : //Military Parts
                        productValue = 0.026666666666666665;
                        break;
                    case 38 : //Military Vehicle Upgrade
                        productValue = 0.02;
                        break;
                    case 39 : //Milk jug
                        productValue = 0.13333333333333333;
                        break;
                    case 40 : //Mocaccino
                        productValue = 0.04;
                        break;
                    case 41 : //Newspaper
                        productValue = 2;
                        break;
                    case 42 : //Nice Apartment
                        productValue = 0.0004;
                        break;
                    case 43 : //Nuclear Bomb
                        productValue = 0.0013333333333333333;
                        break;
                    case 44 : //Oil
                        productValue = 0.04;
                        break;
                    case 45 : //Paper
                        productValue = 0.04;
                        break;
                    case 46 : //Plastic
                        productValue = 0.04;
                        break;
                    case 47 : //Polyester
                        productValue = 0.04;
                        break;
                    case 48 : //Pressed Wine
                        productValue = 0.08;
                        break;
                    case 49 : //Private Plane
                        productValue = 0.0006666666666666666;
                        break;
                    case 50 : //Processed Fuel
                        productValue = 0.13333333333333333;
                        break;
                    case 51 : //Processed Milk
                        productValue = 0.05714285714285715;
                        break;
                    case 52 : //Raw Milk
                        productValue = 0.2;
                        break;
                    case 53 : //Receipts
                        productValue = 0.2;
                        break;
                    case 54 : //Sand
                        productValue = 0.04;
                        break;
                    case 55 : //Small House
                        productValue = 0.0008;
                        break;
                    case 56 : //Steel
                        productValue = 0.05714285714285715;
                        break;
                    case 57 : //Stone
                        productValue = 0.04;
                        break;
                    case 58 : //Uranium
                        productValue = 0.008;
                        break;
                    case 59 : //Vegetables
                        productValue = 0.06666666666666667;
                        break;
                    case 60 : //Vehicles Parts
                        productValue = 0.026666666666666665;
                        break;
                    case 61 : //Weapons Q1
                        productValue = 0.026666666666666665;
                        break;
                    case 62 : //Weapons Q2
                        productValue = 0.013793103448275864;
                        break;
                    case 63 : //Wheat
                        productValue = 0.06666666666666667;
                        break;
                    case 64 : //Wheat Flour
                        productValue = 0.08;
                        break;
                    case 65 : //Wood
                        productValue = 0.04;
                        break;
                    case 66 : //Work Ethics Course
                        productValue = 0.001;
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        calculateButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                EditText unitsText = findViewById(R.id.etUnitsInRegion);
                TextView message = findViewById(R.id.tvProdPerc);
                Button calculateButton = findViewById(R.id.calcBtn);
                int timesToWork = 1;
                double companyBonus = 1.8;
                double regionalUnits;

                try {
                    regionalUnits = Double.parseDouble(unitsText.getText().toString());
                }
                catch(NumberFormatException ex) {
                    unitsText.setError("Error!");
                    return;
                }

                double totalProductivity = regionalUnits / (productValue * companyBonus * checkValue);
                double neededProductivity = totalProductivity;




                if(regionalUnits <= 40){
                    while(neededProductivity > 150){

                        timesToWork++;
                        neededProductivity = totalProductivity / timesToWork;

                    }
                }
                TextView tvProd1Var = findViewById(R.id.tvProd1);
                TextView tvProd2Var = findViewById(R.id.tvProd2);
                TextView tvProd3Var = findViewById(R.id.tvProd3);

                int timesToWork2 = timesToWork + 1;
                int timesToWork3 = timesToWork + 2;
                int timesToWork4 = timesToWork + 3;
                double neededProductivity2 = totalProductivity / timesToWork2;
                double neededProductivity3 = totalProductivity / timesToWork3;
                double neededProductivity4 = totalProductivity / timesToWork4;

                String timesString = "<b>" + timesToWork2 + "</b>" + " times at " + "<b>" + df.format(neededProductivity2) + "%</b>" + " productivity";
                String timesString2 = "<b>" + timesToWork3 + "</b>" + " times at " + "<b>" + df.format(neededProductivity3) + "%</b>" + " productivity";
                String timesString3 = "<b>" + timesToWork4 + "</b>" + " times at " + "<b>" + df.format(neededProductivity4) + "%</b>" + " productivity";

                tvProd1Var.setText(Html.fromHtml(timesString));
                tvProd2Var.setText(Html.fromHtml(timesString2));
                tvProd3Var.setText(Html.fromHtml(timesString3));


                TextView tvProdTimesToWork = findViewById(R.id.tvTimesToWork);
                String timesString4 = "You need to work <b>" + timesToWork + "</b>" + " time at " + "<b>" + df.format(neededProductivity) + "%</b>" + " productivity";
                tvProdTimesToWork.setText(Html.fromHtml(timesString4));


                message.setText(df.format(neededProductivity) + "%");

            }

        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}