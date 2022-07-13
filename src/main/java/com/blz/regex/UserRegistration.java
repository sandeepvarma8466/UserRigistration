package com.blz.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegistration {
    public static final Scanner sc = new Scanner(System.in);
    public static final String FIRST_NAME = "^[A-Z][a-z]{2,}$";
    public static final String LAST_NAME = "^[A-Z][a-z]{2,}$";
    public static void main(String[] args) {
        System.out.println("Enter the first name of user : ");
        isValidFirstName(sc.nextLine());
        System.out.println("Enter the last name of user : ");
        isValidLastName(sc.nextLine());
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
    private static boolean isValidInput(String regex, String userInput) {
        return Pattern.matches(regex,userInput);
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
