# anagramChallenge

Anagram Coding Challenge

## Definitions​:
Anagram: a word, phrase, or name formed by rearranging the letters of another, such as
cinema,​ formed from ​iceman​. 
## Problem​:
Please complete any or all of these problems in a public GitHub repository, and provide a link to the repository. Any documentation on running the solution will be appreciated.
1. Create a function which takes two ​String​ arguments, and returns a ​Boolean corresponding to whether or not the two ​String​ arguments are ​anagrams​ of each other.
2. Provide some unit tests for the function implemented in step 1.
3. Create a HTTP server which implements the following:
    
    a) Endpoint ​/anagrams/{string1}/{string2}
        
        - Returns a ​400​ - ​Bad Request​ if either s​tring1​ or ​string2​ are not valid
        
        - Returns a ​200 - OK​ with the following ​JSON​ payload: { ​areAnagrams​: true|false }
where ​areAnagrams​ is true or false, depending on whether ​string1​ and ​string2 are ​anagrams​ of each other.
    
    b) Endpoint ​/anagrams/{string1}
        
        - Returns a ​400 - Bad Request​ if s​ tring1​ is not valid
        
        - Returns a ​200 - OK​ with the following ​JSON p​ayload: { anagrams: [ ... ] } 
        where anagrams is an array of all possible anagrams of ​string1

4. Provide some unit/integration tests for the server implemented in step 3.

5. Containerize your project in a Docker container and include the Dockerfile and
docker-compose files with you project


## Architecture decision

- Java-Spark : tiny framework to make for a smaller container size;
- Multi-stage Docker Build to reduce final container size
- Integration test using Postman Collection (with JavaScript's Chai framework) and newman 

## To build and run the solution with docker:

```shell script
docker-compose up --build anagramServer
```

# To test:

## Integration tests:
```shell script
docker run --network host -t postman/newman run "https://www.getpostman.com/collections/7f56d87ab98e182e9f9a"
```

## Manual:
```shell script
curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://localhost/anagrams/cinema/iceman
```