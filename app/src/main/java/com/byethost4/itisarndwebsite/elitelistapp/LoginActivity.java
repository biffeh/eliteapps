package com.byethost4.itisarndwebsite.elitelistapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
import android.widget.EditText;
import android.content.Intent;
import android.content.SharedPreferences;




public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // vykdomas tėvo metodo kodas
        setContentView(R.layout.activity_login);

        setTitle(R.string.login_label);

        // pridėta nauja eilutė
        final EditText userName = (EditText) findViewById(R.id.user_name);
        final EditText password = (EditText) findViewById(R.id.password);




        Button loginButton = (Button) findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Sitoje vietoje rasomas kodas, kuris vykdomas ant mygtuko paspaudimo
//                Toast.makeText(LoginActivity.this,
//                        "Prisijungimo vardas: "+userName.getText().toString()+"\n"+
//                                "Slaptažodis: "+password.getText().toString(),
//                        Toast.LENGTH_LONG).show();
                boolean cancel = false;
                userName.setError(null);
                password.setError(null);

                CheckBox saveLoginCheckBox;
                SharedPreferences loginPreferences;
                SharedPreferences.Editor loginPrefsEditor;
                Boolean saveLogin;

                saveLoginCheckBox = (CheckBox)findViewById(R.id.saveLoginCheckBox);
                loginPreferences = getSharedPreferences("LoginActivity", MODE_PRIVATE);
                loginPrefsEditor = loginPreferences.edit();

                saveLogin = loginPreferences.getBoolean("saveLogin", false);
                if (saveLogin) {
                    userName.setText(loginPreferences.getString("userName", ""));
                    password.setText(loginPreferences.getString("password", ""));
                    saveLoginCheckBox.setChecked(true);
                }

                if (saveLoginCheckBox.isChecked()) {
                    loginPrefsEditor.putBoolean("saveLogin", true);
                    loginPrefsEditor.putString("username", userName.getText().toString());
                    loginPrefsEditor.putString("password", password.getText().toString());
                    loginPrefsEditor.commit();
                    loginPrefsEditor.apply();
                } else {
                    loginPrefsEditor.clear();
                    loginPrefsEditor.commit();
                }


                if (!Validation.isValidCredentials(userName.getText().toString())) {

                    userName.setError(getResources().getString(R.string.login_invalid_username_password));
                    userName.requestFocus();
                    cancel = true;
                } else if (!Validation.isValidCredentials(password.getText().toString())) {

                    password.setError(getResources().getString(R.string.login_invalid_username_password));
                    password.requestFocus();
                    cancel = true;
                }
                if (!cancel) {
//                    Toast.makeText(LoginActivity.this,
//                            getResources().getString(R.string.login_invalid_username_password),
//                            Toast.LENGTH_LONG).show();
                    Intent goToSearch = new Intent(LoginActivity.this, SearchActivity.class);//Pirmas param = is kurios veiklos, Antras į kuria veiklą
                    startActivity(goToSearch);

                }
            }

        });
        Button registerButton = (Button) findViewById(R.id.register_button);
        registerButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                    Intent goToRegister = new Intent(LoginActivity.this, RegisterActivity.class);//Pirmas param = is kurios veiklos, Antras į kuria veiklą
                    startActivity(goToRegister);


                }


        });


    }
}










