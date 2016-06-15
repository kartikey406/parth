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
        keywordToTextMap.put("what is your name","my name is robo kaali");
        keywordToTextMap.put("who is your owner","my owner is  bhaskar kalia");
        keywordToTextMap.put("do you know gora","yes, gora is a good guy, we call him fandi");
        keywordToTextMap.put("do you know anoop","yes, kali is a good guy, we call him bhains");

        /*
        * Map<String,String>
        * put all keywords mapped to their type {keyword:type}
        * */

        keyToTypeMap = new HashMap<String,String>();
        keyToTypeMap.put("what is your name","speak");
        keyToTypeMap.put("who is your owner","speak");
        keyToTypeMap.put("hello","speak");
        keyToTypeMap.put("sleep","work");
        keyToTypeMap.put("do you know gora","speak");
        keyToTypeMap.put("do you know anoop","speak");
    }


}
