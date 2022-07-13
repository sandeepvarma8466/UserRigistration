package com.blz.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegistration {
    public static final Scanner sc = new Scanner(System.in);
    public static final String FIRST_NAME = "^[A-Z][a-z]{2,}$";
    public static final String LAST_NAME = "^[A-Z][a-z]{2,}$";
    public static final String EMAIL_REGEX = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
    public static final String PHONE_NUMBER = "^[1-9]{2}\\s{1}[1-9]{1}[0-9]{9}$";
    public static final String PASSWORD_RULE1 = "[A-Za-z]{8,}";

    public static void main(String[] args) {
        System.out.println("Enter the first name of user : ");
        isValidFirstName(sc.nextLine());
        System.out.println("Enter the last name of user : ");
        isValidLastName(sc.nextLine());
        System.out.println("Enter the Email address of user : ");
        isValidEmail(sc.nextLine());
        System.out.println("Enter the Mobile Number of user : ");
        isValidMobileNumber(sc.nextLine());
        System.out.println("Enter the Password of user : ");
        isValidPassword(sc.nextLine());
    }

    public static void isValidFirstName(String name) {
        try {
            if (isValidInput(FIRST_NAME, name)) {
                System.out.println("Valid First Name is: " + name);
            } else {
                throw new InvalidUserInformationException("Invalid First Name");
            }
        } catch (InvalidUserInformationException e) {
            System.out.println(e);
        }
    }

    public static void isValidLastName(String name) {
        try {
            if (isValidInput(LAST_NAME, name)) {
                System.out.println("Valid Last Name is: " + name);
            } else {
                throw new InvalidUserInformationException("Invalid Last Name");
            }
        } catch (InvalidUserInformationException e) {
            System.out.println(e);
        }
    }

    public static void isValidEmail(String name) {
        try {
            if (isValidInput(EMAIL_REGEX, name)) {
                System.out.println("Valid Email is: " + name);
            } else {
                throw new InvalidUserInformationException("Invalid Email");
            }
        } catch (InvalidUserInformationException e) {
            System.out.println(e);
        }
    }

    public static void isValidMobileNumber(String name) {
        try {
            if (isValidInput(PHONE_NUMBER, name)) {
                System.out.println("Valid Mobile Number is : " + name);
            } else {
                throw new InvalidUserInformationException("Invalid Mobile Number");
            }
        } catch (InvalidUserInformationException e){
            System.out.println(e);
        }
    }

    public static void isValidPassword(String name){
        try {
            if (isValidInput(PASSWORD_RULE1,name)){
                System.out.println("Valid Password : " +name);
            }else {
                throw new InvalidUserInformationException("Invalid Pasword");
            }
        }catch (InvalidUserInformationException e){
            System.out.println(e);
        }
    }

    private static boolean isValidInput(String regex, String userInput) {
        return Pattern.matches(regex, userInput);
    }
}

class InvalidUserInformationException extends RuntimeException {
    public InvalidUserInformationException() {
        super();
    }

    public InvalidUserInformationException(String msg) {
        super(msg);
    }
}
