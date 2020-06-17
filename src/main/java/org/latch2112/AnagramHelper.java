package org.latch2112;

public class AnagramHelper {

    boolean isAnagram(String string1, String string2) {

        return string1 != null && string2 != null && !string1.trim().isEmpty() && !string2.trim().isEmpty();

    }

}