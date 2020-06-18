package org.latch2112;

import com.google.gson.Gson;

import java.util.HashSet;
import java.util.Set;

import static spark.Spark.*;

public class AnagramServer {

    public static void main(String[] args) {

        port(80);

        Gson gson = new Gson();
        AnagramHelper.initialiseEnglishDictionary();

        get("/anagrams/:string1", (request, response) -> {
            String string1 = request.params(":string1");
            if (AnagramHelper.isStringValid(string1)) {
                response.type("application/json");
                Set<String> allPermutations = AnagramHelper.findPermutation(string1);
                return new AnagramsResponse(allPermutations);

            } else {
                response.type("application/json");
                response.status(400);
                return new AnagramsResponse(new HashSet<>());
            }
            }, gson::toJson);

        get("/anagrams/:string1/:string2", (request, response) -> {
            String string1 = request.params(":string1");
            String string2 = request.params(":string2");
            if (AnagramHelper.isStringValid(string1) && AnagramHelper.isStringValid(string2)) {
                response.type("application/json");
                return new AreAnagramsResponse(AnagramHelper.isAnagram(string1,string2));
            } else {
                response.type("application/json");
                response.status(400);
                return new AreAnagramsResponse(false);
            }
        }, gson::toJson);
    }


}