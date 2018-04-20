package com.byethost4.itisarndwebsite.elitelistapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;


public class RegisterActivity extends AppCompatActivity {

    public static final String INSERT_URL = "http://itisarndwebsite.byethost4.com/mobile/insertuser.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        setTitle(R.string.register_title);

        final EditText userName = findViewById(R.id.user_name);
        final EditText password = findViewById(R.id.password);
        final EditText email = findViewById(R.id.email);



        Button registerButton = findViewById(R.id.register_button);
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
                    User user = new User(userName.getText().toString(),email.getText().toString(),password.getText().toString());

                    addToDb(user);

//                    Toast.makeText(RegisterActivity.this,
//                            getResources().getString(R.string.register_success),
//                            Toast.LENGTH_LONG).show();
                    Intent goToLogin = new Intent(RegisterActivity.this, LoginActivity.class);//Pirmas param = is kurios veiklos, Antras į kuria veiklą
                    startActivity(goToLogin);
                    RegisterActivity.this.finish();

                }
            }

        });
    }
    private void addToDb(final User newUser)
    {
        class NewEntry extends AsyncTask<String, Void, String>
        {
            ProgressDialog loading;
            DB db = new DB();

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading =  ProgressDialog.show(RegisterActivity.this,
                        getResources().getString(R.string.entry_db_loading_msg),
                        null,true,true);
            }

            @Override
            protected String doInBackground(String... strings) {
                //Pirmas String yra raktas, antras reikšmė
                HashMap<String,String> userData = new HashMap<String, String>();
                userData.put("userName",    strings[0]);
                userData.put("email",   strings[1]);
                userData.put("password", strings[2]);


                String result = db.sendPostRequest(INSERT_URL, userData);

                return result;
            }
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(RegisterActivity.this,s,Toast.LENGTH_LONG).show();
                Intent goToSearch = new Intent(RegisterActivity.this,SearchActivity.class);
                startActivity(goToSearch);
            }
        }
        NewEntry newEntry = new NewEntry();
        newEntry.execute(newUser.getUserNameForRegister(),newUser.getEmailForRegister(),
                newUser.getPasswordForLogin());
    }
}
