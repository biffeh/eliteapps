package com.byethost4.itisarndwebsite.elitelistapp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation
{
    private static final String VALID_CREDENTIALS_REGEX = "^[A-Za-z0-9.-]{5,13}$";
    private static final String VALID_EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$";

    public static boolean isValidCredentials(String credentials)
    {
        Pattern credentialsPattern = Pattern.compile(VALID_CREDENTIALS_REGEX);
        Matcher credentialsMatcher = credentialsPattern.matcher(credentials);
        return credentialsMatcher.find();
    }
    public static boolean isValidEmail(String email)
    {
        Pattern credentialsPattern = Pattern.compile(VALID_EMAIL_REGEX);
        Matcher credentialsMatcher = credentialsPattern.matcher(email);
        return credentialsMatcher.find();
    }


}

