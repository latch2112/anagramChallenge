package org.latch2112;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class AnagramHelper {

    // HashSet is used for fast retrieval
    static Set<String> englishWords = new HashSet<>();

    // we assume string1 and string2 was previously validated
    static public boolean isAnagram(String string1, String string2) {

        string1 = string1.replaceAll("\\s", "");
        string2 = string2.replaceAll("\\s", "");

        if (string1.length() != string2.length()) {
            return false;
        }

        char[] arr1 = string1.toLowerCase().toCharArray();
        char[] arr2 = string2.toLowerCase().toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return (Arrays.equals(arr1, arr2));

    }

    static public boolean isStringValid(String stringToValidate) {

        return stringToValidate != null
                && !stringToValidate.trim().isEmpty()
                && stringToValidate.matches("[a-zA-Z ]*");
    }

    public static void initialiseEnglishDictionary() {

        try (BufferedReader in = new BufferedReader(new FileReader(
                "web2"));) {
            String str;
            while ((str = in.readLine()) != null) {
                englishWords.add(str.toLowerCase());
            }

        } catch (IOException e) { }
    }

    public static boolean isEnglishWord(String str) {
        return englishWords.contains(str);
    }

    public static Set<String> findPermutation(String input) {

        input = input.replaceAll("\\s", "").toLowerCase();
        int inputLength = input.length();

        boolean[] alreadyUsedLetter = new boolean[ inputLength ];
        StringBuffer outputString = new StringBuffer();
        char[] in = input.toCharArray();

        Set<String> allWords = new HashSet<>();
        generateAllPermutationsAndKeepEnglishOnes(in, outputString, alreadyUsedLetter, inputLength, 0, allWords );
        return allWords;
    }

    public static void generateAllPermutationsAndKeepEnglishOnes(char[] in, StringBuffer outputString,
                         boolean[] alreadyUsedLetter, int inputLength, int level, Set<String> allWords) {

        // Only look for same length anagram
        if (level == inputLength) {
            if (isEnglishWord(outputString.toString())) {
                allWords.add(outputString.toString());
            }
        }

        // main loop for all possible permutations with actual number of letters
        for (int i = 0; i < inputLength; ++i) {

            if (alreadyUsedLetter[i]) continue;

            outputString.append(in[i]);
            alreadyUsedLetter[i] = true;
            generateAllPermutationsAndKeepEnglishOnes(in, outputString, alreadyUsedLetter, inputLength, level + 1, allWords);
            alreadyUsedLetter[i] = false;
            outputString.setLength(outputString.length() - 1);
        }
    }


    public static void main(String[] arg) {

        AnagramHelper.initialiseEnglishDictionary();
        String[] array = {"cinema", "anemic", "iceman"};
        Set<String> expectedSets = new HashSet<>(Arrays.asList(array));
        Set<String> permutation = AnagramHelper.findPermutation("cinema");
        System.out.println(expectedSets);
        System.out.println(permutation);
        System.out.println(expectedSets.equals(permutation));

    }

}