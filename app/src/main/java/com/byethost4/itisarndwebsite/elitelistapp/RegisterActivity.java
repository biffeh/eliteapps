package com.byethost4.itisarndwebsite.elitelistapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        setTitle(R.string.register_title);

        final EditText userName = (EditText) findViewById(R.id.user_name);
        final EditText password = (EditText) findViewById(R.id.password);
        final EditText email = (EditText) findViewById(R.id.email);



        Button registerButton = (Button) findViewById(R.id.register_button);
        registerButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Sitoje vietoje rasomas kodas, kuris vykdomas ant mygtuko paspaudimo
//                Toast.makeText(LoginActivity.this,
//                        "Prisijungimo vardas: "+userName.getText().toString()+"\n"+
//                                "Slaptažodis: "+password.getText().toString(),
//                        Toast.LENGTH_LONG).show();
                boolean cancel = false;
                userName.setError(null);
                password.setError(null);
                email.setError(null);
                if (!Validation.isValidCredentials(userName.getText().toString())) {

                    userName.setError(getResources().getString(R.string.login_invalid_username_password));
                    userName.requestFocus();
                    cancel = true;
                } else if (!Validation.isValidCredentials(password.getText().toString())) {

                    password.setError(getResources().getString(R.string.login_invalid_username_password));
                    password.requestFocus();
                    cancel = true;
                } else if (!Validation.isValidEmail(email.getText().toString())){

                    email.setError(getResources().getString(R.string.login_invalid_username_password));
                    email.requestFocus();
                    cancel = true;

                }
                if (!cancel) {
                    Toast.makeText(RegisterActivity.this,
                            getResources().getString(R.string.register_success),
                            Toast.LENGTH_LONG).show();
                    Intent goToLogin = new Intent(RegisterActivity.this, LoginActivity.class);//Pirmas param = is kurios veiklos, Antras į kuria veiklą
                    startActivity(goToLogin);
                    RegisterActivity.this.finish();

                }
            }

        });
    }
}
