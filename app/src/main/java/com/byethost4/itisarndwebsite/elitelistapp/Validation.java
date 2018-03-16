package com.byethost4.itisarndwebsite.elitelistapp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation
{
    private static final String VALID_CREDENTIALS_REGEX = "^[A-Za-z0-9.-]{5,13}$";

    public static boolean isValidCredentials(String credentials)
    {
        Pattern credentialsPattern = Pattern.compile(VALID_CREDENTIALS_REGEX);
        Matcher credentialsMatcher = credentialsPattern.matcher(credentials);
        return credentialsMatcher.find();
    }

}