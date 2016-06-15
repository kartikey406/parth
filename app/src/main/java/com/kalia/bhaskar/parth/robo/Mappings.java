package com.kalia.bhaskar.parth.robo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bhaskar on 15/6/16.
 */
public class Mappings {
    private Map<String,String> keyToTypeMap ;
    private Map<String, String> keywordToTextMap;

    public Mappings(){
        generateMaps();
    }

    public Map<String,String> getKeyToTypeMap(){
        return keyToTypeMap;
    }

    public Map<String,String> getKeywordToTextMap(){
        return keywordToTextMap;
    }

    private void generateMaps(){
         /*
        * c
        * map : {keyword:text to speak}
        * */

        keywordToTextMap = new HashMap<String, String>();

        keywordToTextMap.put("hello","hello sir");
        keywordToTextMap.put("what is your name","my name is leela.");
        keywordToTextMap.put("who is your master","my master is  bhaskar kalia.");
        keywordToTextMap.put("do you know gora","yes, gora is a good guy, we call him fandi. I love to hang out with him.");
        keywordToTextMap.put("do you know your master","yes, sir bhaskar is a very good person, i always obey him.");

        /*
        * Map<String,String>
        * put all keywords mapped to their type {keyword:type}
        * */

        keyToTypeMap = new HashMap<String,String>();

        keyToTypeMap.put("hello","speak");
        keyToTypeMap.put("what is your name","speak");
        keyToTypeMap.put("who is your master","speak");
        keyToTypeMap.put("do you know gora","speak");
        keyToTypeMap.put("do you know your master","speak");

        keyToTypeMap.put("sleep","work");
    }


}
