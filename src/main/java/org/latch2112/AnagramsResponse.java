package org.latch2112;

import java.util.Set;

public class AnagramsResponse {

    private Set<String> anagrams;

    AnagramsResponse(Set<String> anagrams) {
        this.anagrams = anagrams;
    }

    public Set<String> getAnagrams() {
        return anagrams;
    }

    public void setAnagrams(Set<String> anagrams) {
        this.anagrams = anagrams;
    }
}