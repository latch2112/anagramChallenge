package org.latch2112;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.*;


import org.latch2112.AnagramHelper;

public class AnagramTest {


    @BeforeAll
    static void setup() {
        AnagramHelper.initialiseEnglishDictionary();
    }

    @Test
    void testValidString() {
        System.out.println("Testing Valid String");
        Assertions.assertEquals( true, AnagramHelper.isStringValid("bob is bob"));
        Assertions.assertEquals( true, AnagramHelper.isStringValid("BOBisbob"));

    }

    @Test
    void testInvalidString() {
        System.out.println("Testing Invalid String");
        Assertions.assertEquals( false, AnagramHelper.isStringValid(""));
        Assertions.assertEquals( false, AnagramHelper.isStringValid("     "));
        Assertions.assertEquals( false, AnagramHelper.isStringValid(null));
        Assertions.assertEquals( false, AnagramHelper.isStringValid("123azs"));

    }

    @Test
    void testValidAnagram() {
        System.out.println("Testing Valid Anagrams");
        Assertions.assertEquals( true, AnagramHelper.isAnagram("cinema", "iceman"));
        Assertions.assertEquals( true, AnagramHelper.isAnagram("Debit card", "Bad credit"));
        Assertions.assertEquals( true, AnagramHelper.isAnagram("Election results", "Lies lets recount"));
    }

    @Test
    void testInvalidAnagram() {
        System.out.println("Testing Invalid Anagrams");
        Assertions.assertEquals( false, AnagramHelper.isAnagram("test", "whatever"));
        Assertions.assertEquals( false, AnagramHelper.isAnagram("Election results", "Lies – let's recount"));

    }

    @Test
    void testPermutations() {
        String[] array = {"cinema", "anemic", "iceman"};
        Set<String> expectedSets = new HashSet<>(Arrays.asList(array));
        Set<String> permutation = AnagramHelper.findPermutation("cinema");
        System.out.println(expectedSets);
        System.out.println(permutation);
        Assertions.assertEquals(true, expectedSets.equals(permutation));
    }

}