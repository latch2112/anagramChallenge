
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.latch2112.AnagramHelper.*;

public class AnagramTest {


    @Test
    void testValidString() {
        System.out.println("Valid string");
        Assertions.assertEquals( true, AnagramHelper.isStringValid("bob is bob"));
        Assertions.assertEquals( true, AnagramHelper.isStringValid("BOBisbob"));

    }

    @Test
    void testInvalidString() {
        System.out.println("InValid string");
        Assertions.assertEquals( false, AnagramHelper.isStringValid(""));
        Assertions.assertEquals( false, AnagramHelper.isStringValid("     "));
        Assertions.assertEquals( false, AnagramHelper.isStringValid(null));
        Assertions.assertEquals( false, AnagramHelper.isStringValid("123azs"));

    }

    @Test
    void testValidAnagram() {
        System.out.println("Valid anagrams");
        Assertions.assertEquals( true, AnagramHelper.isAnagram("cinema", "iceman"));
        Assertions.assertEquals( true, AnagramHelper.isAnagram("Debit card", "Bad credit"));
        Assertions.assertEquals( true, AnagramHelper.isAnagram("Election results", "Lies lets recount"));
    }

    @Test
    void testInvalidAnagram() {
        System.out.println("Invalid anagrams");
        Assertions.assertEquals( false, AnagramHelper.isAnagram("test", "whatever"));
        Assertions.assertEquals( false, AnagramHelper.isAnagram("Election results", "Lies – let's recount"));

    }

}