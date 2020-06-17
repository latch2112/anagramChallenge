package org.latch2112;

public class AnagramsResponse {

    private String[] anagrams;

    AnagramsResponse(String[] anagrams) {
        this.anagrams = anagrams;
    }

    public String[] getAnagrams() {
        return anagrams;
    }

    public void setAnagrams(String[] anagrams) {
        this.anagrams = anagrams;
    }
}