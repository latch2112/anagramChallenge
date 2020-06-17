package org.latch2112;

public class AreAnagramsResponse {

    private boolean areAnagrams;

    AreAnagramsResponse(boolean areAnagrams) {
        this.areAnagrams = areAnagrams;
    }

    public boolean isAreAnagrams() {
        return areAnagrams;
    }

    public void setAreAnagrams(boolean areAnagrams) {
        this.areAnagrams = areAnagrams;
    }
}
