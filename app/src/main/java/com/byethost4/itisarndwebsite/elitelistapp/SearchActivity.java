package com.byethost4.itisarndwebsite.elitelistapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        Button newEntryButton = findViewById(R.id.new_entry_btn);
        newEntryButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent goToNewEntry = new Intent(SearchActivity.this, EntryActivity.class);//Pirmas param = is kurios veiklos, Antras į kuria veiklą
                startActivity(goToNewEntry);


            }


        });

    }
}
