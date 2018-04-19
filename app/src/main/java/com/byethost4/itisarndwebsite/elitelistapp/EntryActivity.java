package com.byethost4.itisarndwebsite.elitelistapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;


public class EntryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);

        String carBrands[] =
                {
                        getResources().getString(R.string.entry_brand_audi),
                        getResources().getString(R.string.entry_brand_bmw),
                        getResources().getString(R.string.entry_brand_seat)
                };

        final Spinner carBrand = findViewById(R.id.entry_brand);
        ArrayAdapter <String> brandAdapter = new ArrayAdapter
                (this,
                        android.R.layout.simple_dropdown_item_1line,
                        carBrands
                );
        brandAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        carBrand.setAdapter(brandAdapter);
        String carTypes[] =
                {
                        getResources().getString(R.string.entry_car_type_4x4),
                        getResources().getString(R.string.entry_car_type_cabrio),
                        getResources().getString(R.string.entry_car_type_sedan)
                };
        final Spinner carType = findViewById(R.id.entry_car_type);
        ArrayAdapter <String> carTypeAdapter = new ArrayAdapter
                (this,
                        android.R.layout.simple_dropdown_item_1line,
                        carTypes
                );
        carTypeAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        carType.setAdapter(carTypeAdapter);

        RadioGroup entryColors = findViewById(R.id.entry_car_colors);
        final RadioButton entryColorBlack = findViewById(R.id.entry_car_color_black);
        final RadioButton entryColorGreen = findViewById(R.id.entry_car_color_green);
        final RadioButton entryColorSilver = findViewById(R.id.entry_car_color_silver);

        final CheckBox carDefectDamaged = findViewById(R.id.entry_car_defects_damaged);
        final CheckBox carDefectScratched = findViewById(R.id.entry_car_defects_scratched);
        final CheckBox carDefectDrowned = findViewById(R.id.entry_car_defects_drowned);

        final EditText carYear = findViewById(R.id.entry_car_year);

        Button entrySubmitBtn = findViewById(R.id.entry_submit);
        entrySubmitBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                String colorChecked = "";
                if (entryColorBlack.isChecked())
                {
                    colorChecked = entryColorBlack.getText().toString();
                } else if (entryColorGreen.isChecked())
                {
                    colorChecked = entryColorGreen.getText().toString();
                } else if (entryColorSilver.isChecked())
                {
                    colorChecked = entryColorSilver.getText().toString();
                }

                String carDefectChecked = "";
                if (carDefectDamaged.isChecked())
                {
                    carDefectChecked = carDefectChecked+carDefectDamaged.getText().toString()+" ";
                }
                if (carDefectScratched.isChecked())
                {
                    carDefectChecked = carDefectChecked+carDefectScratched.getText().toString()+" ";
                }
                if (carDefectDrowned.isChecked())
                {
                    carDefectChecked = carDefectChecked+carDefectDrowned.getText().toString()+" ";
                }
                if(!carDefectDamaged.isChecked()&&!carDefectScratched.isChecked()&&!carDefectDrowned.isChecked())
                {
                    carDefectChecked = getResources().getString(R.string.entry_car_defects_ok);
                }

                String selectBrandSpinner = carBrand.getSelectedItem().toString();
                String selectCarTypeSpinner = carType.getSelectedItem().toString();

                String enteredYear = carYear.getText().toString();
                if (!Validation.isValidYear(enteredYear))
                {
                    carYear.setError(getResources().getString(R.string.entry_car_year_error_msg));
                    carYear.requestFocus();
                }else {
                    Car car = new Car(selectBrandSpinner,
                            colorChecked,
                            Integer.parseInt(enteredYear),
                            selectCarTypeSpinner,
                            carDefectChecked);

                    Toast.makeText(EntryActivity.this,
                            "Markė: " + car.getBrand() + "\n" +
                                    "Spalva: " + car.getColor() + "\n" +
                                    "Metai: " + car.getYear() + "\n" +
                                    "Kėbulas: " + car.getType() + "\n" +
                                    "Defektai: " + car.getDefect(),
                            Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}

