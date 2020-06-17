package org.latch2112;

import java.util.Arrays;

public class AnagramHelper {

    // we assume string1 and string2 was previously validated
    static public boolean isAnagram(String string1, String string2) {

        string1 = string1.replaceAll("\\s", "");
        string2 = string2.replaceAll("\\s", "");

        if (string1.length() == string2.length()) {
            char[] arr1 = string1.toLowerCase().toCharArray();
            char[] arr2 = string2.toLowerCase().toCharArray();

            Arrays.sort(arr1);
            Arrays.sort(arr2);

            return (Arrays.equals(arr1, arr2));
        }
        return false;
    }

    static public boolean isStringValid(String stringToValidate) {

        return stringToValidate != null
                && !stringToValidate.trim().isEmpty()
                && stringToValidate.matches("[a-zA-Z ]*");
    }
}