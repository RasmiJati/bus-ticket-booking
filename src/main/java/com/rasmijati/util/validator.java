/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasmijati.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author admin
 */
public abstract class validator {

    public static boolean isValidateString(String str) {
        String regex = "^[A-Za-z]+$";
        Pattern p = Pattern.compile(regex);  //compile regex
        Matcher m = p.matcher(str); //matcher() method find matching between name and regular expression
        return m.matches(); //return if name matches regex
    }

    public static boolean isValidatePhoneNumber(String str) {
        String regex = "[9][0-9]{9}";          //start with 9 and number of digit 10 
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    public static boolean isValidateNumber(String str) {
        String regex = "^[0-9]+$";          //start with 9 and number of digit 10 
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    public static boolean isValidateEmail(String str) {
        String regex = "^[a-z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";  //rasmi@gmail.com  //rasmi01@gmail.com
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    public static boolean isValidatePassword(String str) {
        String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$";  //rasmi@gmail.com  //rasmi01@gmail.com
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    public static boolean isvalidateDate(String date) {

        String p = "^[0-9]{4}-(1[0-2]|0[1-9])-(3[01]|[12][0-9]|0[1-9])$";
        Pattern pattern = Pattern.compile(p);
        Matcher matcher = pattern.matcher(date);
        return matcher.matches();
//        if (matcher.matches()) {
//            System.out.println(date + " is valid date format");
//            return true;
//        } else {
//            System.out.println(date + " is invalid date format");
//            return false;
//        }
    }
}
