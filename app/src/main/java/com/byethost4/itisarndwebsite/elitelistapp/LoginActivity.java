package com.byethost4.itisarndwebsite.elitelistapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);// tevo vykdomas metodo kodas
        setContentView(R.layout.activity_login);

        setTitle(R.string.login_title);
        Button simpleToast /*customToast;

        // get the reference of Button's
        simpleToast = (Button) findViewById(R.id.simpleToast);
        //customToast = (Button) findViewById(R.id.customToast);
        // perform setOnClickListener event on simple Toast Button
        simpleToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // initiate a Toast with message and duration
                Toast toast = Toast.makeText(getApplicationContext(), "Simple Toast In Android", Toast.LENGTH_LONG); // initiate the Toast with context, message and duration for the Toast
                toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);     // set gravity for the Toast.
                toast.show(); // display the Toast


            }
        });
        // perform setOnClickListener event on custom Toast Button
        /*customToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve the Layout Inflater and inflate the layout from xml
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.custom_toast,
                        (ViewGroup) findViewById(R.id.toast_layout_root));
                // get the reference of TextView and ImageVIew from inflated layout
                TextView toastTextView =  layout.findViewById(R.id.toastTextView);
                ImageView toastImageView = layout.findViewById(R.id.toastImageView);
                // set the text in the TextView
                toastTextView.setText("Custom Toast In Android");
                // set the Image in the ImageView
                toastImageView.setImageResource(R.drawable.eliteicon);
                // create a new Toast using context
                Toast toast = new Toast(getApplicationContext());
                toast.setDuration(Toast.LENGTH_LONG); // set the duration for the Toast
                toast.setView(layout); // set the inflated layout
                toast.show(); // display the custom Toast

            }
        });*/

    EditText eText;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        eText = (EditText) findViewById(R.id.edittext);
        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                String str = eText.getText().toString();
                Toast msg = Toast.makeText(getBaseContext(),str,Toast.LENGTH_LONG);
                msg.show();
            }
        });
    }
}











