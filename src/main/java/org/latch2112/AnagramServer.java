package org.latch2112;

import static spark.Spark.get;
import static spark.Spark.halt;

import com.google.gson.Gson;

public class AnagramServer {

    public static void main(String[] args) {

        Gson gson = new Gson();

        get("/anagrams/:string1", (request, response) -> {
            String string1 = request.params(":string1");
            if (AnagramHelper.isStringValid(string1)) {
                response.type("application/json");
                return new AnagramsResponse(new String[]{});
            } else {
                return halt(400, "Bad Request");
            }
            }, gson::toJson);

        get("/anagrams/:string1/:string2", (request, response) -> {
            String string1 = request.params(":string1");
            String string2 = request.params(":string2");
            System.out.println("string1="+string1);
            if (AnagramHelper.isStringValid(string1) && AnagramHelper.isStringValid(string2)) {
                response.type("application/json");
                return new AreAnagramsResponse(AnagramHelper.isAnagram(string1,string2));
            } else {
                return halt(400, "Bad Request");
            }

        }, gson::toJson);
    }


}