package com.alexander.programming.tests;

public class Palindrome {
    public static boolean isPalindrome(String input) {
        if (input == null || input.isEmpty() || input.isBlank()) {
            return false;
        }

        String reversed = "";
        for (int i = input.length(); i > 0; i--) {
            reversed = reversed + input.charAt(i-1);
        }
        System.out.println(reversed);
        if (reversed.equalsIgnoreCase(input)) {
            return true;
        }

        return false;
    }
}