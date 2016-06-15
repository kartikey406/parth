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

        keywordToTextMap.put("hello","hello user");
        keywordToTextMap.put("what is your name","my name is leila.");
        keywordToTextMap.put("who is your master","my master is  bhaskar kalia.");

        keywordToTextMap.put("do you know gora","yes, gora is a good guy, we call him fandi. I love to hang out with him.");
        keywordToTextMap.put("do you know your master","yes, sir my master is a very good person, i always obey him.");

        keywordToTextMap.put("what do you eat","i eat power");
        keywordToTextMap.put("what is your birthdate","i was born on tuesday forteenth june two thousand and sixteen midnight");
        keywordToTextMap.put("what is your national anthem", "Jana gana mana adhinaayaka jaya hay, Bhaaratha Bhaagya Vidhaata ।\n" +
                "Punjab Sindhu Gujarat Maraatha, Draavida Utkala Banga ।\n" +
                "Vindhya Himaachala Yamuna Ganga, Ucchala jaladhi taranga ।\n" +
                "Tava Shubha naame jaage, Tava shubha aashisha maage ।\n" +
                "Gaahey tava jaya gaathaa ।\n" +
                "Jana Gana Mangala Daayaka jaya hay, Bhaaratha Bhaagya Vidhaata ।\n" +
                "Jaya hay, Jaya hay, Jaya hay ।\n" +
                "Jaya Jaya Jaya Jaya hay ।।");
        keywordToTextMap.put("fuck you","bhag bhosdy kay");
        keywordToTextMap.put("status","i can listen, i can speak and i can understand commands. soon i will be able to do things for you.");
        keywordToTextMap.put("how are you","i am fine. thanks for asking.");

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

        keyToTypeMap.put("what do you eat","speak");
        keyToTypeMap.put("what is your birthdate","speak");
        keyToTypeMap.put("what is your national anthem","speak");
        keyToTypeMap.put("fuck you","speak");
        keyToTypeMap.put("status","speak");
        keyToTypeMap.put("how are you","speak");

        keyToTypeMap.put("sleep","work");
    }


}
