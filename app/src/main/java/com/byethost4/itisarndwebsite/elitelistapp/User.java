package com.byethost4.itisarndwebsite.elitelistapp;

import android.content.Context;
import android.content.SharedPreferences;

public class User
{

    private String userName;
    private String email;
    private String password;

    private SharedPreferences sharedPreferences;
    private static final String PREFERENCES_FILE_NAME = "com.byethost12.kitm.myapplication";
    private static final String USERNAME_KEY = "username";
    private static final String PASSWORD_KEY = "password";
    private static final String REMEMBER_ME_KEY = "rememberMe";

    //Bus skirtas Loginui.
    public User(Context context)
    {
        this.sharedPreferences = context.getSharedPreferences(User.PREFERENCES_FILE_NAME,
                Context.MODE_PRIVATE);
    }
    //Šitas konstruktorius bus reikalingas kuriant naujo vartotojo registraciją.
    public User(String userName, String email, String password)
    {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public String getUserNameForRegister()
    {
        return userName;
    }

    public void setUserNameForRegister(String userName)
    {

        this.userName = userName;
    }

    public String getEmailForRegister()
    {
        return email;
    }

    public void setEmailForRegister(String email)
    {
        this.email = email;
    }

    public String getPasswordForRegister()
    {
        return password;
    }

    public void setPasswordForRegister(String password)
    {
        this.password = password;
    }
    //Šitie bus skirti prisijungimo langui
    public String getUserNameForLogin()
    {
        return this.sharedPreferences.getString(USERNAME_KEY,"") ;
    }

    public void setUserNameForLogin(String userName)
    {

        this.sharedPreferences.edit().putString(USERNAME_KEY,userName).commit();
    }

    public String getPasswordForLogin()
    {
        return this.sharedPreferences.getString(PASSWORD_KEY,"");
    }

    public void setPasswordForLogin(String password)
    {
        this.sharedPreferences.edit().putString(PASSWORD_KEY,password).commit();
    }
    public boolean isRemembered()
    {
        return this.sharedPreferences.getBoolean(REMEMBER_ME_KEY,false);
    }
    public void setRememberMeKey(boolean rememberMeKey)
    {
        this.sharedPreferences.edit().putBoolean(REMEMBER_ME_KEY,rememberMeKey).commit();
    }
}

