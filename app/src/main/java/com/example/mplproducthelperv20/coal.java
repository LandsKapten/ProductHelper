package com.example.mplproducthelperv20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.github.javiersantos.appupdater.AppUpdater;
import com.github.javiersantos.appupdater.enums.Display;
import com.github.javiersantos.appupdater.enums.UpdateFrom;

import java.text.DecimalFormat;

public class coal extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    double checkValue;
    private static DecimalFormat df = new DecimalFormat("0.00");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coal);

        CheckBox checkbox1 = (CheckBox) findViewById(R.id.weeklyBoost);
        checkbox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                if (buttonView.isChecked()==true) {
                    checkValue = 1.2;
                } else
                {
                    checkValue = 1;
                }

            }
        });

        checkbox1.setChecked(false);
        TextView message = (TextView)findViewById(R.id.tvProdPerc);
        Button calculateButton = (Button) findViewById(R.id.calcBtn);
        EditText unitsText = (EditText) findViewById(R.id.etUnitsInRegion);
        unitsText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Button calculateButton = (Button) findViewById(R.id.calcBtn);
                EditText unitsText = (EditText) findViewById(R.id.etUnitsInRegion);

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


        calculateButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                EditText unitsText = (EditText) findViewById(R.id.etUnitsInRegion);
                TextView message = (TextView)findViewById(R.id.tvProdPerc);
                Button calculateButton = (Button) findViewById(R.id.calcBtn);

                int timesToWork = 1;
                double companyBonus = 1.8;
                double coalProduct = 0.04;
                double regionalUnits;

                try {
                    regionalUnits = Double.parseDouble(unitsText.getText().toString());
                }
                catch(NumberFormatException ex) {
                    unitsText.setError("Error!");
                    return;
                }

                double totalProductivity = regionalUnits / (coalProduct * companyBonus * checkValue);
                double neededProductivity = totalProductivity;




                if(regionalUnits <= 40){
                    while(neededProductivity > 150){

                        timesToWork++;
                        neededProductivity = totalProductivity / timesToWork;

                    }
                }
                TextView tvProd1Var = (TextView) findViewById(R.id.tvProd1);
                TextView tvProd2Var = (TextView) findViewById(R.id.tvProd2);
                TextView tvProd3Var = (TextView) findViewById(R.id.tvProd3);

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


                TextView tvProdTimesToWork = (TextView) findViewById(R.id.tvTimesToWork);
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