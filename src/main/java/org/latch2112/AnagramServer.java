package org.latch2112;

import static spark.Spark.get;
import com.google.gson.Gson;

public class AnagramServer {

    public static void main(String[] args) {
        
        Gson gson = new Gson();

        get("/hello", (request, response) -> {
            response.type("application/json");
            return new AnagramsResponse(new String[]{"Hello World"}); }, gson::toJson);

        get("/anagram", (request, response) -> {
            response.type("application/json");
            return new AreAnagramsResponse(true); }, gson::toJson);
    }


}